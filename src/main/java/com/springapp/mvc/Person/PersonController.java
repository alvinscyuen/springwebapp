package com.springapp.mvc.Person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;


@Controller
@RequestMapping("/api")
public class PersonController {


    private static final Logger LOGGER = Logger.getLogger(PersonController.class.getName());


    @Autowired
    private PersonService personServices;

    @Autowired
    public void setPersonServices(PersonService personServices){ this.personServices = personServices;}



    //	-------------------------show form (html)------------------------
    	@RequestMapping(value="/form", method = RequestMethod.GET)
     public String showFormPage(){

    		return "PersonForm.html";
     }

    	//-------------------------submitting form using html -------------------------
    	@RequestMapping(value="/submit", method= RequestMethod.POST)
    	public String formInfoSubmit(@Valid Person person, BindingResult result){
    		//submit form info....do something with form info
    		LOGGER.info(person.toString());
    		if(result.hasErrors()){
    			System.out.println("html form has errors");
                return "PersonForm.html";
    		}

    		System.out.println(personServices.savePerson(person));
    		return "PersonForm.html";
    	}



    //	ERROR cannot resolve
    	@RequestMapping(value="/jspform", method = RequestMethod.GET)
    	public String showJspForm(Model model){
            model.addAttribute("person", new Person());

            return "PersonForm.jsp";
    	}
    	@RequestMapping(value="/jspformsubmit", method = RequestMethod.POST)
    	public String showJspFormPage(@Valid Person person, BindingResult result, ModelMap model, @RequestBody String body){

            System.out.println(body);

            if(result.hasErrors()){
                LOGGER.info("**JSP FORM ERROR DETECTED**");
                return"PersonForm.jsp";
            }

                LOGGER.info("**NO ERROR**");
                model.addAttribute("firstname", person.getFirstName());
                model.addAttribute("lastname", person.getLastName());
                model.addAttribute("email", person.getEmail());
                model.addAttribute("comments", person.getComments());

                return "PersonForm.jsp";

    	}




    //Return ModelAndView to home.JSP through JSTL
    @RequestMapping(value="/getall")
    public ModelAndView home(ModelAndView model){

        List<Person> people = personServices.getAll();
        model.setViewName("home.jsp");
        model.addObject("peopleArray", people);
        return model;
    }

    //returning request header content
    @RequestMapping(value="/display", method=RequestMethod.GET)

    public @ResponseBody String displayHeaderInfo(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader String Accept) {


        String header = "RequestHeader: " + Accept + "   Accept-Encoding: " + encoding;
        LOGGER.info("ACCEPTING-ENCODING: " + encoding + "Header ");

//        HttpHeaders responseHeaders = new HttpHeaders();
//        responseHeaders.set("MyResponseHeader", "MyValue");

        return header;
    }




    //Q: how to return in json????? using responsebody??????
    //testing and returning json
    @RequestMapping(value="/person/random", method=RequestMethod.GET)

    public @ResponseBody Person randomPerson(@RequestHeader("Accept-Encoding") String encoding, @RequestHeader String Accept, HttpServletResponse response){

        System.out.println("Accept-Encoding:" + encoding);
        System.out.println("Request Header: " + Accept);
//        response.setContentType("application/json");
        return personServices.randomPerson();
    }





    //save person
    @RequestMapping(value="/person", method=RequestMethod.GET)
    @ResponseBody
    public String savePerson(Person person){
        return personServices.savePerson(person);
    }




//    @Autowired
//    public void setPersonServices(PersonService personServices){ this.personServices = personServices;}
}
