package hello.service;

import hello.repository.CustomConfigRepository;
import hello.repository.DisplayOptionsRepository;
import hello.repository.LegacyConfigRepository;
import hello.repository.TempItemRepository;
import hello.entity.DisplayOptions;
import hello.entity.TempItem;
import hello.entity.CustomConfig;
import hello.entity.LegacyConfig;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private final CustomConfigRepository customConfigRepository;
    private final LegacyConfigRepository legacyConfigRepository;
    private final DisplayOptionsRepository displayOptionsRepository;
    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    public TempItemService(TempItemRepository tempItemRepository, CustomConfigRepository customConfigRepository,
                           LegacyConfigRepository legacyConfigRepository, DisplayOptionsRepository displayOptionsRepository) {
        this.tempItemRepository = tempItemRepository;
        this.customConfigRepository = customConfigRepository;
        this.legacyConfigRepository = legacyConfigRepository;
        this.displayOptionsRepository = displayOptionsRepository;
    }

    public void insertTempItems(Integer orderId, String xmlData) {
        if (xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("XML data cannot be null or empty");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));
            NodeList nodeList = document.getElementsByTagName("Filter");
            if (nodeList.getLength() > 0) {
                Element element = (Element) nodeList.item(0);
                TempItem tempItem = new TempItem();
                tempItem.setOrderId(orderId);
                tempItem.setCustomerSegment(element.getElementsByTagName("CustomerSegment").item(0).getTextContent());
                tempItemRepository.save(tempItem);
            } else {
                logger.error("Expected XML structure not found");
                throw new RuntimeException("Expected XML structure not found");
            }
        } catch (Exception e) {
            logger.error("Failed to insert temporary items", e);
            throw new RuntimeException("Failed to insert temporary items", e);
        }
    }

    public List<DisplayOptions> retrieveDisplayOptions() {
        Set<DisplayOptions> displayOptionsSet = new HashSet<>();
        List<CustomConfig> customConfigs = customConfigRepository.findByModule("SALES");
        for (CustomConfig customConfig : customConfigs) {
            List<DisplayOptions> options = displayOptionsRepository.findByConfigId(customConfig.getConfigId());
            displayOptionsSet.addAll(options);
        }

        List<LegacyConfig> legacyConfigs = legacyConfigRepository.findByModule("MARKETING_DATA");
        for (LegacyConfig legacyConfig : legacyConfigs) {
            List<DisplayOptions> options = displayOptionsRepository.findByConfigId(legacyConfig.getConfigId());
            displayOptionsSet.addAll(options);
        }

        return new ArrayList<>(displayOptionsSet);
    }
}