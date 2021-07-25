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


public class Runer {
    private final AuthorsDao authorsDao = new AuthorsInMemoryDao();

    private final BooksDao booksDao = new BooksInMemoryDao();

    private static int checkInt(BufferedReader reader) throws IOException {
        String num;
        num = reader.readLine();
        while (!helper(num)) {
            System.out.println("Entered value is not a number. Try again:");
            num = reader.readLine();
        }
        return Integer.parseInt(num);
    }

    private static boolean helper (String s) throws NumberFormatException {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

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
        System.out.println("\n" + "if you want create book, please enter 1" + "\n" +
                        "if you want create author, please enter 2" + "\n" +
                        "if you want update book, please enter 3" + "\n" +
                        "if you want update author, please enter 4" + "\n" +
                        "if you want delete book, please enter 5" + "\n" +
                        "if you want delete author, please enter 6" + "\n" +
                        "if you want findById book, please enter 7" + "\n" +
                        "if you want findById author, please enter 8" + "\n" +
                        "if you want findAll books, please enter 9" + "\n" +
                        "if you want findAll authors, please enter 10" + "\n" +
                        "if you want exit, please enter 'exit'");


    }

    private void createBook(BufferedReader reader) {
        System.out.println("\n" + "Let`s create new Book" + "\n");
        try{
            Books book = new Books();
            List<Authors> authors = new ArrayList<>();
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            book.setName(name);
            System.out.println("How authors are you wanna add?");
            int addAuthor = checkInt(reader);
            for (int i = 0; i < addAuthor; i++) {
                Authors author = new Authors();
                System.out.println("Enter the name for " + (i + 1) + " author");
                String nameAuthor = reader.readLine();
                author.setName(nameAuthor);
                System.out.println("Enter the surname for " + (i + 1) + " author");
                String surnameAuthor = reader.readLine();
                author.setSurname(surnameAuthor);
                author.setBooks(book);
                authorsDao.createAuthor(author);
                authors.add(author);
                book.setAuthor(author);
            }
            booksDao.createBook(book);
            System.out.println(book);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
    }

    private void updateBook(BufferedReader reader) {
        System.out.println("\n" + "Hmmm, so you want to change something in book" + "\n");
        try{
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            Books book = booksDao.findById(id);
            List<Authors> authors = book.getAuthorsList();
            System.out.println("Please, enter book name");
            String name = reader.readLine();
            book.setName(name);
            System.out.println("How much authors do you need?");
            int changeAuthors = checkInt(reader);
            for (int i = 0; i < changeAuthors; i++) {
                Authors authorChange = book.getAuthor();
                System.out.println("Enter the name for " + (i + 1) + " author");
                String nameAuthor = reader.readLine();
                authorChange.setName(nameAuthor);
                System.out.println("Enter the surname for " + (i + 1) + " author");
                String surnameAuthor = reader.readLine();
                authorChange.setSurname(surnameAuthor);
                authorChange.setBooks(book);
                authorsDao.updateAuthor(authorChange);
                authors.add(authorChange);
                book.setAuthor(authorChange);
            }
            booksDao.updateBook(book);
            System.out.println(book);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteBook(BufferedReader reader) {
        System.out.println("\n" + "I see that you want delete book" + "\n");
        try {
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            booksDao.deleteBook(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdBook(BufferedReader reader) {
        System.out.println("\n" + "Do you have ID book?" + "\n");
        try {
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            Books book = booksDao.findById(id);
            System.out.println("book = " + book + " " + book.getAuthorsList());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllBook(BufferedReader reader) {
        System.out.println("\n" + "I can show you everything" + "\n");
        List<Books> booksList = booksDao.findAll();
        for (Books books : booksList) {
            System.out.println("book = " + books + " " + books.getAuthorsList());
        }
    }

    private void createAuthor(BufferedReader reader) {
        System.out.println("\n" + "Let`s create new Author" + "\n");
        try{
            Authors author = new Authors();
            List<Books> books = author.getBooksList();
            System.out.println("Please, enter author name");
            String name = reader.readLine();
            author.setName(name);
            System.out.println("Please, enter author surname");
            String sunname = reader.readLine();
            author.setSurname(sunname);
            System.out.println("How match books are you wanna add?");
            int addBooks = checkInt(reader);
            for (int i = 0; i < addBooks; i++) {
                Books book = new Books();
                System.out.println("Enter the name for " + (i + 1) + " book");
                String nameBook = reader.readLine();
                book.setName(nameBook);
                book.setAuthor(author);
                booksDao.createBook(book);
                books.add(book);
                author.setBooks(book);
            }
            authorsDao.createAuthor(author);
            System.out.println(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void updateAuthor(BufferedReader reader) {
        System.out.println("\n" + "Hmmm, so you want to change something in author" + "\n");
        try{
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            Authors author = authorsDao.findById(id);
            List<Books> book = author.getBooksList();
            System.out.println("Please, enter author name");
            String name = reader.readLine();
            author.setName(name);
            System.out.println("Please, enter author surname");
            String sunname = reader.readLine();
            author.setSurname(sunname);
            System.out.println("How much books do you need?");
            int changeBooks = checkInt(reader);
            for (int i = 0; i < changeBooks; i++) {
                Books bookChange = author.getBooks();
                System.out.println("Enter the name for " + (i + 1) + " book");
                String nameBook = reader.readLine();
                bookChange.setName(nameBook);
                bookChange.setAuthor(author);
                booksDao.updateBook(bookChange);
                book.add(bookChange);
                author.setBooks(bookChange);
            }
            authorsDao.updateAuthor(author);
            System.out.println(author);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void deleteAuthor(BufferedReader reader) {
        System.out.println("\n" + "I see that you want delete author" + "\n");
        try {
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            authorsDao.deleteAuthor(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findByIdAuthor(BufferedReader reader) {
        System.out.println("\n" + "Do you have ID author?" + "\n");
        try {
            System.out.println("Please, enter id");
            int id = checkInt(reader);
            Authors author = authorsDao.findById(id);
            System.out.println("author = " + author + " " + author.getBooksList());
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void findAllAuthor(BufferedReader reader) {
        System.out.println("\n" + "I can show you everyone" + "\n");
        List<Authors> authorsList = authorsDao.findAll();
        for (Authors authors : authorsList) {
            System.out.println("authors = " + authors + " " + authors.getBooksList());
        }
    }
}




