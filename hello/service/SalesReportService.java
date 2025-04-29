package hello.service;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SalesReportService {
    private SalesReportRepository salesReportRepository;

    public SalesReportService(SalesReportRepository salesReportRepository) {
        this.salesReportRepository = salesReportRepository;
    }

    public void generateSalesReport(String orderId, String managerId, String xmlData, boolean isAuditNeeded) {
        Connection connection = null;
        try {
            connection = salesReportRepository.getConnection();
            connection.setAutoCommit(false);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            InputStream inputStream = new ByteArrayInputStream(xmlData.getBytes());
            Document document = builder.parse(inputStream);
            processXMLData(document, connection);
            if (isAuditNeeded) {
                String defaultManagerId = salesReportRepository.getDefaultManagerId();
                insertAuditData(orderId, defaultManagerId, connection);
            }
            connection.commit();
        } catch (ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void processXMLData(Document document, Connection connection) throws SQLException {
        NodeList nodeList = document.getElementsByTagName("record");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String dataField1 = element.getElementsByTagName("field1").item(0).getTextContent();
                String dataField2 = element.getElementsByTagName("field2").item(0).getTextContent();
                if (isValidData(dataField1, dataField2)) {
                    insertData(dataField1, dataField2, connection);
                }
            }
        }
    }

    private boolean isValidData(String field1, String field2) {
        return field1 != null && !field1.isEmpty() && field2 != null && !field2.isEmpty();
    }

    private void insertData(String field1, String field2, Connection connection) throws SQLException {
        String insertSQL = "INSERT INTO sales_data (field1, field2) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertSQL)) {
            preparedStatement.setString(1, field1);
            preparedStatement.setString(2, field2);
            preparedStatement.executeUpdate();
        }
    }

    private void insertAuditData(String orderId, String managerId, Connection connection) throws SQLException {
        String auditSQL = "INSERT INTO audit_log (order_id, manager_id) VALUES (?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(auditSQL)) {
            preparedStatement.setString(1, orderId);
            preparedStatement.setString(2, managerId);
            preparedStatement.executeUpdate();
        }
    }
}