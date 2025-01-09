package com.kosea.project.vo;

public class ProductVO {
    private int productId;
    private String productName;
    private String description;
    private int price; // 商品価格
    private int stock; // 在庫
    private int categoryId; // カテゴリID

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    // toString()メソッド
    @Override
    public String toString() {
        return "ProductVO{" +
               "productId=" + productId +
               ", productName='" + productName + '\'' +
               ", description='" + description + '\'' +
               ", price=" + price +
               ", stock=" + stock +
               ", categoryId=" + categoryId +
               '}';
    }
}
