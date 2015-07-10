package com.springapp.mvc.Shop.Controller;


import com.springapp.mvc.Shop.Model.BooksDB;
import com.springapp.mvc.Shop.Model.ShoppingCart;
import com.springapp.mvc.Shop.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ShopController {

    @Autowired
    ShoppingCartService shoppingCartService;


    @RequestMapping(value = "/shopOrder")
    public String displayShop() {
        return "ShopOrder.jsp";
    }

    @RequestMapping(value="/shoppingCart/remove", method = RequestMethod.POST)
    public String shoppingCartRemove(HttpServletRequest req, HttpSession session){

        shoppingCartService.removeItem(req, session);
        return "ShopOrder.jsp";
    }


    @RequestMapping(value = "/shoppingCart/add", method = RequestMethod.POST)
    public String shoppingCartAdd(ShoppingCart shoppingCart, HttpSession session, @RequestHeader String Accept, @RequestBody String body) {

        System.out.println(Accept);
        System.out.println(body);
//        System.out.println("Order Number: " + cookie);
        //call service add item to cart
        shoppingCartService.addItem(shoppingCart, session);

        return "ShopOrder.jsp";

        }

     @RequestMapping(value= "/shoppingCart/checkout", method = RequestMethod.POST)
    public String shoppingCartCheckOut(HttpServletRequest req, HttpSession session){

         shoppingCartService.CheckOut(req, session);
         return "ShopCheckOut.jsp";
     }

    @RequestMapping(value="/shoppingCart/showcart", method = RequestMethod.GET)
    public @ResponseBody List<ShoppingCart> showShoppingCart(HttpSession session){
        List<ShoppingCart> currentSessionCart = shoppingCartService.showSessionCart(session);
        return currentSessionCart;
    }

}
