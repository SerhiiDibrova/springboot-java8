package hello.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TempItem {
    
    @Id
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}

package hello.repository;

import hello.entity.TempItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TempItemRepository extends JpaRepository<TempItem, Integer> {
}

package hello.service;

import hello.entity.TempItem;
import hello.repository.TempItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TempItemService {

    @Autowired
    private TempItemRepository tempItemRepository;

    public TempItem saveTempItem(TempItem tempItem) {
        return tempItemRepository.save(tempItem);
    }

    public List<TempItem> getAllTempItems() {
        return tempItemRepository.findAll();
    }

    public void deleteTempItem(Integer orderId) {
        tempItemRepository.deleteById(orderId);
    }
}

package hello.controller;

import hello.entity.TempItem;
import hello.service.TempItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/temp-items")
public class TempItemController {

    @Autowired
    private TempItemService tempItemService;

    @PostMapping
    public ResponseEntity<TempItem> createTempItem(@RequestBody TempItem tempItem) {
        TempItem savedItem = tempItemService.saveTempItem(tempItem);
        return ResponseEntity.ok(savedItem);
    }

    @GetMapping
    public ResponseEntity<List<TempItem>> getAllTempItems() {
        List<TempItem> items = tempItemService.getAllTempItems();
        return ResponseEntity.ok(items);
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteTempItem(@PathVariable Integer orderId) {
        tempItemService.deleteTempItem(orderId);
        return ResponseEntity.noContent().build();
    }
}