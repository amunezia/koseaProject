package com.kosea.project.vo;

import java.util.Date;

public class BooksVO {
    private String bookId;          // 書籍ID
    private String name;            // 書籍名
    private int unitPrice;          // 価格
    private String author;          // 著者
    private String description;     // 説明
    private String publisher;       // 出版社
    private Integer categoryId;     // カテゴリID
    private int unitsInStock;       // 在庫数
    private Date releaseDate;       // 発売日
    private String condition;       // 状態 (新品、中古など)
    private String filename;        // 画像ファイル名

    // コンストラクタ
    public BooksVO() {}

    public BooksVO(String bookId, String name, int unitPrice, String author, String description, String publisher, 
                  Integer categoryId, int unitsInStock, Date releaseDate, String condition, String filename) {
        this.bookId = bookId;
        this.name = name;
        this.unitPrice = unitPrice;
        this.author = author;
        this.description = description;
        this.publisher = publisher;
        this.categoryId = categoryId;
        this.unitsInStock = unitsInStock;
        this.releaseDate = releaseDate;
        this.condition = condition;
        this.filename = filename;
    }

    // ゲッターとセッター
    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getUnitsInStock() {
        return unitsInStock;
    }

    public void setUnitsInStock(int unitsInStock) {
        this.unitsInStock = unitsInStock;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public String toString() {
        return "BookVO{" +
                "bookId='" + bookId + '\'' +
                ", name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", publisher='" + publisher + '\'' +
                ", categoryId=" + categoryId +
                ", unitsInStock=" + unitsInStock +
                ", releaseDate=" + releaseDate +
                ", condition='" + condition + '\'' +
                ", filename='" + filename + '\'' +
                '}';
    }
}
