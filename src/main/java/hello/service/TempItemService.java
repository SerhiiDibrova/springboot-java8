package hello.service;

import hello.dto.TempItemDTO;
import hello.entity.TempItem;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.List;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void insertTempItems(TempItemDTO tempItemDTO) throws ParserConfigurationException, IOException, TransformerException {
        String xmlData = tempItemDTO.getXmlData();
        TempItem tempItem = parseXmlToTempItem(xmlData);
        tempItemRepository.save(tempItem);
    }

    private TempItem parseXmlToTempItem(String xmlData) throws ParserConfigurationException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        var doc = builder.parse(new ByteArrayInputStream(xmlData.getBytes(StandardCharsets.UTF_8)));
        TempItem tempItem = new TempItem();
        // Populate tempItem fields from XML
        tempItem.setField1(doc.getElementsByTagName("Field1").item(0).getTextContent());
        tempItem.setField2(doc.getElementsByTagName("Field2").item(0).getTextContent());
        // Add additional fields as necessary
        return tempItem;
    }

    @Transactional
    public void createTempItems() throws SQLException {
        entityManager.createNativeQuery("CREATE TABLE #TempItems (Field1 VARCHAR(255), Field2 VARCHAR(255))").executeUpdate();
        entityManager.createNativeQuery("INSERT INTO #TempItems (Field1, Field2) SELECT Field1, Field2 FROM SomeSourceTable").executeUpdate();
    }

    public List<Object[]> retrieveDisplayOptions() {
        String query = "SELECT * FROM CustomConfig WHERE moduleType = :moduleType UNION SELECT * FROM LegacyConfig WHERE moduleType = :moduleType";
        return entityManager.createNativeQuery(query)
                .setParameter("moduleType", "desiredModuleType")
                .getResultList();
    }
}