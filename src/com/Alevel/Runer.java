package com.Alevel;

import com.Alevel.Dao.AuthorsDao;
import com.Alevel.Dao.AuthorsInMemoryDao;
import com.Alevel.Dao.BooksDao;
import com.Alevel.Dao.BooksInMemoryDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.lang.Integer.parseInt;

public class Runer {

    private final AuthorsDao authorsDao = new AuthorsInMemoryDao();
    private final BooksDao booksDao = new BooksInMemoryDao();


    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("What do you want to do?");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("exit")) {
                    System.exit(0);
                }
                crud(position, reader);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void crud(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createBook(reader);
                break;
            case "2":
                createAuthor(reader);
                break;
            case "3":
                updateBook(reader);
                break;
            case "4":
                updateAuthor(reader);
                break;
            case "5":
                deleteBook(reader);
                break;
            case "6":
                deleteAuthor(reader);
                break;
            case "7":
                findByIdBook(reader);
                break;
            case "8":
                findByIdAuthor(reader);
                break;
            case "9":
                findAllBook(reader);
                break;
            case "10":
                findAllAuthor(reader);
                break;
        }
        runNavigation();
    }


    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create book, please enter 1");
        System.out.println("if you want create author, please enter 2");
        System.out.println("if you want update book, please enter 3");
        System.out.println("if you want update author, please enter 4");
        System.out.println("if you want delete book, please enter 5");
        System.out.println("if you want delete author, please enter 6");
        System.out.println("if you want findById book, please enter 7");
        System.out.println("if you want findById author, please enter 8");
        System.out.println("if you want findAll books, please enter 9");
        System.out.println("if you want findAll authors, please enter 10");
        System.out.println("if you want exit, please enter 'exit'");
        System.out.println();
    }

    private void createBook(BufferedReader reader) {
        try{
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            Books book = new Books();
            List<Authors> authors = new ArrayList<>();

            book.setName(name);
            System.out.println("How authors you wanna add?");
            int addAuthor = parseInt(reader);
            for (int i = 0; i < addAuthor; i++) {
                Authors test = new Authors();
                System.out.println("Enter the name for " + (i + 1) + " author");
                String nameAuthor = reader.readLine();
                test.setName(nameAuthor);
                System.out.println("Enter the surname for " + (i + 1) + " author");
                String surnameAuthor = reader.readLine();
                test.setSurname(surnameAuthor);
                authorsDao.createAuthor(test);
                authors.add(test);
            }
            book.setAuthorsList(authors);
            booksDao.createBook(book);
            System.out.println(book);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
    }

    private void updateBook(BufferedReader reader) {
        try{
            System.out.println("Please, enter id");
            int id = parseInt(reader);
            Books book = booksDao.findById(id);
            List<Authors> authors = new ArrayList<>();

            System.out.println("Please, enter book name");
            String name = reader.readLine();
            book.setName(name);
            System.out.println("How much authors you need?");
            int changeAuthors = parseInt(reader);
            for (int i = 0; i < changeAuthors; i++) {
                Authors test = new Authors();
                System.out.println("Enter the name for " + (i + 1) + " author");
                String nameAuthor = reader.readLine();
                test.setName(nameAuthor);
                System.out.println("Enter the name for " + (i + 1) + " author");
                String surnameAuthor = reader.readLine();
                test.setSurname(surnameAuthor);
                authorsDao.updateAuthor(test);
                authors.add(test);
            }
            book.setAuthorsList(authors);
            booksDao.updateBook(book);
            System.out.println(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteBook(BufferedReader reader) {
        System.out.println("delete book");
        try {
            System.out.println("Please, enter id");
            int id = parseInt(reader);
            booksDao.deleteBook(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdBook(BufferedReader reader) {
        System.out.println("findByIdBook");
        try {
            System.out.println("Please, enter id");
            int id = parseInt(reader);
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
            System.out.println("Please, enter author name");
            String name = reader.readLine();
            System.out.println("Please, enter author surname");
            String sunname = reader.readLine();
            System.out.println("How match books you wanna add?");
            List<Books> books = new ArrayList<>();
            int addBooks = parseInt(reader);
            for (int i = 0; i < addBooks; i++) {
                Books test = new Books();
                System.out.println("Enter the name for " + (i + 1) + " book");
                String nameBook = reader.readLine();
                test.setName(nameBook);
                booksDao.createBook(test);
                books.add(test);
            }
            Authors author = new Authors();
            author.setName(name);
            author.setSurname(sunname);
            author.setBooksList(books);
            authorsDao.createAuthor(author);
            System.out.println(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void updateAuthor(BufferedReader reader) {
        try{
            System.out.println("Please, enter id");
            int id = parseInt(reader);
            Authors author = authorsDao.findById(id);
            List<Books> book = new ArrayList<>();

            System.out.println("Please, enter book name");
            String name = reader.readLine();
            author.setName(name);
            System.out.println("How much books you need?");
            int changeBooks = parseInt(reader);
            for (int i = 0; i < changeBooks; i++) {
                Books test = new Books();
                System.out.println("Enter the name for " + (i + 1) + " book");
                String nameBook = reader.readLine();
                test.setName(nameBook);
                booksDao.updateBook(test);
                book.add(test);
            }
            author.setBooksList(book);
            authorsDao.updateAuthor(author);
            System.out.println(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteAuthor(BufferedReader reader) {
        System.out.println("delete book");
        try {
            System.out.println("Please, enter id");
            int id = parseInt(reader);
            authorsDao.deleteAuthor(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdAuthor(BufferedReader reader) {
        System.out.println("findByIdAuthor");
        try {
            System.out.println("Please, enter id");
            int id = parseInt(reader);
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

    private static int parseInt(BufferedReader reader) throws IOException {
        String num;
        num = reader.readLine();
        while (!isDigit(num)) {
            System.out.println("Entered value is not a number. Try again:");
            num = reader.readLine();
        }
        return Integer.parseInt(num);
    }

    private static boolean isDigit(String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}




