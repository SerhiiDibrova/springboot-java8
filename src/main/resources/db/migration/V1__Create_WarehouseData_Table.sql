package db.migration;

CREATE TABLE WarehouseData (
    id SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT NOT NULL,
    location VARCHAR(255) NOT NULL,
    last_updated TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    supplier_name VARCHAR(255) NOT NULL,
    reorder_level INT NOT NULL,
    unit_price DECIMAL(10, 2) NOT NULL
);