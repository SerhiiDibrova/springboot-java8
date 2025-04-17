

package hello.controller;

import hello.dto.DepartmentDTO;
import hello.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public ResponseEntity<Long> insertDepartment(@RequestBody DepartmentDTO departmentDTO) {
        Long departmentId = departmentService.insertDepartment(departmentDTO);
        return new ResponseEntity<>(departmentId, HttpStatus.CREATED);
    }
}