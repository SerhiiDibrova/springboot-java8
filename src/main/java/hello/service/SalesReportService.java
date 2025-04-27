package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import hello.repository.SalesReportRepository;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

@Service
public class SalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalesReportRepository salesReportRepository;

    public void generateSalesReport(Integer orderId, Integer managerId, String xmlData, boolean isAuditNeeded) {
        createTemporaryTable();
        insertDataFromXML(xmlData);
        if (isAuditNeeded) {
            handleAuditLogic(orderId, managerId);
        }
        cleanupResources();
    }

    private void createTemporaryTable() {
        String sql = "CREATE TEMPORARY TABLE sales_report_temp (id INT, amount DECIMAL)";
        jdbcTemplate.execute(sql);
    }

    private void insertDataFromXML(String xmlData) {
        try {
            Document xmlDocument = parseXML(xmlData);
            String sql = "INSERT INTO sales_report_temp (id, amount) VALUES (?, ?)";
            jdbcTemplate.batchUpdate(sql, new Object[][] {
                { xmlDocument.getElementsByTagName("id").item(0).getTextContent(), 
                  xmlDocument.getElementsByTagName("amount").item(0).getTextContent() }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Document parseXML(String xmlData) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new ByteArrayInputStream(xmlData.getBytes()));
    }

    private File prepareXMLDocument() throws Exception {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("SalesReport");
        doc.appendChild(rootElement);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        File file = new File("sales_report.xml");
        StreamResult result = new StreamResult(new FileOutputStream(file));
        transformer.transform(source, result);
        return file;
    }

    private void handleAuditLogic(Integer orderId, Integer managerId) {
        String sql = "INSERT INTO audit_log (order_id, manager_id) VALUES (?, ?)";
        jdbcTemplate.update(sql, orderId, managerId);
    }

    private void cleanupResources() {
        String sql = "DROP TABLE IF EXISTS sales_report_temp";
        jdbcTemplate.execute(sql);
    }
}