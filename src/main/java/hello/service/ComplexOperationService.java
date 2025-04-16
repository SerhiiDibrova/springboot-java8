

package hello.service;

import hello.repository.DepartmentRepository;
import hello.repository.EmployeeProjectRepository;
import hello.repository.EmployeeRepository;
import hello.repository.ProjectRepository;
import hello.service.DepartmentService;
import hello.service.EmployeeProjectService;
import hello.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

@Service
public class ComplexOperationService {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public int performComplexOperation(String departmentName, double initialBudget, String employeeFirstName, String employeeLastName, String hireDate, double salary, String projectName, String projectStartDate) {
        if (departmentName == null || departmentName.isEmpty() || initialBudget < 0) {
            throw new IllegalArgumentException("Invalid department name or initial budget");
        }

        if (employeeFirstName == null || employeeFirstName.isEmpty() || employeeLastName == null || employeeLastName.isEmpty()) {
            throw new IllegalArgumentException("Invalid employee first or last name");
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate hireDateObj;
        try {
            hireDateObj = LocalDate.parse(hireDate, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid hire date format");
        }

        if (salary < 0) {
            throw new IllegalArgumentException("Invalid salary");
        }

        if (projectName == null || projectName.isEmpty()) {
            throw new IllegalArgumentException("Invalid project name");
        }

        LocalDate projectStartDateObj;
        try {
            projectStartDateObj = LocalDate.parse(projectStartDate, formatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid project start date format");
        }

        int departmentId;
        Optional<Integer> existingDepartmentId = departmentRepository.getDepartmentId(departmentName);
        if (existingDepartmentId.isPresent()) {
            departmentId = existingDepartmentId.get();
        } else {
            departmentId = departmentService.insertDepartment(departmentName, initialBudget);
        }

        int employeeId;
        Optional<Integer> existingEmployeeId = employeeRepository.getEmployeeId(employeeFirstName, employeeLastName, hireDateObj);
        if (existingEmployeeId.isPresent()) {
            employeeId = existingEmployeeId.get();
        } else {
            employeeId = employeeService.insertEmployee(employeeFirstName, employeeLastName, hireDateObj, salary);
        }

        int projectId;
        Optional<Integer> existingProjectId = projectRepository.getProjectId(projectName, projectStartDateObj);
        if (existingProjectId.isPresent()) {
            projectId = existingProjectId.get();
        } else {
            projectId = projectRepository.insertProject(projectName, projectStartDateObj);
        }

        if (employeeId > 0 && projectId > 0) {
            employeeProjectService.assignEmployeeToProject(employeeId, projectId);
        } else {
            throw new IllegalArgumentException("Invalid employee or project id");
        }

        employeeService.updateEmployeeSalary(employeeId, salary);
        if (!departmentService.recalculateDepartmentBudget(departmentId)) {
            throw new RuntimeException("Failed to recalculate department budget");
        }

        return 0;
    }
}