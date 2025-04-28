package hello.controller;

import hello.dto.AuditDataDTO;
import hello.dto.ManagerIdDTO;
import hello.service.AuditDataService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditDataController {

    @PostMapping("/setup")
    public ResponseEntity<Void> setupAuditDataTable() {
        try {
            AuditDataService.setupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/insert")
    public ResponseEntity<List<AuditDataDTO>> insertAuditData(@RequestBody ManagerIdDTO managerIdDTO) {
        try {
            Integer managerId = managerIdDTO.getManagerId();
            if (managerId == null) {
                return ResponseEntity.badRequest().body(null);
            }
            List<AuditData> auditDataList = AuditDataService.insertAuditData(managerId);
            List<AuditDataDTO> auditDataDTOList = new ArrayList<>();
            for (AuditData auditData : auditDataList) {
                AuditDataDTO dto = new AuditDataDTO();
                dto.setAuditId(auditData.getAuditId());
                dto.setRecordDetails(auditData.getRecordDetails());
                dto.setCreatedAt(auditData.getCreatedAt());
                auditDataDTOList.add(dto);
            }
            return ResponseEntity.ok(auditDataDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/data")
    public ResponseEntity<List<AuditDataDTO>> getAuditData() {
        try {
            List<AuditData> auditDataList = AuditDataService.executeSelectAuditData();
            List<AuditDataDTO> auditDataDTOList = new ArrayList<>();
            for (AuditData auditData : auditDataList) {
                AuditDataDTO dto = new AuditDataDTO();
                dto.setAuditId(auditData.getAuditId());
                dto.setRecordDetails(auditData.getRecordDetails());
                dto.setCreatedAt(auditData.getCreatedAt());
                auditDataDTOList.add(dto);
            }
            return ResponseEntity.ok(auditDataDTOList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/cleanup")
    public ResponseEntity<Void> cleanupAuditDataTable() {
        try {
            AuditDataService.cleanupAuditDataTable();
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}