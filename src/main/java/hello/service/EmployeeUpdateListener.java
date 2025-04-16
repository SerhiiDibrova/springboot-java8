

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.repository.EmployeeRepository;
import hello.service.DepartmentBudgetService;

@Component
public class EmployeeUpdateListener {

    private final EmployeeRepository employeeRepository;
    private final DepartmentBudgetService departmentBudgetService;

    @Autowired
    public EmployeeUpdateListener(EmployeeRepository employeeRepository, DepartmentBudgetService departmentBudgetService) {
        this.employeeRepository = employeeRepository;
        this.departmentBudgetService = departmentBudgetService;
    }

    public void onEmployeeUpdate(Long employeeId) {
        Long departmentId = employeeRepository.getDepartmentId(employeeId);
        departmentBudgetService.recalculateBudget(departmentId);
    }
}