package com.first.model;

import java.util.Date;

public class Book {
    private Integer id;

    private String name;

    private String enName;

    private String author;

    private String imgurl;

    private Date createTime;

    private Integer creator;

    private Date updateTime;

    private Integer status;

    private Integer commentNum;

    private Integer price;

    private String category;

    private String discription;

    public Book(Integer id, String name, String enName, String author, String imgurl, Date createTime, Integer creator, Date updateTime, Integer status, Integer commentNum, Integer price, String category, String discription) {
        this.id = id;
        this.name = name;
        this.enName = enName;
        this.author = author;
        this.imgurl = imgurl;
        this.createTime = createTime;
        this.creator = creator;
        this.updateTime = updateTime;
        this.status = status;
        this.commentNum = commentNum;
        this.price = price;
        this.category = category;
        this.discription = discription;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getEnName() {
        return enName;
    }

    public void setEnName(String enName) {
        this.enName = enName == null ? null : enName.trim();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl == null ? null : imgurl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }
}