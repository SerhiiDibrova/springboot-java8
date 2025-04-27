package db.migration;

BEGIN TRANSACTION;

CREATE TABLE #audit_data (
    audit_id INT PRIMARY KEY,
    record_details VARCHAR(255),
    created_at DATETIME DEFAULT GETDATE()
);

-- Ensure to drop the temporary table after use
DROP TABLE IF EXISTS #audit_data;

COMMIT;