package hello.service;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class HealthCheckService {
    public Map<String, String> getHealthStatus() {
        HashMap<String, String> healthStatus = new HashMap<>();
        healthStatus.put("status", "ok");
        return healthStatus;
    }
}