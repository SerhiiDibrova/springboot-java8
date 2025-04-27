package hello.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import hello.service.ManagerService;
import hello.model.User;
import hello.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManagerServiceTest {

    @InjectMocks
    private ManagerService managerService;

    @Mock
    private UserRepository userRepository;

    public ManagerServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetDefaultManagerId_NullManagerId() {
        Long defaultManagerId = managerService.getDefaultManagerId(null);
        assertNotNull(defaultManagerId);
    }

    @Test
    public void testGetDefaultManagerId_NonNullManagerId() {
        Long managerId = 1L;
        Long result = managerService.getDefaultManagerId(managerId);
        assertEquals(managerId, result);
    }

    @Test
    public void testGetDefaultManagerId_NoUsersMeetCriteria() {
        Long managerId = null;
        when(userRepository.findByCriteria(any())).thenReturn(Optional.empty());
        Long result = managerService.getDefaultManagerId(managerId);
        assertNull(result);
    }
}