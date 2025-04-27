package db.migration;

CREATE TABLE #WarehouseReport (
    WarehouseId INT,
    WarehouseName VARCHAR(255),
    WarehouseCapacity INT,
    OrderId INT,
    RegionName VARCHAR(255),
    BranchName VARCHAR(255),
    VendorName VARCHAR(255),
    ProductCategory VARCHAR(255),
    StockLevel INT,
    LogisticsEfficiency DECIMAL(5, 2)
);