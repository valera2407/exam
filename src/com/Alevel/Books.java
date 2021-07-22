package com.Alevel;

import java.util.List;

public class Books {

    String idBook;
    String name;
    List<Authors> authorsList;

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
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
                "idBook='" + idBook + '\'' +
                ", name='" + name + '\'' +
                ", authorsList=" + authorsList +
                '}';
    }
}
