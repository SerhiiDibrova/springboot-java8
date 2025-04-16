

package hello.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class Table19 {
    private Long id;
    private String name;
    private LocalDateTime createdAt;

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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public static Comparator<Table19> comparatorById() {
        return Comparator.comparing(Table19::getId);
    }

    public static Comparator<Table19> comparatorByName() {
        return Comparator.comparing(Table19::getName);
    }

    public static Comparator<Table19> comparatorByCreatedAt() {
        return Comparator.comparing(Table19::getCreatedAt);
    }

    public static ArrayList<Table19> sortById(ArrayList<Table19> list) {
        list.sort(comparatorById());
        return list;
    }

    public static ArrayList<Table19> sortByName(ArrayList<Table19> list) {
        list.sort(comparatorByName());
        return list;
    }

    public static ArrayList<Table19> sortByCreatedAt(ArrayList<Table19> list) {
        list.sort(comparatorByCreatedAt());
        return list;
    }
}