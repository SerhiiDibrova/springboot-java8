package db.migration;

CREATE TABLE LegacyConfig (
    order_id INT NOT NULL,
    config_id INT NOT NULL,
    module VARCHAR(255) NOT NULL,
    PRIMARY KEY (order_id, config_id)
);

-- Example of how to join with a temporary table
-- SELECT * FROM LegacyConfig lc
-- JOIN TemporaryTable tt ON lc.order_id = tt.order_id;