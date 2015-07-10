package com.springapp.mvc.Person;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Controller
//@RequestMapping(value="/")
public class HelloController {

	private final Logger LOGGER = Logger.getLogger(HelloController.class.getName());

	@Autowired
	PersonService personService;

//	----------------simple helloworld and model------------------------
	@RequestMapping(value ="/hi", method = RequestMethod.GET)
	public String HelloWorld(ModelMap model) {

		model.addAttribute("message", "String obtained from model");
		model.addAttribute("message2", "Second String obtained from model");
		return "hello.jsp";
	}

	@RequestMapping(value="/greet", method=RequestMethod.GET)
	public ModelAndView HelloUsingRequestParam(@RequestParam("name") String name, ModelAndView model){
		model.setViewName("hello.jsp");
		model.addObject("title", name);
		return model;
	}

//	--------------------testing Path Variable---------------------------
	@RequestMapping(value= "/hi/{name}", method = RequestMethod.GET)
	public ModelAndView greet(@PathVariable("name") String name){

		ModelAndView model = new ModelAndView();
		model.setViewName("hello.jsp");
		model.addObject("title", name);
		return model;
	}







	//use @ModelAttribute to load default data into your model
	@ModelAttribute("foo")
	String getFoo(){
		return"bar";
	}


	//use modelattribute parameter to get an obj stored in a flash attribute
	@RequestMapping("/a")
	String pathA(RedirectAttributes redirectAttributes){
		redirectAttributes.addFlashAttribute("attrib1", new Person());
		return "redirect:/b";
	}
	//redirected to b
	@RequestMapping("/b")
	@ResponseBody
	Person returnPerson(@ModelAttribute("attrib1") Person person){
		return person;
	}

//	//path testing
//	@RequestMapping("/path")
//	public void testPath(){
//
//		Path p1 = Paths.get("/pathzzz/file");
//		System.out.println("Path String: " + p1.toString());
//		System.out.println("FileName: " + p1.getFileName());
//		System.out.println("Name index 0 : " + p1.getName(0));
//		System.out.println("Name Count: " + p1.getNameCount());
//		System.out.println("SubPath(0,1): " + p1.subpath(0, 1));
//		System.out.println("getParent: " + p1.getParent());
//		System.out.println("Root: " + p1.getRoot());
//	}

	@RequestMapping("/personPage")
	String showPersonPage(){
		return "PersonPage.jsp";
	}


}