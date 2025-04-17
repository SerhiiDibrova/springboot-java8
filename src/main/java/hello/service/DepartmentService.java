

package hello.service;

import hello.dto.DepartmentDTO;
import hello.entity.Department;
import hello.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import javax.persistence.GeneratedValue;
import javax.validation.Valid;
import java.util.logging.Logger;

@Service
@Validated
public class DepartmentService {

    private static final Logger LOGGER = Logger.getLogger(DepartmentService.class.getName());

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    public Long insertDepartment(@Valid DepartmentDTO departmentDTO) {
        try {
            Department department = new Department();
            department.setName(departmentDTO.getName());
            department.setDescription(departmentDTO.getDescription());
            department = departmentRepository.save(department);
            return department.getId();
        } catch (Exception e) {
            LOGGER.severe("Error inserting department: " + e.getMessage());
            throw new RuntimeException("Error inserting department", e);
        }
    }
}