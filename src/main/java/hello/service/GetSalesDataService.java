package hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import hello.repository.SalesDataRepository;
import hello.model.SalesDataDTO;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class GetSalesDataService {

    @Autowired
    private SalesDataRepository salesDataRepository;

    private static final Logger logger = Logger.getLogger(GetSalesDataService.class.getName());

    public List<SalesDataDTO> getSalesData(int orderId, List<Item> tempItems) {
        if (orderId <= 0 || tempItems == null || tempItems.isEmpty()) {
            throw new IllegalArgumentException("Invalid orderId or tempItems");
        }

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT sd.* FROM SalesData sd ")
           .append("LEFT JOIN OrderData od ON sd.order_id = od.id ")
           .append("LEFT JOIN TempItem ti ON sd.item_id = ti.id ")
           .append("WHERE od.id = ? AND ti.id IN (");

        for (int i = 0; i < tempItems.size(); i++) {
            sql.append("?");
            if (i < tempItems.size() - 1) {
                sql.append(", ");
            }
        }
        sql.append(")");

        Object[] params = new Object[tempItems.size() + 1];
        params[0] = orderId;
        for (int i = 0; i < tempItems.size(); i++) {
            params[i + 1] = tempItems.get(i).getId();
        }

        try {
            return salesDataRepository.query(sql.toString(), params, (rs, rowNum) -> {
                SalesDataDTO salesData = new SalesDataDTO();
                salesData.setId(rs.getInt("id"));
                salesData.setOrderId(rs.getInt("order_id"));
                salesData.setAmount(rs.getDouble("amount"));
                salesData.setItemId(rs.getInt("item_id"));
                salesData.setQuantity(rs.getInt("quantity"));
                salesData.setPrice(rs.getDouble("price"));
                return salesData;
            });
        } catch (DataAccessException e) {
            logger.log(Level.SEVERE, "Error retrieving sales data", e);
            throw new RuntimeException("Database error occurred while retrieving sales data", e);
        }
    }
}