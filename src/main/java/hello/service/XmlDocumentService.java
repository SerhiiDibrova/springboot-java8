

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import hello.dto.XmlDocumentDTO;
import hello.entity.XmlDocumentEntity;
import hello.repository.XmlDocumentRepository;

@Service
public class XmlDocumentService {

    private static final Logger LOGGER = LoggerFactory.getLogger(XmlDocumentService.class);

    private XmlDocumentRepository xmlDocumentRepository;

    @Autowired
    public XmlDocumentService(XmlDocumentRepository xmlDocumentRepository) {
        this.xmlDocumentRepository = xmlDocumentRepository;
    }

    @Transactional
    public XmlDocumentDTO prepareXmlDocument(String xmlData) {
        if (xmlData == null || xmlData.isEmpty()) {
            LOGGER.error("Invalid input: xmlData is null or empty");
            throw new IllegalArgumentException("xmlData cannot be null or empty");
        }

        try {
            XmlDocumentEntity xmlDocumentEntity = new XmlDocumentEntity(xmlData);
            String handle = xmlDocumentRepository.prepareXmlDocument(xmlDocumentEntity);
            return new XmlDocumentDTO(xmlData, handle);
        } catch (Exception e) {
            LOGGER.error("Error preparing XML document", e);
            throw new RuntimeException("Error preparing XML document", e);
        }
    }
}