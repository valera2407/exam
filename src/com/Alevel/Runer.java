package com.Alevel;

import com.Alevel.Dao.AuthorsDao;
import com.Alevel.Dao.AuthorsInMemoryDao;
import com.Alevel.Dao.BooksDao;
import com.Alevel.Dao.BooksInMemoryDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Runer {

    private final AuthorsDao authorsDao = new AuthorsInMemoryDao();
    private final BooksDao booksDao = new BooksInMemoryDao();
/*    List<List> lists = new LinkedList<>();
    lists.add(Books);
    lists.add(Authors);*/

    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What do you want to do?");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) ;
            if (position.equals("exit")) {
                System.exit(0);
            }
            crud(position, reader);
        } catch (IOException e) {
            System.out.println("Houston, we have a problem: = " + e.getMessage());
        }
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createBook(reader);
                break;
            case "2":
                updateBook(reader);
                break;
            case "3":
                deleteBook(reader);
                break;
            case "4":
                findByIdBook(reader);
                break;
            case "5":
                findAllBook(reader);
                break;
            case "6":
                createAuthor(reader);
                break;
            case "7":
                updateAuthor(reader);
                break;
            case "8":
                deleteAuthor(reader);
                break;
            case "9":
                findByIdAuthor(reader);
                break;
            case "10":
                findAllAuthor(reader);
                break;
        }
        runNavigation();
    }


    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create author, please enter 1");
        System.out.println("if you want update author, please enter 2");
        System.out.println("if you want delete author, please enter 3");
        System.out.println("if you want findById author, please enter 4");
        System.out.println("if you want findAll authors, please enter 5");
        System.out.println("if you want create book, please enter 6");
        System.out.println("if you want update book, please enter 7");
        System.out.println("if you want delete book, please enter 8");
        System.out.println("if you want findById book, please enter 9");
        System.out.println("if you want findAll books, please enter 10");
        System.out.println("if you want exit, please enter 'exit'");
        System.out.println();
    }

    private void createBook(BufferedReader reader) {
        try{
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your age");
            String author = reader.readLine();
            Books book = new Books();
            book.setName(name);
            book.setAuthorsList(author);
            booksDao.createBook(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void updateBook(BufferedReader reader) {
        try{
            System.out.println("Please, enter id");
            String idBook = reader.readLine();
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your age");
            String author = reader.readLine();
            Books book = new Books();
            book.setIdBook(idBook);
            book.setName(name);
            book.setAuthorsList(author);
            booksDao.updateBook(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteBook(BufferedReader reader) {
        System.out.println("delete book");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            booksDao.deleteBook(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdBook(BufferedReader reader) {
        System.out.println("findByIdBook");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Books book = booksDao.findById(id);
            System.out.println("book = " + book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllBook(BufferedReader reader) {
        System.out.println("findAllBooks");
        List<Books> booksList = booksDao.findAll();
        for (Books books : booksList) {
            System.out.println("books = " + books);
        }
    }

    private void createAuthor(BufferedReader reader) {
        try{
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your sunname");
            String sunname = reader.readLine();
            System.out.println("Please, enter your age");
            String book = reader.readLine();
            Authors author = new Authors();
            author.setName(name);
            author.setSunname(sunname);
            author.setBooksList(book);
            authorsDao.createAuthor(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void updateAuthor(BufferedReader reader) {
        try{
            System.out.println("Please, enter id");
            String idAuthor = reader.readLine();
            System.out.println("Please, enter your name");
            String name = reader.readLine();
            System.out.println("Please, enter your sunname");
            String sunname = reader.readLine();
            System.out.println("Please, enter your age");
            String book = reader.readLine();
            Authors author = new Authors();
            author.setIdAuthor(idAuthor);
            author.setName(name);
            author.setSunname(sunname);
            author.setBooksList(book);
            authorsDao.updateAuthor(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteAuthor(BufferedReader reader) {
        System.out.println("delete book");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            authorsDao.deleteAuthor(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdAuthor(BufferedReader reader) {
        System.out.println("findByIdAuthor");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            Authors author = authorsDao.findById(id);
            System.out.println("author = " + author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllAuthor(BufferedReader reader) {
        System.out.println("findAllAuthors");
        List<Authors> authorsList = authorsDao.findAll();
        for (Authors authors : authorsList) {
            System.out.println("authors = " + authors);
        }
    }
}
