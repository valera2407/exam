package com.Alevel.Dao;

import com.Alevel.Books;

import java.util.ArrayList;
import java.util.List;

public class BooksInMemoryDao implements BooksDao{

    private List<Books> books = new ArrayList<>();


    @Override
    public void createBook(Books book) {
        int id = (int) (Math.random()*1000);
        book.setIdBook(id);
        books.add(book);
    }

    @Override
    public void updateBook(Books book) {
        Books current = findById(book.getIdBook());
        current.setName(book.getName());
    }

    @Override
    public void deleteBook(int idBook) {
        books.removeIf(b -> b.getIdBook() == idBook);
    }

    @Override
    public Books findById(int idBook) {
        return  books.stream().filter(b -> b.getIdBook() == idBook).findFirst().get();
    }

    @Override
    public List<Books> findAll() {
        return books;
    }
}
