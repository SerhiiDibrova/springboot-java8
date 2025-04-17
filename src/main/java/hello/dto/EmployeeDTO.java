

package hello.dto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

@Entity
@Table(name = "employees")
public class EmployeeDTO {

    private String firstName;
    private String lastName;
    private int deptId;
    private Date hireDate;
    private double salary;
    private int id;
    private String name;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDeptId() {
        return deptId;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

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

    @Override
    public String toString() {
        return "EmployeeDTO [firstName=" + firstName + ", lastName=" + lastName + ", deptId=" + deptId + ", hireDate="
                + hireDate + ", salary=" + salary + ", id=" + id + ", name=" + name + "]";
    }
}