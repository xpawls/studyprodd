package com.spring51.jstl;

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
public class StuController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(StuController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    
    
    @RequestMapping(value = "/stu/index", method = RequestMethod.GET)
    public String stu(Model model) {
        logger.info("index");
        return "/stu/index";
    }
    

    @RequestMapping(value = "/webapp/index", method = RequestMethod.GET)
    public String webapp(Model model) {
        logger.info("index");
        return "/webapp/index";
    }
    
    @RequestMapping(value = "/webapp/company1", method = RequestMethod.GET)
    public String company1(Model model) {
        logger.info("company1");
        return "/webapp/company1";
    }
    
    @RequestMapping(value = "/webapp/company2", method = RequestMethod.GET)
    public String company2(Model model) {
        logger.info("company2");
        return "/webapp/company2";
    }
    
    @RequestMapping(value = "/webapp/company3", method = RequestMethod.GET)
    public String company3(Model model) {
        logger.info("company3");
        return "/webapp/company3";
    }
    
    @RequestMapping(value = "/webapp/notice1", method = RequestMethod.GET)
    public String notice1(Model model) {
        logger.info("notice1");
        return "/webapp/notice1";
    }
    
    @RequestMapping(value = "/webapp/notice2", method = RequestMethod.GET)
    public String notice2(Model model) {
        logger.info("notice2");
        return "/webapp/notice2";
    }
    
    @RequestMapping(value = "/webapp/project", method = RequestMethod.GET)
    public String project(Model model) {
        logger.info("project");
        return "/webapp/project";
    }
    

    @RequestMapping(value = "/webapp/recruit", method = RequestMethod.GET)
    public String recruit(Model model) {
        logger.info("recruit");
        return "/webapp/recruit";
    }
    

    @RequestMapping(value = "/webapp/request", method = RequestMethod.GET)
    public String request(Model model) {
        logger.info("request");
        return "/webapp/request";
    }
}
