package hello.repository;

public interface IDatabase {
    void save(String data);
    String findById(String id);
    void delete(String id);
}