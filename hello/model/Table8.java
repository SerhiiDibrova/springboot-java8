

package hello.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "table_8")
public class Table8 {

    @Id
    private final Long id;

    private final String column1;
    private final String column2;
    private final String column3;
    private final String column4;
    private final String column5;
    private final String column6;
    private final String column7;
    private final String column8;

    public Table8() {}

    public Table8(Long id, String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8) {
        this.id = id;
        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = validateString(column4);
        this.column5 = column5;
        this.column6 = column6;
        this.column7 = column7;
        this.column8 = column8;
    }

    public Long getId() {
        return id;
    }

    public String getColumn1() {
        return column1;
    }

    public String getColumn2() {
        return column2;
    }

    public String getColumn3() {
        return column3;
    }

    public String getColumn4() {
        return column4;
    }

    public void setColumn4(String column4) {
        this.column4 = validateString(column4);
    }

    public String getColumn5() {
        return column5;
    }

    public void setColumn5(String column5) {
        this.column5 = column5;
    }

    public String getColumn6() {
        return column6;
    }

    public void setColumn6(String column6) {
        this.column6 = column6;
    }

    public String getColumn7() {
        return column7;
    }

    public void setColumn7(String column7) {
        this.column7 = column7;
    }

    public String getColumn8() {
        return column8;
    }

    public void setColumn8(String column8) {
        this.column8 = column8;
    }

    private String validateString(String value) {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("Value cannot be null or empty");
        }
        return value;
    }

    @Override
    public String toString() {
        return "Table8{" +
                "id=" + id +
                ", column1='" + column1 + '\'' +
                ", column2='" + column2 + '\'' +
                ", column3='" + column3 + '\'' +
                ", column4='" + column4 + '\'' +
                ", column5='" + column5 + '\'' +
                ", column6='" + column6 + '\'' +
                ", column7='" + column7 + '\'' +
                ", column8='" + column8 + '\'' +
                '}';
    }
}