package com.study.bookmgr;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.study.bookmgr.inf.IServiceBoard;
import com.study.bookmgr.inf.IServiceBook;
import com.study.bookmgr.inf.IServiceBorrow;
import com.study.bookmgr.inf.IServiceComments;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelBoard;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
    IServiceBook svrbook;
    
    @Autowired
    IServiceMember svrmem;
    
    @Autowired
    IServiceBorrow svrbor;
    
    @Autowired
    IServiceBoard svrboard;
    
    @Autowired
    IServiceComments svrcomment;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model
	        , HttpSession session) {
		logger.info("home");
		List<ModelBoard> free = svrboard.getBoardList(null, "free", 0, 5);
		model.addAttribute("freelist",free);
        List<ModelBoard> notice = svrboard.getBoardList(null, "notice", 0, 5);
        model.addAttribute("notilist",notice);
        List<ModelBoard> subject = svrboard.getBoardList(null, "subject", 0, 5);
        model.addAttribute("subjectlist",subject);
        List<ModelBoard> qna = svrboard.getBoardList(null, "qna", 0, 5);
        model.addAttribute("qnalist",qna);
        List<ModelBoard> complain = svrboard.getBoardList(null, "complain", 0, 5);
        model.addAttribute("complainlist",complain);
        List<ModelBoard> needbook = svrboard.getBoardList(null, "needbook", 0, 5);
        model.addAttribute("needlist",needbook);
		model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
		return "home";
	}
	
	
	
}
