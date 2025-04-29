package hello.service;

import hello.repository.TempItemRepository;
import hello.entity.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    public void insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlData);
            document.getDocumentElement().normalize();

            NodeList nodeList = document.getElementsByTagName("TempItem");
            if (nodeList.getLength() == 0) {
                logger.warn("No TempItem elements found in the provided XML data.");
                return;
            }

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                String name = element.getElementsByTagName("name").item(0).getTextContent();
                Integer quantity = Integer.parseInt(element.getElementsByTagName("quantity").item(0).getTextContent());
                Double price = Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent());

                TempItem tempItem = new TempItem();
                tempItem.setOrderId(orderId);
                tempItem.setName(name);
                tempItem.setQuantity(quantity);
                tempItem.setPrice(price);

                tempItemRepository.save(tempItem);
                logger.info("TempItem saved: {}", tempItem);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            logger.error("Error parsing XML data: {}", e.getMessage());
        } catch (NumberFormatException e) {
            logger.error("Error converting XML data to number: {}", e.getMessage());
        }
    }
}