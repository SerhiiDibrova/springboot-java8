

package hello.service;

import hello.entity.EmployeeProject;
import hello.repository.EmployeeProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class EmployeeProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeProjectService.class);

    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    public void assignEmployeeToProject(Long employeeId, Long projectId, LocalDateTime assignmentDate) {
        if (employeeId == null || projectId == null || assignmentDate == null) {
            throw new IllegalArgumentException("Employee ID, project ID, and assignment date are required");
        }

        Optional<EmployeeProject> existingAssignment = employeeProjectRepository.findByEmployeeIdAndProjectId(employeeId, projectId);
        if (existingAssignment.isPresent()) {
            throw new IllegalStateException("Employee is already assigned to the project");
        }

        EmployeeProject employeeProject = new EmployeeProject();
        employeeProject.setEmployeeId(employeeId);
        employeeProject.setProjectId(projectId);
        employeeProject.setAssignmentDate(assignmentDate);

        try {
            employeeProjectRepository.save(employeeProject);
            LOGGER.info("Employee {} assigned to project {}", employeeId, projectId);
        } catch (Exception e) {
            LOGGER.error("Error assigning employee to project", e);
            throw new RuntimeException("Error assigning employee to project", e);
        }
    }
}