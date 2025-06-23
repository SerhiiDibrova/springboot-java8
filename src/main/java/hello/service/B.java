package hello.service;

import hello.model.A;
import hello.model.EntityNotFoundException;
import hello.repository.ARepository;
import hello.dto.ADTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class B {

    private final ARepository aRepository;

    @Autowired
    public B(ARepository aRepository) {
        this.aRepository = aRepository;
    }

    public String methodB() {
        try {
            A a = new A();
            String result = a.methodA();
            if (result != null) {
                System.out.println(result);
                return result;
            } else {
                throw new EntityNotFoundException("Result is null");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String methodBUsingRepository() {
        try {
            Optional<A> aOptional = aRepository.findById(1L);
            if (aOptional.isPresent()) {
                A a = aOptional.get();
                String result = a.methodA();
                if (result != null) {
                    System.out.println(result);
                    return result;
                } else {
                    throw new EntityNotFoundException("Result is null");
                }
            } else {
                throw new EntityNotFoundException("A not found");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Stream<String> methodBUsingStream() {
        try {
            return aRepository.findAll().stream()
                    .map(A::methodA)
                    .filter(Objects::nonNull);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}