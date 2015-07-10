package com.springapp.mvc.Shop.Model;

public class BooksDB {

    private static String[] books = {"Java for Dummies", "More Java for Dummies", "Java for Idiots", "More Java for Idiots", "Android for Beginners", "Android Programming"};

    private static String[] authors = {"Alvin", "Thomas", "Stan", "Megan", "Tom", "John"};
    private static float[] prices = {4.99f, 6.99f, 8.99f, 11.99f, 20.99f, 29.99f};

    public static int size(){
        return books.length;
    }

    public static String getTitle(int bookID){
        return books[bookID];
    }

    public static String getAuthor(int bookID){
        return authors[bookID];
    }

    public static float getPrice(int bookID){
        return prices[bookID];
    }
}
