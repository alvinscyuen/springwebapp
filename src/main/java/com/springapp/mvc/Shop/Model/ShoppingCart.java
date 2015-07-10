package com.springapp.mvc.Shop.Model;

import com.springapp.mvc.Shop.Model.BooksDB;

public class ShoppingCart {

    int bookID;
    int orderQuantity;
    static int orderNumber = 0;



    public ShoppingCart(){}

    public ShoppingCart(int bookID, int orderQuantity) {
        this.bookID = bookID;
        this.orderQuantity = orderQuantity;
        orderNumber++;
    }

    //BookID
    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    //Quantity
    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    //return title
    public String getTitle() {
        return BooksDB.getTitle(bookID);
    }

    //return author
    public String getAuthor() {
        return BooksDB.getAuthor(bookID);
    }

    //return price
    public float getPrice() {
        return BooksDB.getPrice(bookID);
    }

    //Total Price
    public float getTotalPrice() {
        float totalP =  BooksDB.getPrice(bookID) * orderQuantity;
        float totalPr = Float.valueOf(String.format("%.2f", totalP));
        return totalPr;
    }

    public static int getOrderNumber() {
            return orderNumber;
        }
}
