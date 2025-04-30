package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private final DisplayOptionsRepository displayOptionsRepository;
    private final ErrorHandlingService errorHandlingService;

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository, 
                           DisplayOptionsRepository displayOptionsRepository, 
                           ErrorHandlingService errorHandlingService) {
        this.tempItemRepository = tempItemRepository;
        this.displayOptionsRepository = displayOptionsRepository;
        this.errorHandlingService = errorHandlingService;
    }

    @Transactional
    public void insertTempItems(Integer orderId, String xmlData) {
        if (orderId == null || xmlData == null || xmlData.isEmpty()) {
            throw new IllegalArgumentException("Order ID and XML data must not be null or empty");
        }
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
            NodeList filters = document.getElementsByTagName("Filter");

            for (int i = 0; i < filters.getLength(); i++) {
                Element filter = (Element) filters.item(i);
                TempItem tempItem = new TempItem();
                tempItem.setOrderId(orderId);
                tempItem.setField1(filter.getElementsByTagName("Field1").item(0).getTextContent());
                tempItem.setField2(filter.getElementsByTagName("Field2").item(0).getTextContent());
                tempItemRepository.save(tempItem);
            }
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            errorHandlingService.handleError(e);
        }
    }

    public void createTempItems() {
        // Implementation for creating TempItems table if not exists
        tempItemRepository.createTableIfNotExists();
    }

    public void populateTempItems() {
        // Implementation for populating TempItems table
        tempItemRepository.populateTable();
    }

    public Set<String> retrieveDisplayOptionsForSales() {
        Set<String> options = new HashSet<>();
        options.addAll(displayOptionsRepository.findSalesOptions());
        return options;
    }

    public Set<String> retrieveDisplayOptionsForMarketingData() {
        Set<String> options = new HashSet<>();
        options.addAll(displayOptionsRepository.findMarketingOptions());
        return options;
    }
}