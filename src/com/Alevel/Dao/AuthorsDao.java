package com.Alevel.Dao;

import com.Alevel.Authors;

import java.util.List;

public interface AuthorsDao {
    void createAuthor (Authors author);
    void updateAuthor (Authors author);
    void deleteAuthor (String idAuhtor);
    Authors findById (String idAuhtor);
    List<Authors> findAll();
}
