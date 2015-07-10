package com.springapp.mvc.ShoppingCartJS;

public class Items {

    String itemName;
    float itemPrice;
    int itemQuantity;
    float itemSubTotalPrice;


    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public float getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    public float getItemSubTotalPrice() {
        return itemPrice*itemQuantity;
    }

    public void setItemSubTotalPrice(int itemSubTotalPrice) {
        this.itemSubTotalPrice = itemSubTotalPrice;
    }
}
