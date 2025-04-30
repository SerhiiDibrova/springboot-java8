package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import hello.repository.TempItemRepository;
import hello.entity.TempItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.io.StringReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

@Service
@Transactional
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertTempItems(Integer orderId, String xmlData) {
        if (orderId == null || !isWellFormedXML(xmlData)) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        try {
            jdbcTemplate.execute("CREATE TEMPORARY TABLE #TempItems (OrderId INT, Field1 VARCHAR(255), Field2 VARCHAR(255))");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));
            NodeList nodeList = document.getElementsByTagName("TempItem");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Element element = (Element) nodeList.item(i);
                TempItem tempItem = new TempItem();
                tempItem.setOrderId(orderId);
                tempItem.setField1(element.getElementsByTagName("Field1").item(0).getTextContent());
                tempItem.setField2(element.getElementsByTagName("Field2").item(0).getTextContent());

                tempItemRepository.save(tempItem);
                jdbcTemplate.update("INSERT INTO #TempItems (OrderId, Field1, Field2) VALUES (?, ?, ?)", 
                    orderId, tempItem.getField1(), tempItem.getField2());
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException("Error parsing XML data", e);
        } catch (DataAccessException e) {
            throw new RuntimeException("Error saving TempItem", e);
        }
    }

    public List<DisplayOption> retrieveDisplayOptions() {
        try {
            List<DisplayOption> salesOptions = jdbcTemplate.query("SELECT * FROM #TempItems t JOIN CustomConfig c ON t.OrderId = c.OrderId JOIN DisplayOptions d ON c.ConfigId = d.ConfigId WHERE d.Module = 'SALES'", 
                new RowMapper<DisplayOption>() {
                    public DisplayOption mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new DisplayOption(rs.getString("OptionName"));
                    }
                });
            List<DisplayOption> marketingOptions = jdbcTemplate.query("SELECT * FROM #TempItems t JOIN LegacyConfig l ON t.OrderId = l.OrderId JOIN DisplayOptions d ON l.ConfigId = d.ConfigId WHERE d.Module = 'MARKETING_DATA'", 
                new RowMapper<DisplayOption>() {
                    public DisplayOption mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return new DisplayOption(rs.getString("OptionName"));
                    }
                });
            salesOptions.addAll(marketingOptions);
            return salesOptions.stream().distinct().collect(Collectors.toList());
        } catch (DataAccessException e) {
            throw new RuntimeException("Error retrieving display options", e);
        }
    }

    private boolean isWellFormedXML(String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new StringReader(xmlData)));
            return true;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            return false;
        }
    }
}