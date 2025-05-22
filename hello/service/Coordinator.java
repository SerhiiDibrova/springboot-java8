package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import hello.model.Dog;
import hello.repository.DatabaseRepository;
import hello.repository.DatabaseRepositoryImpl;
import hello.service.LoggerService;
import hello.service.ReportGenerator;

@Service
public class Coordinator {

    @Autowired
    private LoggerService loggerService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void Run() {
        loggerService.log("Start");
        try {
            Dog dog = new Dog();
            AnimalService animalService = new AnimalService(dog);
            DatabaseRepository databaseRepository = new DatabaseRepositoryImpl(jdbcTemplate);
            ReportGenerator reportGenerator = new ReportGenerator(animalService, databaseRepository);
            reportGenerator.Generate();
        } catch (Exception e) {
            loggerService.log("Error: " + e.getMessage());
        }
        loggerService.log("End");
    }
}