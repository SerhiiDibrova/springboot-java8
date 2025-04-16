

package hello.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Table14Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 255)
    private String field1;

    @Column
    @NotNull
    @Size(max = 255)
    private String field2;

    @Column
    @NotNull
    @Size(max = 255)
    private String field3;

    @Column
    @NotNull
    @Size(max = 255)
    private String field4;

    @Column
    @NotNull
    @Size(max = 255)
    private String field5;

    @Column
    @NotNull
    @Size(max = 255)
    private String field6;

    @Column
    @NotNull
    @Size(max = 255)
    private String field7;

    @Column
    @NotNull
    @Size(max = 255)
    private String field8;

    @Column
    @NotNull
    @Size(max = 255)
    private String field9;

    @Column
    @NotNull
    @Size(max = 255)
    private String field10;

    @Column
    @NotNull
    @Size(max = 255)
    private String field11;

    @Column
    @NotNull
    @Size(max = 255)
    private String field12;

    @Column
    @NotNull
    @Size(max = 255)
    private String field13;

    @Column
    @NotNull
    @Size(max = 255)
    private String field14;

    public Table14Record() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public String getField5() {
        return field5;
    }

    public void setField5(String field5) {
        this.field5 = field5;
    }

    public String getField6() {
        return field6;
    }

    public void setField6(String field6) {
        this.field6 = field6;
    }

    public String getField7() {
        return field7;
    }

    public void setField7(String field7) {
        this.field7 = field7;
    }

    public String getField8() {
        return field8;
    }

    public void setField8(String field8) {
        this.field8 = field8;
    }

    public String getField9() {
        return field9;
    }

    public void setField9(String field9) {
        this.field9 = field9;
    }

    public String getField10() {
        return field10;
    }

    public void setField10(String field10) {
        this.field10 = field10;
    }

    public String getField11() {
        return field11;
    }

    public void setField11(String field11) {
        this.field11 = field11;
    }

    public String getField12() {
        return field12;
    }

    public void setField12(String field12) {
        this.field12 = field12;
    }

    public String getField13() {
        return field13;
    }

    public void setField13(String field13) {
        this.field13 = field13;
    }

    public String getField14() {
        return field14;
    }

    public void setField14(String field14) {
        this.field14 = field14;
    }
}