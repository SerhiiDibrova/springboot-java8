

package hello.controller;

import hello.dto.EmployeeDTO;
import hello.entity.Employee;
import hello.exception.EmployeeNotFoundException;
import hello.repository.EmployeeRepository;
import hello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/insertEmployee")
    public ResponseEntity<Long> insertEmployee(@Validated @RequestBody EmployeeDTO employeeDTO) {
        try {
            Long employeeId = employeeService.insertEmployee(employeeDTO);
            return new ResponseEntity<>(employeeId, HttpStatus.CREATED);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Error inserting employee");
        }
    }

    @PutMapping("/updateEmployeeSalary")
    @Transactional
    public ResponseEntity<Void> updateEmployeeSalary(@Validated @RequestBody EmployeeDTO employeeDTO) {
        try {
            employeeService.updateEmployeeSalary(employeeDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            throw new EmployeeNotFoundException("Error updating employee salary");
        }
    }
}