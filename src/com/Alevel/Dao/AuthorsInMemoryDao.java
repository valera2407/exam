package com.Alevel.Dao;

import com.Alevel.Authors;

import java.util.ArrayList;
import java.util.List;

public class AuthorsInMemoryDao implements AuthorsDao {

    private List<Authors> authors = new ArrayList<>();


    @Override
    public void createAuthor(Authors author) {
        int id = (int) (Math.random()*1000);
        author.setIdAuthor(id);
        authors.add(author);
    }

    @Override
    public void updateAuthor(Authors author) {
        Authors current = findById(author.getIdAuthor());
        current.setName(author.getName());
        current.setSurname(author.getSurname());
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
