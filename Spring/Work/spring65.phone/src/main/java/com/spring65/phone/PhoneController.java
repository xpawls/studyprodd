package com.spring65.phone;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring65.phone.inf.IServicePhone;
import com.spring65.phone.model.ModelPhone;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(PhoneController.class);
    
    @Autowired
    IServicePhone               phonesvr;
    
    /**
     * Simply selects the home view to render by returning its name.
     */
    @RequestMapping(value = "writeone1", method = RequestMethod.POST)
    public String writeOnePost1(Model model, HttpServletRequest request) {
        String name = request.getParameter("name");
        String manufacturer = request.getParameter("manufacturer");
        String price = request.getParameter("price");
        ModelPhone phone = new ModelPhone(name, manufacturer,
                Integer.valueOf(price));
        int rs = phonesvr.insertPhone(phone);
        String rss = String.valueOf(rs);
        model.addAttribute("phone", phone);
        return "phone/writeOneResult";
    }
    
    // @RequestParam 로 값 넘겨 받기
    @RequestMapping(value = "writeone2", method = RequestMethod.POST)
    public String writeOnePost2(Model model,
            @RequestParam(value = "name", defaultValue = "") String name,
            @RequestParam(value = "manufacturer", defaultValue = "") String manufacturer,
            @RequestParam(value = "price", defaultValue = "") int price) {
        ModelPhone phone = new ModelPhone(name, manufacturer, price);
        int rs = phonesvr.insertPhone(phone);
        String rss = String.valueOf(rs);
        model.addAttribute("phone", phone);
        return "phone/writeOneResult";
    }
    
    // @ModelAttribute 로 값 넘겨 받기
    @RequestMapping(value = "writeone3", method = RequestMethod.POST)
    public String writeOnePost3(@ModelAttribute ModelPhone phone, Model model) {
        int rs = phonesvr.insertPhone(phone);
        model.addAttribute("phone", phone);
        return "phone/writeOneResult";
    }
    
    @RequestMapping(value = "writeoneform", method = RequestMethod.GET)
    public String writeOneForm(Model model) {
        
        return "phone/writeOneForm";
    }
    
    @RequestMapping(value = "writelist", method = RequestMethod.GET)
    public String writeListGet(Model model) {
        return "phone/writeListForm";
    }
    
    @RequestMapping(value = "writelist", method = RequestMethod.POST)
    public String writeListPost(Model model,
            @ModelAttribute RepositoryPhone phone) {
        List<ModelPhone> phonelist = phone.getPhoneItems();
        // DB insert. 어떻게?
        int rs = phonesvr.insertPhoneList(phonelist);
        model.addAttribute("list", phonelist);
        return "phone/writeListResult";
    }
    
    @RequestMapping(value = "writelistall", method = RequestMethod.GET)
    public String writeListPost(Model model) {
        List<ModelPhone> phonelist = null;
        // DB insert. 어떻게?
        phonelist = phonesvr.getPhoneList();
        model.addAttribute("list", phonelist);
        return "phone/writeListResult";
    }
}
