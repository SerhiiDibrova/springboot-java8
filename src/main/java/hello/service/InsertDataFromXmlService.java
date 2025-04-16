

package hello.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.sql.Types;
import java.util.List;

public class InsertDataFromXmlService {

    private final JdbcTemplate jdbcTemplate;
    private final ObjectMapper objectMapper;

    public InsertDataFromXmlService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.objectMapper = new ObjectMapper();
    }

    public void insertDataFromXml(String xmlDocument) throws Exception {
        if (xmlDocument == null || xmlDocument.isEmpty()) {
            throw new IllegalArgumentException("xmlDocument cannot be null or empty");
        }

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Item.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Item item = (Item) unmarshaller.unmarshal(new StringReader(xmlDocument));

            String sql = "INSERT INTO #TempItems (id, name, description) VALUES (?, ?, ?)";
            jdbcTemplate.update(sql, item.getId(), item.getName(), item.getDescription());
        } catch (JAXBException e) {
            throw new Exception("Error unmarshalling XML", e);
        } catch (Exception e) {
            throw new Exception("Error inserting data into database", e);
        }
    }

    public void close() {
        jdbcTemplate.getDataSource().getConnection().close();
    }

    private static class Item {
        private int id;
        private String name;
        private String description;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}