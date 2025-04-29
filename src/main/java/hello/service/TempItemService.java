package hello.service;

import hello.dto.TempItemDTO;
import hello.entity.TempItem;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository) {
        this.tempItemRepository = tempItemRepository;
    }

    @Transactional
    public void insertTempItems(TempItemDTO tempItemDTO, Integer orderId) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(tempItemDTO.getXmlData())));
            NodeList nodeList = document.getElementsByTagName("TempItem");

            for (int i = 0; i < nodeList.getLength(); i++) {
                TempItem tempItem = new TempItem();
                // Extract and validate properties from nodeList here
                // Example: tempItem.setProperty(value);
                tempItem.setOrderId(orderId);
                tempItemRepository.save(tempItem);
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Error processing XML data", e);
        }
    }

    public List<TempItemDTO> getTempItems() {
        return tempItemRepository.findAll().stream()
                .map(tempItem -> new TempItemDTO(tempItem))
                .toList();
    }

    @Transactional
    public void deleteTempItem(Long id) {
        try {
            tempItemRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Error deleting TempItem with id: " + id, e);
        }
    }

    @Transactional
    public void updateTempItem(Long id, TempItemDTO tempItemDTO) {
        try {
            TempItem tempItem = tempItemRepository.findById(id).orElseThrow(() -> new RuntimeException("TempItem not found"));
            // Update properties from tempItemDTO
            // Example: tempItem.setProperty(tempItemDTO.getProperty());
            tempItemRepository.save(tempItem);
        } catch (Exception e) {
            throw new RuntimeException("Error updating TempItem with id: " + id, e);
        }
    }
}