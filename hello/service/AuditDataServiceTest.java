package hello.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AuditDataServiceTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        // Setup code if needed
    }

    @Test
    public void testInsertAuditData() throws Exception {
        String auditDataJson = "{\"event\":\"USER_LOGIN\",\"timestamp\":\"2023-10-01T12:00:00Z\"}";

        mockMvc.perform(post("/audit")
                .contentType("application/json")
                .content(auditDataJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void testRetrieveAuditData() throws Exception {
        mockMvc.perform(get("/audit"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}