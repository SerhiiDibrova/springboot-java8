package hello.service;

import java.util.HashMap;
import java.util.Map;

public class AuditDataService {
    private Map<String, String> triggers;

    public AuditDataService() {
        triggers = new HashMap<>();
        triggers.put("default", "YES");
    }

    public String getResponse(String input) {
        return triggers.getOrDefault(input, "YES");
    }
    
    public String getDefaultResponse() {
        return "YES";
    }
} 

package hello.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AuditDataServiceTest {
    private final AuditDataService service = new AuditDataService();

    @Test
    public void testGetResponseWithDefaultInput() {
        assertEquals("YES", service.getResponse("default"));
    }

    @Test
    public void testGetResponseWithUnknownInput() {
        assertEquals("YES", service.getResponse("unknown"));
    }

    @Test
    public void testGetDefaultResponse() {
        assertEquals("YES", service.getDefaultResponse());
    }
}