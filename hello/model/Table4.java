

package hello.model;

public class Table4 {
    private int id;

    public Table4(int id) {
        this.id = id;
    }

    public int getId() {
        try {
            return id;
        } catch (Exception e) {
            throw new RuntimeException("Error getting id", e);
        }
    }
}