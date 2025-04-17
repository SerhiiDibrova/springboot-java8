

package hello.service;

import hello.dto.EmployeeDTO;
import hello.entity.Employee;
import hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.Table;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Long insertEmployee(EmployeeDTO employeeDTO) {
        if (employeeDTO.getName() == null || employeeDTO.getSalary() == null) {
            throw new RuntimeException("Employee data is invalid");
        }
        Employee employee = new Employee(employeeDTO.getName(), employeeDTO.getSalary());
        employeeRepository.save(employee);
        return employeeRepository.findIdByName(employeeDTO.getName());
    }

    @Transactional
    public void updateEmployeeSalary(Long id, Double salary) {
        if (salary == null) {
            throw new RuntimeException("Salary is invalid");
        }
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setSalary(salary);
        employeeRepository.save(employee);
    }

    @ExceptionHandler
    public void handleException(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}