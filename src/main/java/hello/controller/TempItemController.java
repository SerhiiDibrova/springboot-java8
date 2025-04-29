package hello.controller;

import hello.dto.TempItemDTO;
import hello.service.TempItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/temp-items")
@Validated
public class TempItemController {

    private final TempItemService tempItemService;

    @Autowired
    public TempItemController(TempItemService tempItemService) {
        this.tempItemService = tempItemService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> createTempItems(@Valid @RequestBody TempItemDTO tempItemDTO) {
        tempItemService.insertTempItems(tempItemDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/display-options")
    public ResponseEntity<Object> getDisplayOptions() {
        return ResponseEntity.ok(tempItemService.getDisplayOptions());
    }
}