package com.itproger.models;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class ArticleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    private String title;

    @Lob
    private String text;

    public ArticleModel(Long userId, String title, String text) {
        this.userId = userId;
        this.title = title;
        this.text = text;
    }

    public ArticleModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
