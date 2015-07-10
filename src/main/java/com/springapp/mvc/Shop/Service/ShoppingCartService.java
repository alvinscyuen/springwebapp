package com.springapp.mvc.Shop.Service;


import com.springapp.mvc.Shop.Model.ShoppingCart;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ShoppingCartService {


    public void addItem(ShoppingCart shoppingCart, HttpSession session){

        List<ShoppingCart> currentShoppingCart = (List<ShoppingCart>)session.getAttribute("cart");

             ShoppingCart newOrder = new ShoppingCart(shoppingCart.getBookID(), shoppingCart.getOrderQuantity());

             //if cart is empty, add item
             if(currentShoppingCart == null){
                 List<ShoppingCart> temp = new ArrayList<ShoppingCart>();
                 temp.add(newOrder);
                 session.setAttribute("cart", temp);
             }

             //see if current item already exists in session cart
             else{
                 boolean found = false;
                 Iterator sessionCart = currentShoppingCart.iterator();
                 while(!found && sessionCart.hasNext()){
                     ShoppingCart sessionItem = (ShoppingCart) sessionCart.next();
                     if(sessionItem.getBookID() == newOrder.getBookID()){
                         sessionItem.setOrderQuantity(sessionItem.getOrderQuantity() + newOrder.getOrderQuantity());
                         found=true;
                     }
                 }
                  //if no item found, add new item
                 if(!found)
                 currentShoppingCart.add(newOrder);
             }
    }


    public void removeItem(HttpServletRequest req, HttpSession session) {

        List<ShoppingCart> currentShoppingCart = (List<ShoppingCart>) session.getAttribute("cart");
        int bookIDToRemove = Integer.valueOf(req.getParameter("cartIndex"));
        int quantityToRemove = Integer.valueOf(req.getParameter("quantityRemove"));


        for (ShoppingCart sessionItem : currentShoppingCart) {
            if (sessionItem.getBookID() == bookIDToRemove) {
                sessionItem.setOrderQuantity(sessionItem.getOrderQuantity() - quantityToRemove);
                if (sessionItem.getOrderQuantity() == 0) {
                    currentShoppingCart.remove(currentShoppingCart.indexOf(sessionItem));
                    break;
                }
            }
        }
    }

    public void CheckOut(HttpServletRequest req, HttpSession session){

        List<ShoppingCart> currentShoppingCart = (List<ShoppingCart>) session.getAttribute("cart");

        int totalQuantity = 0;
        float totalPrice = 0f;
        for(ShoppingCart items: currentShoppingCart){
            totalQuantity+=items.getOrderQuantity();
            totalPrice+=items.getTotalPrice();
        }
        req.setAttribute("TotalPrice", totalPrice);
        req.setAttribute("TotalQuantity", totalQuantity);
    }

    public List<ShoppingCart> showSessionCart(HttpSession session){
        List<ShoppingCart> currentShoppingCart = (List<ShoppingCart>)session.getAttribute("cart");
        return currentShoppingCart;
        }

}
