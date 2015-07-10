package com.springapp.mvc.FormValidation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller
public class FormController {

    private final Logger LOGGER = Logger.getLogger(FormController.class.getName());


    @RequestMapping(value="/subscriberForm", method= RequestMethod.GET)
    public String loadFormPage(Model m){
        m.addAttribute("subscriber", new Subscriber());
        return "SubscriberForm.jsp";
    }

    @RequestMapping(value="/subscriberFormSubmit", method=RequestMethod.POST)
    public String submitForm(@Valid Subscriber subscriber, BindingResult result, Model m){
        if(result.hasErrors()){
            LOGGER.info("Errors Detected***");
            return "SubscriberForm.jsp";
        }

        LOGGER.info("No Errors***");
        m.addAttribute("message", "Successfully saved person : " + subscriber.toString());
        return "SubscriberForm.jsp";
    }

}
