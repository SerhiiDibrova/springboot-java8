

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import hello.service.DeptBudgetService;

@Component
public class EmployeeUpdateTrigger {

    private final DeptBudgetService deptBudgetService;

    @Autowired
    public EmployeeUpdateTrigger(DeptBudgetService deptBudgetService) {
        this.deptBudgetService = deptBudgetService;
    }

    public void triggerUpdate() {
        deptBudgetService.updateBudget();
    }
}