package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.List;

@Entity
@Table(name = "order")
public class OrderDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String userEmail;
    private List<Long> productIds;

    public OrderDB() {}

    public OrderDB(String name, String userEmail, List<Long> productIds) {
        this.name = name;
        this.userEmail = userEmail;
        this.productIds = productIds;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public List<Long> getProductIds() {
        return productIds;
    }
    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDB)) return false;
        OrderDB other = (OrderDB) o;
        return id != null && id.equals(other.getId()) &&
               name != null && name.equals(other.getName()) &&
               userEmail != null && userEmail.equals(other.getUserEmail()) &&
               productIds != null && productIds.equals(other.getProductIds());
    }

    @Override
    public int hashCode() {
        return 31 * (id != null ? id.hashCode() : 0) +
               31 * (name != null ? name.hashCode() : 0) +
               31 * (userEmail != null ? userEmail.hashCode() : 0) +
               31 * (productIds != null ? productIds.hashCode() : 0);
    }

    @Override
    public String toString() {
        return "Order{id=" + id + ", name='" + name + "', userEmail='" + userEmail + "', productIds=" + productIds + "}";
    }
}