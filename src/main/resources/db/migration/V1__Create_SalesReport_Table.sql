package db.migration;

CREATE TEMPORARY TABLE #SalesReport (
    Order_Identifier INT,
    Customer_FullName VARCHAR(255),
    Product_Name VARCHAR(255),
    Quantity INT,
    Total_Amount DECIMAL(10, 2),
    Order_Date DATETIME
);