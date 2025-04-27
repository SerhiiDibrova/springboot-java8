package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AuditDataService {

    @Autowired
    private AuditDataRepository auditDataRepository;

    @Transactional
    public void insertAuditData(AuditData auditData) {
        auditDataRepository.save(auditData);
    }

    @Transactional
    public void createTemporaryTable() {
        auditDataRepository.createTemporaryTable();
    }

    @Transactional(readOnly = true)
    public List<AuditData> retrieveAuditData() {
        return auditDataRepository.findAll();
    }

    @Transactional
    public void cleanupTemporaryTable() {
        auditDataRepository.cleanupTemporaryTable();
    }
}