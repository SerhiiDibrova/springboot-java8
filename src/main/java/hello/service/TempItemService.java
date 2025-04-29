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
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    private static final Logger logger = Logger.getLogger(TempItemService.class.getName());

    @Transactional
    public boolean insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            NodeList nodeList = document.getElementsByTagName("TempItem");

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getAttributes().getNamedItem("field1") != null &&
                    nodeList.item(i).getAttributes().getNamedItem("field2") != null &&
                    nodeList.item(i).getAttributes().getNamedItem("field3") != null) {
                    
                    TempItem tempItem = new TempItem();
                    tempItem.setOrderId(orderId);
                    tempItem.setField1(nodeList.item(i).getAttributes().getNamedItem("field1").getNodeValue());
                    tempItem.setField2(Integer.parseInt(nodeList.item(i).getAttributes().getNamedItem("field2").getNodeValue()));
                    tempItem.setField3(Double.parseDouble(nodeList.item(i).getAttributes().getNamedItem("field3").getNodeValue()));
                    tempItemRepository.save(tempItem);
                } else {
                    logger.log(Level.WARNING, "Missing attributes in TempItem at index: " + i);
                }
            }
            logger.log(Level.INFO, "Successfully inserted TempItems for orderId: " + orderId);
            return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.log(Level.SEVERE, "Error parsing XML data", e);
            return false;
        } catch (NumberFormatException e) {
            logger.log(Level.SEVERE, "Error converting data types", e);
            return false;
        }
    }
}