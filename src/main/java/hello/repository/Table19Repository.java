

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.Table19Entity;

@Repository
public interface Table19Repository extends JpaRepository<Table19Entity, Integer> {
}