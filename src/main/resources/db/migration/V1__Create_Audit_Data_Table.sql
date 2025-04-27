package db.migration;

CREATE TEMPORARY TABLE #audit_data (
    id INT PRIMARY KEY,
    action VARCHAR(255),
    timestamp DATETIME,
    user_id INT,
    details TEXT
);

-- Drop the temporary table after use
DROP TABLE IF EXISTS #audit_data;