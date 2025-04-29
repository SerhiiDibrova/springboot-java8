package hello.service;

import hello.repository.TempItemRepository;
import hello.dto.DisplayOptionsDTO;
import hello.entity.TempItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempItemService {

    private static final Logger logger = LoggerFactory.getLogger(TempItemService.class);

    @Autowired
    private TempItemRepository tempItemRepository;

    @Transactional
    public void insertTempItems(XMLDocument xmlDocument, Integer orderId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            org.w3c.dom.Document document = builder.parse(xmlDocument.getInputStream());

            String customerSegment = document.getElementsByTagName("CustomerSegment").item(0).getTextContent();
            String regionName = document.getElementsByTagName("RegionName").item(0).getTextContent();
            Double salesAmount = Double.valueOf(document.getElementsByTagName("SalesAmount").item(0).getTextContent());

            TempItem tempItem = new TempItem();
            tempItem.setCustomerSegment(customerSegment);
            tempItem.setRegionName(regionName);
            tempItem.setSalesAmount(salesAmount);
            tempItem.setOrderId(orderId);

            tempItemRepository.save(tempItem);
        } catch (ParserConfigurationException | IOException | TransformerException e) {
            logger.error("Error processing XML document", e);
            throw new RuntimeException("Error processing XML document", e);
        } catch (Exception e) {
            logger.error("Unexpected error during insertion", e);
            throw new RuntimeException("Unexpected error during insertion", e);
        }
    }

    public void populateTempItems() {
        try (Connection connection = tempItemRepository.getConnection()) {
            String createTableSQL = "CREATE TEMPORARY TABLE TempItems (id SERIAL PRIMARY KEY, customerSegment VARCHAR(255), regionName VARCHAR(255), salesAmount DECIMAL, orderId INTEGER)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(createTableSQL)) {
                preparedStatement.execute();
            }
            // Additional logic to populate the table can be added here
        } catch (SQLException e) {
            logger.error("Error creating or populating temporary table", e);
            throw new RuntimeException("Error creating or populating temporary table", e);
        }
    }

    public List<DisplayOptionsDTO> retrieveDisplayOptions() {
        List<DisplayOptionsDTO> displayOptions = new ArrayList<>();
        try {
            // Implementation for retrieving display options from the database
            // Example SQL logic to join tables and retrieve data
            // Add logic to populate displayOptions list
        } catch (Exception e) {
            logger.error("Error retrieving display options", e);
            throw new RuntimeException("Error retrieving display options", e);
        }
        return displayOptions;
    }
}