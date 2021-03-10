package com.itproger.models;


import javax.persistence.*;

@Entity
public class ArticleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String text, title;

    public ArticleModel(String text, String title) {
        this.text = text;
        this.title = title;
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
}
