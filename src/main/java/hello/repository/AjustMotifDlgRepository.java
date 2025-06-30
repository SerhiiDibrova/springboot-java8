package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.entity.AjustMotifDlgEntity;

@Repository
public interface AjustMotifDlgRepository extends JpaRepository<AjustMotifDlgEntity, Long> {

    AjustMotifDlgEntity findByCashDesk(String cashDesk);

    AjustMotifDlgEntity findBySlotMachine(String slotMachine);
}