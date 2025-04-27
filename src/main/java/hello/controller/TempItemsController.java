package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TempItemsController {

    @Autowired
    private TempItemsService tempItemsService;

    @GetMapping("/temp-items/display-options")
    public ResponseEntity<List<String>> getDisplayOptions() {
        List<String> displayOptions = tempItemsService.getDisplayOptions();
        return ResponseEntity.ok(displayOptions);
    }
}

package hello.service;

import org.springframework.stereotype.Service;
import java.util.Arrays;
import java.util.List;

@Service
public class TempItemsService {

    public List<String> getDisplayOptions() {
        return Arrays.asList("Option1", "Option2", "Option3");
    }
}