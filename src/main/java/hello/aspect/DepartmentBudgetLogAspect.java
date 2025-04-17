

package hello.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DepartmentBudgetLogAspect {

    @Autowired
    private DepartmentBudgetLogService departmentBudgetLogService;

    @After("execution(* *(..)) && target(com.example.Departments) && within(com.example.Departments)")
    public void logDepartmentBudgetUpdate(JoinPoint joinPoint) {
        try {
            departmentBudgetLogService.logChange(joinPoint);
        } catch (Exception e) {
            // Handle exception
        }
    }
}