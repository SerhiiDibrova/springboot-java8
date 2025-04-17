

package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class GetSalesDataService {

    @Autowired
    private SalesDataRepository salesDataRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public List<SalesReportDTO> getSalesData() {
        List<SalesData> salesData = salesDataRepository.getSalesData();
        List<SalesReportDTO> salesReportDTOs = transformSalesData(salesData);
        insertSalesReport(salesReportDTOs);
        return salesReportDTOs;
    }

    private List<SalesReportDTO> transformSalesData(List<SalesData> salesData) {
        List<SalesReportDTO> salesReportDTOs = new ArrayList<>();
        for (SalesData salesDataItem : salesData) {
            SalesReportDTO salesReportDTO = new SalesReportDTO();
            salesReportDTO.setSalesId(salesDataItem.getSalesId());
            salesReportDTO.setSalesDate(salesDataItem.getSalesDate());
            salesReportDTO.setSalesAmount(salesDataItem.getSalesAmount());
            salesReportDTOs.add(salesReportDTO);
        }
        return salesReportDTOs;
    }

    private void insertSalesReport(List<SalesReportDTO> salesReportDTOs) {
        jdbcTemplate.batchUpdate("INSERT INTO #SalesReport (SalesId, SalesDate, SalesAmount) VALUES (?, ?, ?)",
                new BatchPreparedStatementSetter() {
                    @Override
                    public void setValues(PreparedStatement ps, int i) throws SQLException {
                        SalesReportDTO salesReportDTO = salesReportDTOs.get(i);
                        ps.setInt(1, salesReportDTO.getSalesId());
                        ps.setDate(2, salesReportDTO.getSalesDate());
                        ps.setBigDecimal(3, salesReportDTO.getSalesAmount());
                    }

                    @Override
                    public int getBatchSize() {
                        return salesReportDTOs.size();
                    }
                });
    }

    private class SalesReportRowMapper implements RowMapper<SalesReportDTO> {
        @Override
        public SalesReportDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
            SalesReportDTO salesReportDTO = new SalesReportDTO();
            salesReportDTO.setSalesId(rs.getInt("SalesId"));
            salesReportDTO.setSalesDate(rs.getDate("SalesDate"));
            salesReportDTO.setSalesAmount(rs.getBigDecimal("SalesAmount"));
            return salesReportDTO;
        }
    }
}