package com.spring81.bbs.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.model.ModelUser;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	IServiceUser svruser;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/user/", method = RequestMethod.GET)
	public String home(Model model) {

        logger.info("Welcome home! The client locale is {}.");
		return "redirect:/user/login";
	}

    @RequestMapping(value = "/user/login", method = RequestMethod.GET)
    public String login(Model model
            , @RequestParam(defaultValue="") String url , HttpServletRequest request) {

        logger.info("/user/login : get");
        
        // 로그인 후 이동할 페이지를 변수로 넘긴다
        if(url.isEmpty())
            url = request.getHeader("Refer");
        
        model.addAttribute("url", url);
        return "user/login"; // views/user/login.jsp
    }
    

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String login(Model model
            , @RequestParam String url
            , @RequestParam String userid
            , @RequestParam String passwd 
            , HttpSession session
            , RedirectAttributes rttr) {

        logger.info("/user/login : post");
        
        
        ModelUser result = svruser.login(userid, passwd);
        
        if(result!=null) {
            // 로그인 성공
            session.setAttribute(/*세션명*/WebConstants.SESSION_NAME
                               , /*세션값*/result);
            if(url.isEmpty())
                return "redirect:/"; // --> http://localhost/ 페이지가 열림.
            else
                return "redirect:"+url;
        }
        else {
            // 로그인 실패
            //RedirectAttributes는 redirect시 사용되는 변수를 전달한 때 사용되는 객체다.
            rttr.addFlashAttribute("msg", "로그인실패");
            rttr.addFlashAttribute("url", url);
            return "redirect:/user/login"; // views/user/login.jsp
        }
        
    }

    @RequestMapping(value = "/user/logout", method = RequestMethod.GET)
    public String logout(Model model, HttpSession session) {

        logger.info("/user/logout : get");
        
        // 세션 삭제
        session.removeAttribute(WebConstants.SESSION_NAME);
        
        // DB 에서 로그아웃 정보 남기기. 생략.
        
        
        return "redirect:/";
    }
    
    @RequestMapping(value = "/user/register", method = RequestMethod.GET)
    public String register(Model model) {

        logger.info("/user/register : get");
        
        
        
        return "user/register";
    }
    
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public String register(Model model
            , @ModelAttribute ModelUser user) {

        logger.info("/user/register : post");
        svruser.insertUser(user);
        
        
        
        return "user/register_post";
    }
    
    @RequestMapping(value = "/user/unregister", method = RequestMethod.GET)
    public String unregister(Model model) {

        logger.info("/user/unregister : get");
        
        
        
        return "user/unregister";
    }

    @RequestMapping(value = "/user/unregister", method = RequestMethod.POST)
    public String unregister(Model model
            , @ModelAttribute ModelUser user) {
        

        logger.info("/user/unregister : post");
        
        
        
        return "user/unregister_post";
    }
}
