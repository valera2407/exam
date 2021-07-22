package com.Alevel.Dao;

import com.Alevel.Books;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BooksInMemoryDao implements BooksDao{

    private List<Books> books = new ArrayList<>();

    @Override
    public void createBook(Books book) {
        book.setIdBook(generateId());
        books.add(book);
    }

    @Override
    public void updateBook(Books book) {
        Books current = books.stream().filter(b -> b.getIdBook().equals(book.getIdBook())).findFirst().get();
        current.setName(book.getName());
        current.setAuthorsList(book.getAuthorsList());
    }

    @Override
    public void deleteBook(String idBook) {
        books.removeIf(b -> b.getIdBook().equals(idBook));
    }

    @Override
    public Books findById(String idBook) {
        return  books.stream().filter(b -> b.getIdBook().equals(idBook)).findFirst().get();
    }

    @Override
    public List<Books> findAll() {
        return books;
    }

    private String generateId() {
        String idBook = UUID.randomUUID().toString();
        if (books.stream().anyMatch(book -> book.getIdBook().equals(idBook))) {
            return generateId();
        }
        return idBook;
    }
}
