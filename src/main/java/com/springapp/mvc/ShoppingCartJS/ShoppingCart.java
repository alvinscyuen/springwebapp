package com.springapp.mvc.ShoppingCartJS;

import java.util.List;

public class ShoppingCart {

    List<Items> totalItems;
    int TotalPrice;


    public int getTotalPrice() {
        return TotalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        TotalPrice = totalPrice;
    }

    public List<Items> getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(List<Items> totalItems) {
        this.totalItems = totalItems;
    }
}
