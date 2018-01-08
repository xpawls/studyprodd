package com.spring63.mvc;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring63.mvc.model.ModelLogin;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(HomeController.class);
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        logger.info("Welcome home! The client locale is {}.", locale);
        
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG,
                DateFormat.LONG, locale);
        
        String formattedDate = dateFormat.format(date);
        
        model.addAttribute("serverTime", formattedDate);
        
        return "home";
    }
    
    @RequestMapping(value = "/spring/helloworld", method = RequestMethod.GET)
    public String helloworld(Model model) {
        model.addAttribute("msg", "helloworld!!!!!");
        
        return "/home/helloworld";
    }
    
    @RequestMapping(value = "/spring/sayHello", method = RequestMethod.GET)
    public ModelAndView sayhello(Model model) {
        
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/home/sayhello"); // View 이름
        mv.addObject("msg", "say, Hellolololo"); // 데이터 : Model정보
        
        return mv;
    }
    
    @RequestMapping(value = "/spring/redirect", method = RequestMethod.GET)
    public String redirect(Model model) {
        return "redirect:/spring/helloworld";
    }
    
    @RequestMapping(value = "/spring/forward", method = RequestMethod.GET)
    public String forward(Model model) {
        return "forward:/spring/helloworld";
    }
    
    @RequestMapping(value = "/spring/querystring", method = RequestMethod.GET)
    public String querystring(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        
        return "/home/querystring";
    }
    
    @RequestMapping(value = "/spring/querystring2", method = RequestMethod.GET)
    public String querystring2(Model model
                            , @RequestParam(value="name", defaultValue="" ) String name
                            , @RequestParam(value="phone", defaultValue="0" ) int phone) {
        model.addAttribute("name", name);
        model.addAttribute("phone", phone);
        
        return "/home/querystring";
    }

    
    @RequestMapping(value = "/spring/querypath/{name}", method = RequestMethod.GET)
    public String querypath(Model model
                            , @PathVariable(value="name") String name) {
        model.addAttribute("name", name);
        
        return "/home/querypath";
    }
    
    @RequestMapping(value = "spring/login", method = RequestMethod.GET)
    public String logInget(Model model) {
        model.addAttribute("id", "aaa");
        
        return "spring/loginget";
    }

    @RequestMapping(value = "spring/login", method = RequestMethod.POST)
    public String logInpost(Model model
            , @RequestParam(value="id") String id
            , @RequestParam(value="pw") String pw) {
        // DB 조회.
        
        // 결과 리턴: 성공여부 리턴
        model.addAttribute("id", id);
        model.addAttribute("pw", pw);
        return "spring/loginpost";
    }
    
    @RequestMapping(value = "spring/loginmodel", method = RequestMethod.GET)
    public String logInModelGet(Model model) {
        
        return "spring/loginmodelget";
    }
    
    @RequestMapping(value = "spring/loginmodel", method = RequestMethod.POST)
    public String logInModelPost(Model model
            , @ModelAttribute ModelLogin info) {
        
        model.addAttribute("info", info);
        
        return "spring/loginmodelpost";
    }
}
