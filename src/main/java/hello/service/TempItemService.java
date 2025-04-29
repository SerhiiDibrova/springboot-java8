package hello.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TempItemService {
    private Connection connection;

    public TempItemService(Connection connection) {
        this.connection = connection;
    }

    public void populateTempItems() throws SQLException {
        String sql = "INSERT INTO #TempItems (order_id) SELECT order_id FROM Orders"; // Example source
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<DisplayOption> retrieveDisplayOptionsForSales() throws SQLException {
        List<DisplayOption> options = new ArrayList<>();
        String sql = "SELECT di.* FROM #TempItems ti " +
                     "JOIN CustomConfig cc ON ti.order_id = cc.order_id " +
                     "JOIN DisplayOptions di ON cc.config_id = di.config_id " +
                     "WHERE cc.module = 'SALES'";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                options.add(new DisplayOption(rs));
            }
        }
        return options;
    }

    public List<DisplayOption> retrieveDisplayOptionsForMarketingData() throws SQLException {
        List<DisplayOption> options = new ArrayList<>();
        String sql = "SELECT di.* FROM #TempItems ti " +
                     "JOIN LegacyConfig lc ON ti.order_id = lc.order_id " +
                     "JOIN DisplayOptions di ON lc.config_id = di.config_id " +
                     "WHERE lc.module = 'MARKETING_DATA'";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                options.add(new DisplayOption(rs));
            }
        }
        return options;
    }

    public List<DisplayOption> combineResults() throws SQLException {
        List<DisplayOption> salesOptions = retrieveDisplayOptionsForSales();
        List<DisplayOption> marketingOptions = retrieveDisplayOptionsForMarketingData();
        List<DisplayOption> combinedOptions = new ArrayList<>(salesOptions);
        for (DisplayOption option : marketingOptions) {
            if (!combinedOptions.contains(option)) {
                combinedOptions.add(option);
            }
        }
        return combinedOptions;
    }
}