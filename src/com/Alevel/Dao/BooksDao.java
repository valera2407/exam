package com.Alevel.Dao;

import com.Alevel.Books;

import java.util.List;

public interface BooksDao {
    void createBook (Books book);
    void updateBook (Books book);
    void deleteBook (int idBook);
    Books findById (int idBook);
    List<Books> findAll();
}
