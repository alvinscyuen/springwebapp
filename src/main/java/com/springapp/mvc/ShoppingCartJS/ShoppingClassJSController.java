package com.springapp.mvc.ShoppingCartJS;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShoppingClassJSController {

    @RequestMapping(value="/showShoppingCartJS", method = RequestMethod.GET)
    public String showShoppingCart(){

        return "ShoppingCartJS.html";
    }

    @RequestMapping(value="/subtotal.json", method=RequestMethod.POST, consumes = "application/json")
    public @ResponseBody float calculateSubTotal(@RequestBody Items items){

        return items.getItemSubTotalPrice();
    }


}
