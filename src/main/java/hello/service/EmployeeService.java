

package hello.service;

import hello.model.Employee;
import hello.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Integer insertEmployee(String firstName, String lastName, Integer deptId, Date hireDate, BigDecimal salary) {
        if (firstName == null || lastName == null || deptId == null || hireDate == null || salary == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }
        Employee employee = new Employee(firstName, lastName, deptId, hireDate, salary);
        employeeRepository.save(employee);
        return employee.getEmployeeId();
    }

    @Transactional
    public boolean updateEmployeeSalary(Integer employeeId, BigDecimal newSalary) {
        if (employeeId == null || newSalary == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }
        try {
            Optional<Employee> employee = employeeRepository.findById(employeeId);
            if (employee.isPresent()) {
                employee.get().setSalary(newSalary);
                employeeRepository.save(employee.get());
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            throw new RuntimeException("Error updating employee salary", e);
        }
    }
}