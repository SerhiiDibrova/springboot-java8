

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@RestController
@RequestMapping("/api")
public class CreateTemporaryTablesController {

    private final CreateTemporaryTablesService createTemporaryTablesService;
    private static final Logger logger = LoggerFactory.getLogger(CreateTemporaryTablesController.class);

    @Autowired
    public CreateTemporaryTablesController(CreateTemporaryTablesService createTemporaryTablesService) {
        this.createTemporaryTablesService = createTemporaryTablesService;
    }

    @PostMapping("/create-temporary-tables")
    @RequestMapping("/create-temporary-tables")
    public ResponseEntity<String> createTemporaryTables(@Validated @NotEmpty @NotBlank String input) {
        try {
            createTemporaryTablesService.createTemporaryTables(input);
            return new ResponseEntity<>("Temporary tables created successfully", HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error creating temporary tables", e);
            return new ResponseEntity<>("Error creating temporary tables", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}