package hello.model;

import hello.model.UserType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class C {
    private long id;
    private String firstName, lastName;
    private UserType userType;

    @Override
    public String toString() {
        return "C{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public C(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = UserType.DEFAULT;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String method_c() {
        return "Method C";
    }

    public static void main(String[] args) {
        try {
            SpringApplication app = new SpringApplication(C.class);
            C c = new C(1, "John", "Doe");
            System.out.println(c.method_c());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}