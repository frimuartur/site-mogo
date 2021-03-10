//package com.itproger.models;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="emails")
//public class EmailModel {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "email_id")
//    private Long id;
//
//    private String to, subject, message;
//
//    public EmailModel() {
//
//    }
//
//    public EmailModel(String to, String subject, String message) {
//        this.to = to;
//        this.subject = subject;
//        this.message = message;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }
//
//    public String getSubject() {
//        return subject;
//    }
//
//    public void setSubject(String subject) {
//        this.subject = subject;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//}
