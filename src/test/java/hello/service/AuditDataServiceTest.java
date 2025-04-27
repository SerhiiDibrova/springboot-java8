package hello.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

class AuditDataServiceTest {

    @InjectMocks
    private AuditDataService auditDataService;

    @Mock
    private AuditDataRepository auditDataRepository;

    public AuditDataServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testInsertAuditRecord() {
        AuditDataDTO auditDataDTO = new AuditDataDTO();
        when(auditDataRepository.save(any(AuditData.class))).thenReturn(new AuditData());

        auditDataService.insertAuditRecord(auditDataDTO);

        verify(auditDataRepository, times(1)).save(any(AuditData.class));
    }

    @Test
    void testRetrieveAuditRecords() {
        when(auditDataRepository.findAll()).thenReturn(new ArrayList<>());

        List<AuditDataDTO> result = auditDataService.retrieveAuditRecords();

        assertNotNull(result);
        verify(auditDataRepository, times(1)).findAll();
    }

    @Test
    void testDatabaseErrorHandling() {
        when(auditDataRepository.save(any(AuditData.class))).thenThrow(new RuntimeException("Database error"));

        assertThrows(RuntimeException.class, () -> {
            auditDataService.insertAuditRecord(new AuditDataDTO());
        });

        verify(auditDataRepository, times(1)).save(any(AuditData.class));
    }
}