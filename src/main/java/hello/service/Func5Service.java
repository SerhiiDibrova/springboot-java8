

package hello.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.logging.Logger;

@Service
public class Func5Service {

    private final Table5Repository table5Repository;
    private static final Logger LOGGER = Logger.getLogger(Func5Service.class.getName());

    @Autowired
    public Func5Service(Table5Repository table5Repository) {
        this.table5Repository = table5Repository;
    }

    public String func5(int id) {
        try {
            return table5Repository.findNameById(id).orElseThrow();
        } catch (Exception e) {
            LOGGER.severe("Error occurred while executing func5: " + e.getMessage());
            return "";
        }
    }
}

interface Table5Repository extends JpaRepository<Table5, Integer> {

    @Query("SELECT t.name FROM Table5 t WHERE t.id = :id")
    Optional<String> findNameById(@Param("id") int id);
}

@Entity
@Table(name = "table_5")
class Table5 {
    @Id
    private int id;
    private String name;

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
}