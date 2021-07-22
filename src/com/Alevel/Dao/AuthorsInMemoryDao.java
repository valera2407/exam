package com.Alevel.Dao;

import com.Alevel.Authors;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AuthorsInMemoryDao implements AuthorsDao {

    private List<Authors> authors = new ArrayList<>();

    @Override
    public void createAuthor(Authors author) {
        author.setIdAuthor(generateId());
        authors.add(author);
    }

    @Override
    public void updateAuthor(Authors author) {
        Authors current = authors.stream().filter(a -> a.getIdAuthor().equals(author.getIdAuthor())).findFirst().get();
        current.setName(author.getName());
        current.setSunname(author.getSunname());
        current.setBooksList(author.getBooksList());
    }

    @Override
    public void deleteAuthor(String idAuhtor) {
        authors.removeIf(a -> a.getIdAuthor().equals(idAuhtor));
    }

    @Override
    public Authors findById(String idAuhtor) {
        return  authors.stream().filter(a -> a.getIdAuthor().equals(idAuhtor)).findFirst().get();
    }

    @Override
    public List<Authors> findAll() {
        return authors;
    }

    private String generateId() {
        String idAuhtor = UUID.randomUUID().toString();
        if (authors.stream().anyMatch(book -> book.getIdAuthor().equals(idAuhtor))) {
            return generateId();
        }
        return idAuhtor;
    }
}
