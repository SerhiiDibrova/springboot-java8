

package hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import hello.dto.AssignEmployeeToProjectDTO;
import hello.service.EmployeeProjectService;

public class EmployeeProjectController {

    @Autowired
    private EmployeeProjectService employeeProjectService;

    @PostMapping("/assign-employee-to-project")
    public void assignEmployeeToProject(@RequestBody AssignEmployeeToProjectDTO assignEmployeeToProjectDTO) {
        employeeProjectService.assignEmployeeToProject(assignEmployeeToProjectDTO);
    }
}