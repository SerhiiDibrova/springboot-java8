package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import hello.repository.TempItemRepository;
import hello.entity.TempItem;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertTempItems(Long orderId, String xmlData) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("Order ID and XML data must not be null or empty");
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            NodeList itemList = document.getElementsByTagName("TempItem");

            for (int i = 0; i < itemList.getLength(); i++) {
                String field1 = itemList.item(i).getAttributes().getNamedItem("field1") != null ? 
                                itemList.item(i).getAttributes().getNamedItem("field1").getNodeValue() : null;
                String field2 = itemList.item(i).getAttributes().getNamedItem("field2") != null ? 
                                itemList.item(i).getAttributes().getNamedItem("field2").getNodeValue() : null;
                String field3 = itemList.item(i).getAttributes().getNamedItem("field3") != null ? 
                                itemList.item(i).getAttributes().getNamedItem("field3").getNodeValue() : null;

                if (field1 == null || field2 == null || field3 == null) {
                    throw new IllegalArgumentException("Missing required fields in XML data");
                }

                TempItem tempItem = new TempItem();
                tempItem.setOrderId(orderId);
                tempItem.setField1(field1);
                tempItem.setField2(field2);
                tempItem.setField3(field3);
                tempItemRepository.save(tempItem);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Error processing XML data", e);
        }
    }
}