package com.springapp.mvc.ControllerTests;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotels/{hotels}")
public class BookingController {

    @RequestMapping("/bookings/{booking}")
    public String gettBooking(@PathVariable Long booking){

        System.out.println(booking);
        return "book";
    }
}
