package com.nelioalves.workshopmongo.domain;

import java.io.Serializable;
import java.util.Date;

import com.nelioalves.workshopmongo.dto.AuthorDTO;

import nonapi.io.github.classgraph.json.Id;

public class Comment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String text;
    private Date date;
    private AuthorDTO author;

    public Comment() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Comment(String id,String text, Date date, AuthorDTO author) {
        this.id = id;
        this.text = text;
        this.date = date;
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
