package com.zhiziyun.gdt.bean;

import com.zhiziyun.platform.framework.entity.BaseEntity;

public class ReadBookPd extends BaseEntity {
    
    /**
     * 编号
     */
    private Integer id;
    
    /**
     * 名称
     */
    private String name;
    
    /**
     * 英文名称
     */
    private String enName;
    
    /**
     * 作者
     */
    private String author;
    
    /**
     * 封面
     */
    private String imgurl;
    
    /**
     * 描述
     */
    private String discription;
    
    /**
     * 创建时间
     */
    private Timestamp createTime;
    
    /**
     * creator
     */
    private Integer creator;
    
    /**
     * 更新时间
     */
    private Timestamp updateTime;
    
    /**
     * 1正常，-1删除，0下架
     */
    private Integer status;
    
    /**
     * 评论数
     */
    private Integer commentNum;
    
    /**
     * 价格，分
     */
    private Integer price;
    
    /**
     * category
     */
    private String category;

    /**
     * 获取编号
     */
    public Integer getId(){
        return id;
    }

    /**
     * 设置编号
     */
    public void setId(Integer id){
        this.id = id;
    }

    /**
     * 获取名称
     */
    public String getName(){
        return name;
    }

    /**
     * 设置名称
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * 获取英文名称
     */
    public String getEnName(){
        return enName;
    }

    /**
     * 设置英文名称
     */
    public void setEnName(String enName){
        this.enName = enName;
    }

    /**
     * 获取作者
     */
    public String getAuthor(){
        return author;
    }

    /**
     * 设置作者
     */
    public void setAuthor(String author){
        this.author = author;
    }

    /**
     * 获取封面
     */
    public String getImgurl(){
        return imgurl;
    }

    /**
     * 设置封面
     */
    public void setImgurl(String imgurl){
        this.imgurl = imgurl;
    }

    /**
     * 获取描述
     */
    public String getDiscription(){
        return discription;
    }

    /**
     * 设置描述
     */
    public void setDiscription(String discription){
        this.discription = discription;
    }

    /**
     * 获取创建时间
     */
    public Timestamp getCreateTime(){
        return createTime;
    }

    /**
     * 设置创建时间
     */
    public void setCreateTime(Timestamp createTime){
        this.createTime = createTime;
    }

    /**
     * 获取creator
     */
    public Integer getCreator(){
        return creator;
    }

    /**
     * 设置creator
     */
    public void setCreator(Integer creator){
        this.creator = creator;
    }

    /**
     * 获取更新时间
     */
    public Timestamp getUpdateTime(){
        return updateTime;
    }

    /**
     * 设置更新时间
     */
    public void setUpdateTime(Timestamp updateTime){
        this.updateTime = updateTime;
    }

    /**
     * 获取1正常，-1删除，0下架
     */
    public Integer getStatus(){
        return status;
    }

    /**
     * 设置1正常，-1删除，0下架
     */
    public void setStatus(Integer status){
        this.status = status;
    }

    /**
     * 获取评论数
     */
    public Integer getCommentNum(){
        return commentNum;
    }

    /**
     * 设置评论数
     */
    public void setCommentNum(Integer commentNum){
        this.commentNum = commentNum;
    }

    /**
     * 获取价格，分
     */
    public Integer getPrice(){
        return price;
    }

    /**
     * 设置价格，分
     */
    public void setPrice(Integer price){
        this.price = price;
    }

    /**
     * 获取category
     */
    public String getCategory(){
        return category;
    }

    /**
     * 设置category
     */
    public void setCategory(String category){
        this.category = category;
    }
}
