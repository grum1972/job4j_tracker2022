package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book = new Book("Book1", 115);
        Book book1 = new Book("Clean code", 520);
        Book book2 = new Book("Book3", 240);
        Book book3 = new Book("Book4", 350);
        Book[] books = new Book[4];
        books[0] = book;
        books[1] = book1;
        books[2] = book2;
        books[3] = book3;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + books[i].getName() + " pages : " + books[i].getPages());
        }
        System.out.println();
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book " + books[i].getName() + " pages : " + books[i].getPages());
        }
        for (Book b : books) {
           if ("Clean code".equals(b.getName())) {
               System.out.println("Book " + b.getName() + " pages : " + b.getPages());
           }
        }
    }
}
