package com.spring.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PhoneController {
	
	private static final Logger logger = LoggerFactory.getLogger(PhoneController.class);
	
	@Autowired
	IServicePhone srvPhone;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.GET)
	public String writeone(Model model) {
		logger.info("/phone/writeone : get");
		
		
		return "writeOneForm";
	}
	
	@RequestMapping(value = "/phone/writeone", method = RequestMethod.POST)
    public String writeone(Model model
            , @ModelAttribute ModelPhone phone) {
        logger.info("/phone/writeone : post");
        int rs = -1;
        
        rs = srvPhone.insertPhone(phone);
        
        if(rs == -1) {
            return "redirect:/phone/writeone";
        }
        else {
            return "redirect:/phone/writeonelist";
        }
        
        
    }
	
	@RequestMapping(value = "/phone/writeonelist", method = RequestMethod.GET)
    public String writeonelist(Model model) {
        logger.info("/phone/writeonelist");
        
        List<ModelPhone> rs  = null;
        
        rs = srvPhone.selectAll();
        
        model.addAttribute("phone", rs);
        
        return "writeOneResult";
    }
}
