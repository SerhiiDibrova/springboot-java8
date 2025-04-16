

package hello.service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Func3Service {

    private static final Logger LOGGER = LoggerFactory.getLogger(Func3Service.class);

    @Value("${db.username}")
    private String username;

    @Value("${db.password}")
    private String password;

    @Value("${db.url}")
    private String url;

    public String func3(String param1, String param2) {
        String result = "";
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            CallableStatement cs = conn.prepareCall("{? = call dbo.func_3(?, ?)}");
            cs.registerOutParameter(1, Types.VARCHAR);
            cs.setString(2, param1);
            cs.setString(3, param2);
            cs.execute();
            result = cs.getString(1);
        } catch (SQLException e) {
            LOGGER.error("Error calling dbo.func_3", e);
            throw new RuntimeException("Error calling dbo.func_3", e);
        }
        return result;
    }
}