package com.Alevel;

import java.util.List;

public class Books {

    private int idBook;
    private String name;
    private List<Authors> authorsList;

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

   /* public void addAuthor(Authors authors){
        authorsList.add(authors);
    }*/

    @Override
    public String toString() {
        return "Books{" +
                "idBook='" + idBook + '\'' +
                ", name='" + name + '\'' +
                ", authorsList=" + authorsList +
                '}';
    }
}
