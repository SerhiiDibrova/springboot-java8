package db.migration;

CREATE TABLE #TempItems (
    order_id INT PRIMARY KEY,
    item_name VARCHAR(255),
    quantity INT,
    price DECIMAL(10, 2)
);

-- Execution context for creating the temporary table
BEGIN TRANSACTION;

-- Drop the temporary table if it exists
IF OBJECT_ID('tempdb..#TempItems') IS NOT NULL
    DROP TABLE #TempItems;

-- Create the temporary table
CREATE TABLE #TempItems (
    order_id INT PRIMARY KEY,
    item_name VARCHAR(255),
    quantity INT,
    price DECIMAL(10, 2)
);

COMMIT;