// src/main/java/hello/model/Product.java
package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * Product entity mapped to the "products" table.
 */
@Entity
@Table(name = "product")
public class ProductDB {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    // Default constructor required by JPA
    public ProductDB() {}

    // Convenience constructor
    public ProductDB(String name) {
        this.name = name;
    }

    // Getters & Setters
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

    // equals/hashCode based on id for proper identity semantics
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductDB)) return false;
        ProductDB other = (ProductDB) o;
        return id != null && id.equals(other.getId());
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // Helpful toString()
    @Override
    public String toString() {
        return "Product{id=" + id + ", name='" + name + "'}";
    }
}
