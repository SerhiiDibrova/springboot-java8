

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import hello.entity.Table13Entity;

@Repository
public interface Table13Repository extends JpaRepository<Table13Entity, Integer> {

}