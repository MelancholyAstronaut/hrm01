package ch6.po;

import java.util.List;

public class user {
    private Integer id;
    private String name;
    private book book;

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

    public ch6.po.book getBook() {
        return book;
    }

    public void setBook(ch6.po.book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
