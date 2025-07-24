package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

@Entity
@Table(name = "abend_program")
public class AbendProgramEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String timing;

    private String abcode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTiming() {
        return timing;
    }

    public void setTiming(String timing) {
        this.timing = timing;
    }

    public String getAbcode() {
        return abcode;
    }

    public void setAbcode(String abcode) {
        this.abcode = abcode;
    }
}