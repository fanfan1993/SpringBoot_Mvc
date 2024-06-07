package com.example.demo.dao;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.IDENTITY;


// 数据库的实体类
// Entity 映射到数据库的表一个对象
@Entity
@Table(name="t_book") // 就是我的数据表
public class Book {

    @Id // 自增的数据库
    @Column(name="id")
    @GeneratedValue(strategy = IDENTITY) // //GenerationType.IDENTITY
    private long id;

    @Column(name="name") // java字段映射到数据库表中的数据
    private String name;

    @Column(name="author") //
    private String author;

    @Column(name="price") //
    private double price;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }
}
