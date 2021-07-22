package com.Alevel;

import java.util.List;

public class Authors {

    String idAuthor;
    String name;
    String sunname;
    List<Books> booksList;

    public void createAuthor(){}

    public String getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(String idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSunname() {
        return sunname;
    }

    public void setSunname(String sunname) {
        this.sunname = sunname;
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
                "idAuthor='" + idAuthor + '\'' +
                ", name='" + name + '\'' +
                ", sunname='" + sunname + '\'' +
                ", booksList=" + booksList +
                '}';
    }
}
