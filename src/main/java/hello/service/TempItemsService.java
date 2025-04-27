package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class TempItemsService {

    private static final Logger logger = Logger.getLogger(TempItemsService.class.getName());

    @Autowired
    private TempItemsRepository tempItemsRepository;

    public List<TempItems> getTempItems() {
        return tempItemsRepository.findAll();
    }

    public void insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            NodeList itemNodes = document.getElementsByTagName("item");
            for (int i = 0; i < itemNodes.getLength(); i++) {
                TempItems tempItems = new TempItems();
                tempItems.setOrderId(orderId);
                if (itemNodes.item(i).getElementsByTagName("field1").getLength() > 0) {
                    tempItems.setField1(itemNodes.item(i).getElementsByTagName("field1").item(0).getTextContent());
                }
                if (itemNodes.item(i).getElementsByTagName("field2").getLength() > 0) {
                    tempItems.setField2(itemNodes.item(i).getElementsByTagName("field2").item(0).getTextContent());
                }
                tempItemsRepository.save(tempItems);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.log(Level.SEVERE, "Error processing XML data", e);
            throw new RuntimeException("Failed to insert temp items", e);
        }
    }
}