package VistaPrivada;

import java.util.Date;

class Biblioteca {

    public static void main(String[] args) {
        System.out.println("Bienvenido a la biblioteca");
        
        Book book1 = new Book("D. Quijote de la Mancha", "Miguel de Cervantes");
        Book book2 = new Book("Pride and Prejudice", "Jane Austen");

        
        User user1 = new User("Celia");
        User user2 = new User("Laura");

        user1.borrowBook(book1);
        user2.borrowBook(book2);
        

        user2.returnBook();
    }
}

class Book {

    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void showInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

}

class User {

    private String name;
    private Book borrowedBook;

    public User(String name) {
        this.name = name;
    }

    public void borrowBook(Book book) {
        borrowedBook = book;
        System.out.println(name + " borrowed the book:");
        borrowedBook.showInfo();
    }

    public void returnBook() {
        System.out.println(name + " returned the book:");
        borrowedBook.showInfo();
        borrowedBook = null;
    }

}

class Borrow {

    private User user;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

    public Borrow(User user, Book book) {
        this.user = user;
        this.book = book;
        this.borrowDate = new Date();
    }

    public void returnBook() {
        this.returnDate = new Date();
    }

    public void showInfo() {
        System.out.println("User: " + user);
        System.out.println("Book: " + book);
        System.out.println("Borrow date: " + borrowDate);
        if (returnDate != null) {
            System.out.println("Return date: " + returnDate);
        }
    }
}