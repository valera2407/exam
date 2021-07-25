package com.Alevel;

import java.util.ArrayList;
import java.util.List;

public class Authors {

    private int idAuthor;
    private String name;
    private String surname;

    private Books books = new Books();

    private List<Books> booksList = new ArrayList<>();
    public void setBooks(Books books) {
        this.books = books;
        booksList.add(this.books);
    }

    public Books getBooks() {
        return books;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Books> getBooksList() {
        return booksList;
    }

    public void setBooksList(List<Books> booksList) {
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return "Authors{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
