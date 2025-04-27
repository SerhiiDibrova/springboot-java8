package db.migration;

CREATE OR REPLACE FUNCTION GetDefaultManagerId(manager_id INT)
RETURNS INT AS $$
DECLARE
    default_manager_id INT;
BEGIN
    IF manager_id IS NULL THEN
        SELECT id INTO default_manager_id FROM users WHERE is_default_manager = TRUE LIMIT 1;
        IF default_manager_id IS NOT NULL THEN
            RETURN default_manager_id;
        ELSE
            RETURN NULL;
        END IF;
    ELSE
        RETURN manager_id;
    END IF;
END;
$$ LANGUAGE plpgsql;