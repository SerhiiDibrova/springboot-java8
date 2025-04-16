

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

@Service
public class InsertDataFromXml {

    private final JdbcTemplate jdbcTemplate;
    private final Resource xmlFile;

    @Autowired
    public InsertDataFromXml(JdbcTemplate jdbcTemplate, @Value("classpath:your_xml_file.xml") Resource xmlFile) {
        this.jdbcTemplate = jdbcTemplate;
        this.xmlFile = xmlFile;
    }

    @Transactional
    public void insertDataFromXml(String orderId) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile.getFile());
            NodeList nodeList = doc.getElementsByTagName("your_tag_name");
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String yourValue = element.getElementsByTagName("your_tag_name").item(0).getTextContent();
                    KeyHolder keyHolder = new GeneratedKeyHolder();
                    jdbcTemplate.update(new PreparedStatementCreator() {
                        @Override
                        public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO your_table_name (column_name) VALUES (?)", new String[]{"id"});
                            pstmt.setString(1, yourValue);
                            return pstmt;
                        }
                    }, keyHolder);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            // handle exception
        }
    }
}