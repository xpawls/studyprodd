package com.spring51.jstl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class ElController {
    

    
    private static final Logger logger = LoggerFactory
            .getLogger(JstlController.class);
    
    @RequestMapping(value = "/el/el01", method = RequestMethod.GET)
    public String el01(Model model) {
        logger.info("el01");
        return "el/el01";
    }
    
    @RequestMapping(value = "/el/el02", method = {RequestMethod.GET, RequestMethod.POST})
    public String el02(Model model) {
        logger.info("el02");
        return "el/el02";
    }
    
    @RequestMapping(value = "/el/el02sub", method = {RequestMethod.GET, RequestMethod.POST})
    public String el02sub(Model model) {
        logger.info("el02sub");
        return "el/el02sub";
    }
    
    @RequestMapping(value = "/el/el03", method = RequestMethod.GET)
    public String el03(Model model) {
        logger.info("el03");
        return "el/el03";
    }
    
    @RequestMapping(value = "/el/el04", method = {RequestMethod.GET, RequestMethod.POST})
    public String el04(Model model) {
        logger.info("el04");
        return "el/el04";
    }
    
    @RequestMapping(value = "/el/el04sub", method = {RequestMethod.GET, RequestMethod.POST})
    public String el04sub(Model model) {
        logger.info("el04sub");
        return "el/el04sub";
    }
}
