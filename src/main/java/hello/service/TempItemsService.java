package hello.service;

import hello.repository.TempItemsRepository;
import hello.model.TempItems;
import hello.model.DisplayOptions;
import hello.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.xml.sax.InputSource;

public class TempItemsService {
    private static final Logger log = LoggerFactory.getLogger(TempItemsService.class);
    private final TempItemsRepository tempItemsRepository;

    public TempItemsService(TempItemsRepository tempItemsRepository) {
        this.tempItemsRepository = tempItemsRepository;
    }

    public void insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));

            String customerSegment = document.getElementsByTagName("CustomerSegment").item(0).getTextContent();
            String regionName = document.getElementsByTagName("RegionName").item(0).getTextContent();
            String productName = document.getElementsByTagName("ProductName").item(0).getTextContent();
            String quantity = document.getElementsByTagName("Quantity").item(0).getTextContent();
            String price = document.getElementsByTagName("Price").item(0).getTextContent();

            TempItems tempItems = new TempItems();
            tempItems.setOrderId(orderId);
            tempItems.setCustomerSegment(customerSegment);
            tempItems.setRegionName(regionName);
            tempItems.setProductName(productName);
            tempItems.setQuantity(Integer.parseInt(quantity));
            tempItems.setPrice(Double.parseDouble(price));

            tempItemsRepository.save(tempItems);
        } catch (Exception e) {
            log.error("Error inserting temp items: " + e.getMessage(), e);
            throw new CustomException("Failed to insert temp items", e);
        }
    }

    public List<DisplayOptions> generateDisplayOptions(Integer orderId) {
        if (orderId == null) {
            throw new IllegalArgumentException("Order ID cannot be null");
        }
        List<DisplayOptions> salesOptions;
        List<DisplayOptions> marketingOptions;
        try {
            salesOptions = tempItemsRepository.findDisplayOptionsForSales(orderId);
            marketingOptions = tempItemsRepository.findDisplayOptionsForMarketingData(orderId);
        } catch (Exception e) {
            log.error("Error retrieving display options: " + e.getMessage(), e);
            return new ArrayList<>();
        }
        Set<DisplayOptions> combinedOptions = new HashSet<>();
        combinedOptions.addAll(salesOptions);
        combinedOptions.addAll(marketingOptions);
        return new ArrayList<>(combinedOptions);
    }
}