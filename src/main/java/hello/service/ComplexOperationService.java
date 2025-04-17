

package hello.service;

import hello.repository.Repository1;
import hello.repository.Repository2;
import hello.service.Service1;
import hello.service.Service2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ComplexOperationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ComplexOperationService.class);

    private final Repository1 repository1;
    private final Repository2 repository2;
    private final Service1 service1;
    private final Service2 service2;

    @Autowired
    public ComplexOperationService(Repository1 repository1, Repository2 repository2, Service1 service1, Service2 service2) {
        if (repository1 == null || repository2 == null || service1 == null || service2 == null) {
            throw new IllegalArgumentException("All dependencies must be provided");
        }
        this.repository1 = repository1;
        this.repository2 = repository2;
        this.service1 = service1;
        this.service2 = service2;
    }

    @Transactional(rollbackFor = Exception.class)
    public void performComplexOperation() {
        try {
            // Call methods on repositories and services as needed
            repository1.doSomething();
            service1.doSomethingElse();
            repository2.doAnotherThing();
            service2.doYetAnotherThing();
        } catch (Exception e) {
            LOGGER.error("Error performing complex operation", e);
            throw e;
        }
    }
}