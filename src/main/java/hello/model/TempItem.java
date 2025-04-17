

package hello.model;

import java.lang.Override;
import java.lang.String;

public class TempItem {
    private String orderId;
    private String customerSegment;
    private String productCategory;
    private String productSubcategory;
    private String productContainer;
    private String productName;
    private String productBaseMargin;
    private String productStatus;
    private String productCategoryName;
    private String productSubcategoryName;
    private String productContainerName;
    private String productBaseMarginName;
    private String productStatusName;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerSegment() {
        return customerSegment;
    }

    public void setCustomerSegment(String customerSegment) {
        this.customerSegment = customerSegment;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSubcategory() {
        return productSubcategory;
    }

    public void setProductSubcategory(String productSubcategory) {
        this.productSubcategory = productSubcategory;
    }

    public String getProductContainer() {
        return productContainer;
    }

    public void setProductContainer(String productContainer) {
        this.productContainer = productContainer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductBaseMargin() {
        return productBaseMargin;
    }

    public void setProductBaseMargin(String productBaseMargin) {
        this.productBaseMargin = productBaseMargin;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    public String getProductSubcategoryName() {
        return productSubcategoryName;
    }

    public void setProductSubcategoryName(String productSubcategoryName) {
        this.productSubcategoryName = productSubcategoryName;
    }

    public String getProductContainerName() {
        return productContainerName;
    }

    public void setProductContainerName(String productContainerName) {
        this.productContainerName = productContainerName;
    }

    public String getProductBaseMarginName() {
        return productBaseMarginName;
    }

    public void setProductBaseMarginName(String productBaseMarginName) {
        this.productBaseMarginName = productBaseMarginName;
    }

    public String getProductStatusName() {
        return productStatusName;
    }

    public void setProductStatusName(String productStatusName) {
        this.productStatusName = productStatusName;
    }

    @Override
    public String toString() {
        return "TempItem{" +
                "orderId='" + orderId + '\'' +
                ", customerSegment='" + customerSegment + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", productSubcategory='" + productSubcategory + '\'' +
                ", productContainer='" + productContainer + '\'' +
                ", productName='" + productName + '\'' +
                ", productBaseMargin='" + productBaseMargin + '\'' +
                ", productStatus='" + productStatus + '\'' +
                ", productCategoryName='" + productCategoryName + '\'' +
                ", productSubcategoryName='" + productSubcategoryName + '\'' +
                ", productContainerName='" + productContainerName + '\'' +
                ", productBaseMarginName='" + productBaseMarginName + '\'' +
                ", productStatusName='" + productStatusName + '\'' +
                '}';
    }
}