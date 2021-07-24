package com.Alevel;

import java.util.List;

public class Authors {

    private int idAuthor;
    private String name;
    private String surname;
    private List<Books> booksList;


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

    public void addBook(Books book){
        booksList.add(book);
    }

    @Override
    public String toString() {
        return "Authors{" +
                "idAuthor='" + idAuthor + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", booksList=" + booksList +
                '}';
    }
}
