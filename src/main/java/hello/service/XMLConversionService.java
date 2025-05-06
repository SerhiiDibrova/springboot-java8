package hello.service;

import hello.model.JSONType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;

@Service
public class XMLConversionService {

    private static final Logger logger = LoggerFactory.getLogger(XMLConversionService.class);

    public JSONType convertXmlToJson(MultipartFile file) {
        validateXmlFile(file);
        try {
            return XMLParser.parse_xml_from_file(file.getInputStream());
        } catch (IOException e) {
            logger.error("Error processing XML file", e);
            throw new RuntimeException("Error processing XML file", e);
        } catch (Exception e) {
            logger.error("Unexpected error during XML conversion", e);
            throw new RuntimeException("Unexpected error during XML conversion", e);
        }
    }

    private void validateXmlFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty");
        }
        if (!file.getContentType().equals("application/xml")) {
            throw new IllegalArgumentException("File is not a valid XML");
        }
        try (InputStream inputStream = file.getInputStream()) {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(inputStream);
        } catch (ParserConfigurationException | IOException e) {
            throw new IllegalArgumentException("Invalid XML file", e);
        } catch (Exception e) {
            throw new RuntimeException("Error validating XML file", e);
        }
    }
}