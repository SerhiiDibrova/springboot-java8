

package hello.service;

import hello.dao.ProjectDao;
import hello.model.Project;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProjectService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectService.class);

    @Autowired
    private ProjectDao projectDao;

    @Transactional
    public Long insertProject(Project project) {
        Assert.notNull(project, "Project must not be null");
        try {
            projectDao.insertProject(project);
            return project.getId();
        } catch (Exception e) {
            LOGGER.error("Error inserting project", e);
            throw new RuntimeException("Error inserting project", e);
        }
    }

    @Transactional(readOnly = true)
    public List<Project> getAllProjects() {
        try {
            return projectDao.getAllProjects();
        } catch (Exception e) {
            LOGGER.error("Error retrieving all projects", e);
            throw new RuntimeException("Error retrieving all projects", e);
        }
    }

    @Transactional(readOnly = true)
    public Project getProjectById(Long id) {
        Assert.notNull(id, "Id must not be null");
        try {
            return projectDao.getProjectById(id);
        } catch (Exception e) {
            LOGGER.error("Error retrieving project by id", e);
            throw new RuntimeException("Error retrieving project by id", e);
        }
    }

    @Transactional
    public void updateProject(Project project) {
        Assert.notNull(project, "Project must not be null");
        try {
            projectDao.updateProject(project);
        } catch (Exception e) {
            LOGGER.error("Error updating project", e);
            throw new RuntimeException("Error updating project", e);
        }
    }

    @Transactional
    public void deleteProject(Long id) {
        Assert.notNull(id, "Id must not be null");
        try {
            projectDao.deleteProject(id);
        } catch (Exception e) {
            LOGGER.error("Error deleting project", e);
            throw new RuntimeException("Error deleting project", e);
        }
    }
}