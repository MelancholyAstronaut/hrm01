package ch6.dao;

import ch6.po.book;

public interface bookDao {
    book selectBookById(Integer id);
}
