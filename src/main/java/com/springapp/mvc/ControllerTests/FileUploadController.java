package com.springapp.mvc.ControllerTests;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.logging.Logger;

@Controller
public class FileUploadController {

    Logger LOGGER = Logger.getLogger(FileUploadController.class.getName());


    @RequestMapping(value="/showUploadForm", method=RequestMethod.GET)
    public String showUploadForm(){
        return "FileUpload.html";
    }


    @RequestMapping(value="/form", method = RequestMethod.POST)
    public String handleFormUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) throws IOException {

        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            LOGGER.info("uploading.........");
            //store files somewhere...
            return "redirect:uploadSuccess";
        }
        return "redirect:uploadFail";
    }

}
