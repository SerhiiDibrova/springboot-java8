

package hello.service;

import hello.dto.AssignEmployeeToProjectDTO;
import hello.entity.EmployeeProject;
import hello.repository.EmployeeProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProjectService.class);

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Transactional
    public void assignEmployeeToProject(AssignEmployeeToProjectDTO assignEmployeeToProjectDTO) {
        if (assignEmployeeToProjectDTO == null) {
            LOGGER.error("AssignEmployeeToProjectDTO is null");
            throw new NullPointerException("AssignEmployeeToProjectDTO is null");
        }

        EmployeeProject employeeProject = new EmployeeProject(assignEmployeeToProjectDTO);
        try {
            EmployeeProject savedEmployeeProject = employeeProjectRepository.save(employeeProject);
            if (savedEmployeeProject == null) {
                LOGGER.error("Failed to save EmployeeProject");
                throw new RuntimeException("Failed to save EmployeeProject");
            }
        } catch (Exception e) {
            LOGGER.error("Error assigning employee to project", e);
            throw new RuntimeException("Error assigning employee to project", e);
        }
    }
}