package com.Alevel.Dao;

import com.Alevel.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BooksInMemoryDao implements BooksDao{

    private List<Books> books = new ArrayList<>();

    @Override
    public void createBook(Books book) {
        int size = books.size();
        int id = size + 1;
        book.setIdBook(id);
        books.add(book);
    }

    @Override
    public void updateBook(Books book) {
        Books current = findById(book.getIdBook());
        current.setName(book.getName());
        current.setAuthorsList(book.getAuthorsList());
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
