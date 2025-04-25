package hello.model;

import java.util.Objects;

public class TempItem {
    private String id;
    private String name;
    private int quantity;
    private double price;

    public TempItem(String id, String name, int quantity, double price) {
        if (id == null || name == null) {
            throw new IllegalArgumentException("id and name cannot be null");
        }
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("id cannot be null");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("name cannot be null");
        }
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double calculateTotalPrice() {
        return quantity * price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TempItem)) return false;
        TempItem tempItem = (TempItem) o;
        return quantity == tempItem.quantity &&
                Double.compare(tempItem.price, price) == 0 &&
                id.equals(tempItem.id) &&
                name.equals(tempItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, price);
    }
}