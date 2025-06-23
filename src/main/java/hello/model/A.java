package hello.model;

import hello.model.A;
import hello.model.dto.PrintableValueDto;
import hello.model.repository.ARepository;
import hello.model.exception.EntityNotFoundException;
import java.io.Serializable;
import java.util.stream.Stream;
import java.util.function.Function;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class A implements Serializable {

    private String printableValue;
    private final ARepository aRepository;

    @Autowired
    public A(ARepository aRepository) {
        this.aRepository = aRepository;
    }

    public A(String printableValue, ARepository aRepository) {
        this.printableValue = printableValue;
        this.aRepository = aRepository;
    }

    public String methodA() {
        return this.printableValue;
    }

    public String methodB() {
        return this.printableValue;
    }

    public void setPrintableValue(String printableValue) {
        this.printableValue = printableValue;
    }

    public String getPrintableValue() {
        return printableValue;
    }

    public PrintableValueDto getPrintableValueDto() {
        return new PrintableValueDto(this.printableValue);
    }

    public void save() {
        aRepository.save(this);
    }

    public static Optional<A> find(ARepository aRepository, Long id) {
        return aRepository.findById(id);
    }

    public static Stream<A> findAll(ARepository aRepository) {
        return aRepository.findAll().stream();
    }

    public static A get(ARepository aRepository, Long id) {
        return find(aRepository, id).orElseThrow(EntityNotFoundException::new);
    }

    public static Function<A, PrintableValueDto> toDto() {
        return a -> new PrintableValueDto(a.printableValue);
    }
}