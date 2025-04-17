

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.DepartmentBudgetLogRepository;

@Service
public class DepartmentBudgetLogService {

    @Autowired
    private DepartmentBudgetLogRepository departmentBudgetLogRepository;

    public void logBudgetChange(Long departmentId, Double oldBudget, Double newBudget) {
        if (oldBudget == null || newBudget == null) {
            throw new IllegalArgumentException("Old and new budget values must not be null");
        }

        Double budgetDifference = calculateBudgetDifference(oldBudget, newBudget);

        try {
            departmentBudgetLogRepository.insertLog(departmentId, oldBudget, newBudget, budgetDifference);
        } catch (Exception e) {
            throw new RuntimeException("Failed to insert log entry", e);
        }
    }

    private Double calculateBudgetDifference(Double oldBudget, Double newBudget) {
        if (oldBudget.equals(newBudget)) {
            return 0.0;
        }

        return newBudget - oldBudget;
    }
}