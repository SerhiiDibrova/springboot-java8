package hello.service;

import hello.dto.TempItemDTO;
import hello.repository.TempItemRepository;
import hello.entity.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class TempItemService {

    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertTempItems(TempItemDTO tempItemDTO) {
        try {
            String xmlData = tempItemDTO.getXmlData();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            NodeList itemNodes = document.getElementsByTagName("item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                TempItem tempItem = new TempItem();
                tempItem.setOrderId(tempItemDTO.getOrderId());
                String field1 = itemNodes.item(i).getAttributes().getNamedItem("field1") != null ? 
                                itemNodes.item(i).getAttributes().getNamedItem("field1").getNodeValue() : null;
                String field2 = itemNodes.item(i).getAttributes().getNamedItem("field2") != null ? 
                                itemNodes.item(i).getAttributes().getNamedItem("field2").getNodeValue() : null;

                if (field1 == null || field2 == null) {
                    logger.error("Missing required fields in XML data for item index: {}", i);
                    throw new IllegalArgumentException("Required fields are missing in XML data");
                }

                tempItem.setField1(field1);
                tempItem.setField2(field2);
                tempItemRepository.save(tempItem);
            }
        } catch (Exception e) {
            logger.error("Error processing XML data", e);
            throw new RuntimeException("Error processing XML data", e);
        }
    }
}