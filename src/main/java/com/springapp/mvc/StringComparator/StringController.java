package com.springapp.mvc.StringComparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.logging.Logger;


@Controller
public class StringController {

    private static final Logger LOGGER = Logger.getLogger(StringController.class.getName());


    @Autowired
    StringService stringService;


    @RequestMapping(value="/stringhome")
    public String home(){
        System.out.println("homecontroller passing through.....");
        return "string.jsp";
    }


//  Requesting parameters and returning model and view
    @RequestMapping(value="/string" ,method= RequestMethod.GET)
    public ModelAndView compareString(@RequestParam(value = "input1", required=false) String input1, @RequestParam (value = "input2", required = false) String input2, ModelAndView mav){

        LOGGER.info("GET inputs: " + input1 + " " + input2);

        int compare = stringService.compare(input1, input2);
        String result = (compare>0) ? "bigger than": (compare<0 ? "less than" : "equals to" );

        String output = "according to comparator: " + input1 + " is " +result+ " " + input2;

        mav.setViewName("string.jsp");
        mav.addObject("compare", output);

        return mav;
    }
}
