package com.Alevel.Dao;

import com.Alevel.Authors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorsInMemoryDao implements AuthorsDao {

    private List<Authors> authors = new ArrayList<>();

    @Override
    public void createAuthor(Authors author) {
        int size = authors.size();
        int id = size + 1;
        author.setIdAuthor(id);
        authors.add(author);
    }

    @Override
    public void updateAuthor(Authors author) {
        Authors current = findById(author.getIdAuthor());
        current.setName(author.getName());
        current.setSurname(author.getSurname());
        current.setBooksList(author.getBooksList());
    }

    @Override
    public void deleteAuthor(int idAuhtor) {
        authors.removeIf(a -> a.getIdAuthor() == idAuhtor);
    }

    @Override
    public Authors findById(int idAuhtor) {
        return  authors.stream().filter(a -> a.getIdAuthor() == idAuhtor).findFirst().get();
    }

    @Override
    public List<Authors> findAll() {
        return authors;
    }
}
