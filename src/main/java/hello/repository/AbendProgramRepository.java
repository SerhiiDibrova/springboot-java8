package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.AbendProgram;

@Repository
public interface AbendProgramRepository extends JpaRepository<AbendProgram, Long> {

    AbendProgram findByProgramName(String programName);

    AbendProgram findByAbendCode(String abendCode);

    void deleteByProgramName(String programName);

    void deleteByAbendCode(String abendCode);
}