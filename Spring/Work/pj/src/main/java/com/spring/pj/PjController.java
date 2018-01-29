package com.spring.pj;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

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
public class PjController {
	
	private static final Logger logger = LoggerFactory.getLogger(PjController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "pj_mn10/pj_mn11", method = RequestMethod.GET)
	public String pj_index( Model model) {
		logger.info("/pj_mn10/pj_mn11");
		return "pj_mn10/pj_mn11";
	}
	
	@RequestMapping(value = "pj_mn40/pj_mn41", method = RequestMethod.GET)
    public String pj_41( Model model) {
        logger.info("pj_mn40/pj_mn41");
        return "pj_mn40/pj_mn41";
    }
	
}
