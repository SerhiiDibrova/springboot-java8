package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import hello.model.SalesReportRequest;
import hello.model.SalesReportResponse;
import hello.repository.SalesReportRepository;
import hello.service.AuditService;
import hello.service.SalesDataService;
import hello.service.WarehouseDataService;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import javax.xml.transform.TransformerException;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import java.io.IOException;

@Service
public class SalesReportService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SalesReportRepository salesReportRepository;

    @Autowired
    private AuditService auditService;

    @Autowired
    private SalesDataService salesDataService;

    @Autowired
    private WarehouseDataService warehouseDataService;

    public SalesReportResponse generateSalesReport(SalesReportRequest request) {
        SalesReportResponse response = new SalesReportResponse();
        try {
            prepareTemporaryTables();
            auditService.retrieveAuditData(request);
            salesDataService.processSalesData(request);
            warehouseDataService.processWarehouseData(request);
            response.setSuccess(true);
            response.setMessage("Sales report generated successfully.");
        } catch (Exception e) {
            response.setSuccess(false);
            response.setMessage("Error generating sales report: " + e.getMessage());
        }
        return response;
    }

    private void prepareTemporaryTables() {
        String sql = "CREATE TEMPORARY TABLE sales_temp AS SELECT * FROM sales WHERE 1=0; " +
                     "CREATE TEMPORARY TABLE warehouse_temp AS SELECT * FROM warehouse WHERE 1=0;";
        jdbcTemplate.execute(sql);
    }

    private Document parseXML(String xml) throws ParserConfigurationException, SAXException, IOException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(new InputSource(new StringReader(xml)));
    }
}