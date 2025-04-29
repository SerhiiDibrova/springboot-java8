package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import hello.repository.ManagerRepository;
import hello.model.Manager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class ManagerService {

    private final ManagerRepository managerRepository;
    private static final Logger logger = LoggerFactory.getLogger(ManagerService.class);

    @Autowired
    public ManagerService(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    public Manager getManagerById(Long id) {
        return managerRepository.findById(id).orElse(null);
    }

    public Manager createManager(Manager manager) {
        if (manager == null || manager.getName() == null || manager.getEmail() == null) {
            throw new IllegalArgumentException("Manager details cannot be null");
        }
        logger.info("Creating manager: {}", manager);
        return managerRepository.save(manager);
    }

    public Manager updateManager(Long id, Manager managerDetails) {
        if (managerDetails == null) {
            throw new IllegalArgumentException("Manager details cannot be null");
        }
        Manager manager = managerRepository.findById(id).orElse(null);
        if (manager != null) {
            manager.setName(managerDetails.getName());
            manager.setEmail(managerDetails.getEmail());
            logger.info("Updating manager with id {}: {}", id, manager);
            return managerRepository.save(manager);
        }
        logger.warn("Manager with id {} not found for update", id);
        return null;
    }

    public void deleteManager(Long id) {
        if (!managerRepository.existsById(id)) {
            logger.error("Attempted to delete non-existent manager with id {}", id);
            throw new IllegalArgumentException("Manager with the given ID does not exist");
        }
        logger.info("Deleting manager with id {}", id);
        managerRepository.deleteById(id);
    }
}