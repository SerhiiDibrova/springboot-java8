package hello.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.Map;

@Service
public class JsonToXmlService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public ResponseEntity<String> convertJsonToXml(MultipartFile file, String acceptHeader) {
        if (file == null || !"application/json".equals(file.getContentType())) {
            return ErrorResponseController.createErrorResponse("Invalid content type. Expected application/json", HttpStatus.BAD_REQUEST);
        }

        try {
            Map<String, Object> jsonMap = objectMapper.readValue(file.getInputStream(), Map.class);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            XMLParser.parseJsonToXml(jsonMap, document);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StringWriter stringWriter = new StringWriter();
            StreamResult result = new StreamResult(stringWriter);
            transformer.transform(source, result);
            String xmlString = stringWriter.toString();

            if ("application/xml".equals(acceptHeader)) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, "application/xml")
                        .body(xmlString);
            } else {
                return ResponseUtil.createSuccessResponse("XML conversion successful", xmlString);
            }
        } catch (Exception e) {
            return ErrorResponseController.createErrorResponse("Error processing file: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}