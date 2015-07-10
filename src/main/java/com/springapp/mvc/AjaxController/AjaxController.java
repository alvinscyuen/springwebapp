package com.springapp.mvc.AjaxController;


import com.springapp.mvc.Person.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AjaxController {


    //show form
    @RequestMapping(value="/showFormOne", method = RequestMethod.GET)
   	public String showTestJS(){
   		return "Ajax.html";
   	}

//    how spring checks for json conversion:
//    1. Jackson lib exists in project classpath
//    2. mvc:annoation-driven is enabled
//    3. Return method annotated with ResponseBody
//    4. Spring handles json conversion automatically


    //show html form for sending JSON via AJAX
    //return Person Json
    @RequestMapping(value="/testJsonObj.json", method= RequestMethod.POST, consumes="application/json", produces="application/json")
    public @ResponseBody Person returnPersonJson(@RequestBody Person person) {

        System.out.println(person);

        return person;
    }

    //return person JSON list
    @RequestMapping(value="/testJSONArray.json", method= RequestMethod.POST, consumes="application/json", produces="application/json")
    public @ResponseBody List<Person> returnPersonArrayJson(@RequestBody List<Person> persons) {

        for(Person personobj: persons)
        System.out.println(personobj);

        return persons;
    }

    //retrieve JSON File
    @RequestMapping(value="/retrieveJSON", method=RequestMethod.GET)
    public String retrieveJSONpage(){
        return "test.json";
    }



    //controller to add some html
    @RequestMapping(value="/addsomehtml", method=RequestMethod.POST, consumes ="application/json")
    public @ResponseBody String addSomeHtml(@RequestBody Json json) {

        System.out.println(json);

        return "add some HTML";
    }









}
