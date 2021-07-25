package com.Alevel;

import java.util.ArrayList;
import java.util.List;

public class Books {

    private int idBook;
    private String name;

    private Authors author;

    private List<Authors> authorsList = new ArrayList<>();

    public void setAuthor(Authors author) {
        this.author = author;
        authorsList.add(author);
    }

    public Authors getAuthor() {
        return author;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Authors> getAuthorsList() {
        return authorsList;
    }

    public void setAuthorsList(List<Authors> authorsList) {
        this.authorsList = authorsList;
    }

    @Override
    public String toString() {
        return "Books{" +
                "idBook=" + idBook +
                ", name='" + name + '\'' +
                '}';
    }
}
