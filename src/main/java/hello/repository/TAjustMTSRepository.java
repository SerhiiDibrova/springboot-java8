package hello.repository;

import hello.entity.TAjustMTSEntity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TAjustMTSRepository {

    private Connection connection;

    public TAjustMTSRepository() {
        try {
            connection = DriverManager.getConnection("url", "username", "password");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public TAjustMTSEntity findTransactionDetails(String transactionId) {
        String query = "SELECT * FROM transaction_details WHERE transaction_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, transactionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    TAjustMTSEntity entity = new TAjustMTSEntity();
                    entity.setId(resultSet.getString("id"));
                    entity.setTransactionId(resultSet.getString("transaction_id"));
                    entity.setTransactionDate(resultSet.getDate("transaction_date"));
                    return entity;
                } else {
                    return null;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void bindData(TAjustMTSEntity entity) {
        try {
            // Bind data to radio groups
            String radioGroupQuery = "SELECT radio_group_value FROM radio_group_table WHERE id = ?";
            try (PreparedStatement radioGroupStatement = connection.prepareStatement(radioGroupQuery)) {
                radioGroupStatement.setString(1, entity.getId());
                try (ResultSet radioGroupResultSet = radioGroupStatement.executeQuery()) {
                    if (radioGroupResultSet.next()) {
                        entity.setRadioGroupValue(radioGroupResultSet.getString("radio_group_value"));
                    }
                }
            }

            // Bind data to combo boxes
            String comboBoxQuery = "SELECT combo_box_value FROM combo_box_table WHERE id = ?";
            try (PreparedStatement comboBoxStatement = connection.prepareStatement(comboBoxQuery)) {
                comboBoxStatement.setString(1, entity.getId());
                try (ResultSet comboBoxResultSet = comboBoxStatement.executeQuery()) {
                    if (comboBoxResultSet.next()) {
                        entity.setComboBoxValue(comboBoxResultSet.getString("combo_box_value"));
                    }
                }
            }

            // Bind data to edit boxes
            String editBoxQuery = "SELECT edit_box_value FROM edit_box_table WHERE id = ?";
            try (PreparedStatement editBoxStatement = connection.prepareStatement(editBoxQuery)) {
                editBoxStatement.setString(1, entity.getId());
                try (ResultSet editBoxResultSet = editBoxStatement.executeQuery()) {
                    if (editBoxResultSet.next()) {
                        entity.setEditBoxValue(editBoxResultSet.getString("edit_box_value"));
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void executeQueries() {
        try {
            // Execute Drop query
            String dropQuery = "DROP TABLE IF EXISTS drop_table";
            try (PreparedStatement dropStatement = connection.prepareStatement(dropQuery)) {
                dropStatement.execute();
            }

            // Execute Sortie query
            String sortieQuery = "CREATE TABLE IF NOT EXISTS sortie_table (id INT PRIMARY KEY, name VARCHAR(255))";
            try (PreparedStatement sortieStatement = connection.prepareStatement(sortieQuery)) {
                sortieStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}