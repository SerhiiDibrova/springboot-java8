package db.migration;

CREATE TABLE DisplayOptions (
    config_id INT,
    option1 VARCHAR(255) CHECK (option1 IN ('value1', 'value2', 'value3')),
    option2 VARCHAR(255) CHECK (option2 IN ('value1', 'value2', 'value3')),
    option3 VARCHAR(255) CHECK (option3 IN ('value1', 'value2', 'value3')),
    option4 VARCHAR(255) CHECK (option4 IN ('value1', 'value2', 'value3')),
    option5 VARCHAR(255) CHECK (option5 IN ('value1', 'value2', 'value3')),
    FOREIGN KEY (config_id) REFERENCES CustomConfig(config_id),
    FOREIGN KEY (config_id) REFERENCES LegacyConfig(config_id),
    PRIMARY KEY (config_id)
);