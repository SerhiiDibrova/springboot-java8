package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private CustomConfigRepository customConfigRepository;

    @Autowired
    private LegacyConfigRepository legacyConfigRepository;

    @Autowired
    private DisplayOptionsRepository displayOptionsRepository;

    @Transactional
    public void insertTempItems(String xmlData, Integer orderId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            TempItemDTO tempItemDTO = extractTempItemDTO(document);
            TempItem tempItem = new TempItem();
            tempItem.setField1(tempItemDTO.getField1());
            tempItem.setField2(tempItemDTO.getField2());
            tempItem.setOrderId(orderId);
            tempItemRepository.save(tempItem);
        } catch (ParserConfigurationException | IOException | SQLException e) {
            throw new RuntimeException("Error processing XML data", e);
        }
    }

    private TempItemDTO extractTempItemDTO(Document document) {
        TempItemDTO tempItemDTO = new TempItemDTO();
        NodeList nodeList = document.getElementsByTagName("TempItem");
        if (nodeList.getLength() > 0) {
            tempItemDTO.setField1(nodeList.item(0).getAttributes().getNamedItem("field1").getNodeValue());
            tempItemDTO.setField2(nodeList.item(0).getAttributes().getNamedItem("field2").getNodeValue());
        }
        return tempItemDTO;
    }

    @Transactional
    public void populateTempItems() {
        // Logic to create and populate TempItems table
        tempItemRepository.createTempItemsTable();
        tempItemRepository.populateTempItems();
    }

    public List<DisplayOption> retrieveDisplayOptions() {
        List<DisplayOption> salesOptions = customConfigRepository.findSalesOptions();
        List<DisplayOption> marketingOptions = legacyConfigRepository.findMarketingOptions();
        List<DisplayOption> combinedOptions = new ArrayList<>(salesOptions);
        combinedOptions.addAll(marketingOptions);
        return combinedOptions;
    }
}