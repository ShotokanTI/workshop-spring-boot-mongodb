package com.nelioalves.workshopmongo.dto;

import java.io.Serializable;

import com.nelioalves.workshopmongo.domain.Comment;

public class CommentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
    private AuthorDTO author;

    public CommentDTO() {
    }

    public CommentDTO(Comment obj) {
        this.text = obj.getText();
        this.author = obj.getAuthor();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

}
