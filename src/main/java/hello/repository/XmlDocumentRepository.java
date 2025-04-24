

package hello.repository;

import org.springframework.data.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Optional;

@Entity
class XmlDocumentEntity {
    @Id
    private Long id;
    private String xmlData;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }
}

class XmlDocumentDTO {
    private Long id;
    private String xmlData;

    public XmlDocumentDTO(Long id, String xmlData) {
        this.id = id;
        this.xmlData = xmlData;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlData() {
        return xmlData;
    }

    public void setXmlData(String xmlData) {
        this.xmlData = xmlData;
    }
}

@Repository
public interface XmlDocumentRepository extends JpaRepository<XmlDocumentEntity, Long> {

    default XmlDocumentDTO prepareXmlDocument(XmlDocumentEntity xmlDocumentEntity, JdbcTemplate jdbcTemplate) {
        Optional<XmlDocumentEntity> entity = findById(xmlDocumentEntity.getId());
        if (entity.isPresent()) {
            return new XmlDocumentDTO(entity.get().getId(), entity.get().getXmlData());
        } else {
            return null;
        }
    }
}