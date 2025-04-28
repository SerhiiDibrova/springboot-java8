package hello.model;

public class ProductDTO {
    private long id;
    private String name;

    // Constructors
    public ProductDTO() {}

    public ProductDTO(long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters & Setters
    public long getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}
