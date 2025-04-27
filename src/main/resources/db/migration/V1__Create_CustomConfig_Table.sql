package db.migration;

CREATE TABLE CustomConfig (
    order_id INT NOT NULL,
    config_id INT NOT NULL,
    module VARCHAR(255) NOT NULL,
    PRIMARY KEY (order_id, config_id)
);