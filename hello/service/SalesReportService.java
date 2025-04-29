package hello.service;

import hello.repository.SalesReportRepository;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class SalesReportService {
    private SalesReportRepository salesReportRepository;
    private static final Logger logger = Logger.getLogger(SalesReportService.class.getName());

    public SalesReportService(SalesReportRepository salesReportRepository) {
        this.salesReportRepository = salesReportRepository;
    }

    public void getSalesReport(String orderId, String managerId, String xmlData, boolean audit) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element rootElement = document.createElement("SalesReport");
            document.appendChild(rootElement);

            // Logic to parse xmlData and populate the document
            Element dataElement = document.createElement("Data");
            dataElement.setTextContent(xmlData);
            rootElement.appendChild(dataElement);

            if (audit) {
                logger.info("Audit log for orderId: " + orderId + ", managerId: " + managerId);
                // Logic to store audit information
            }

            Map<String, String> tempData = new HashMap<>();
            tempData.put("orderId", orderId);
            tempData.put("managerId", managerId);

            saveReport(document, orderId);

        } catch (Exception e) {
            logger.severe("Error generating sales report: " + e.getMessage());
        }
    }

    private void saveReport(Document document, String orderId) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("SalesReport_" + orderId + ".xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            logger.severe("Error saving sales report: " + e.getMessage());
        }
    }
}