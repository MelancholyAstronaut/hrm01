package com.edu.aynu.po;

import java.util.List;

public class user {
    Integer id;
    String name;
    book book;

    public com.edu.aynu.po.book getBook() {
        return book;
    }

    public void setBook(com.edu.aynu.po.book book) {
        this.book = book;
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
        this.name = name;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", book=" + book +
                '}';
    }
}
