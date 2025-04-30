package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class TempItemService {

    private final TempItemRepository tempItemRepository;
    private final DataSource dataSource;

    @Autowired
    public TempItemService(TempItemRepository tempItemRepository, DataSource dataSource) {
        this.tempItemRepository = tempItemRepository;
        this.dataSource = dataSource;
    }

    public void insertTempItems(Integer orderId, String xmlData) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(xmlData)));
            Element root = document.getDocumentElement();
            NodeList filters = root.getElementsByTagName("Filters");
            NodeList filterList = filters.item(0).getChildNodes();

            for (int i = 0; i < filterList.getLength(); i++) {
                if (filterList.item(i) instanceof Element) {
                    Element filter = (Element) filterList.item(i);
                    TempItem tempItem = new TempItem();
                    tempItem.setOrderId(orderId);
                    tempItem.setField1(filter.getElementsByTagName("Field1").item(0).getTextContent());
                    tempItem.setField2(filter.getElementsByTagName("Field2").item(0).getTextContent());
                    // Set other fields as necessary
                    tempItemRepository.save(tempItem);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // Log error
        }
    }

    public void createTempItems() {
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'CustomConfig'");
            if (rs.next() && rs.getInt(1) > 0) {
                rs = statement.executeQuery("SELECT COUNT(*) FROM information_schema.tables WHERE table_name = 'LegacyConfig'");
                if (rs.next() && rs.getInt(1) > 0) {
                    statement.execute("CREATE TABLE #TempItems (Field1 VARCHAR(255), Field2 VARCHAR(255))");
                }
            }
        } catch (SQLException e) {
            // Log error
        }
    }

    public List<DisplayOption> retrieveDisplayOptions() {
        List<DisplayOption> displayOptions = new ArrayList<>();
        try (Connection connection = dataSource.getConnection(); Statement statement = connection.createStatement()) {
            ResultSet rs = statement.executeQuery("SELECT * FROM CustomConfig UNION SELECT * FROM LegacyConfig");
            while (rs.next()) {
                DisplayOption option = new DisplayOption();
                option.setField1(rs.getString("Field1"));
                option.setField2(rs.getString("Field2"));
                displayOptions.add(option);
            }
        } catch (SQLException e) {
            // Log error
        }
        return displayOptions;
    }
}