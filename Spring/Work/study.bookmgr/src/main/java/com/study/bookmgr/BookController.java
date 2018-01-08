package com.study.bookmgr;

import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.bookmgr.inf.IServiceBook;
import com.study.bookmgr.inf.IServiceBorrow;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelBook;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/bmgr")
public class BookController {
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	@Autowired
	IServiceBook svrbook;
	
	@Autowired
	IServiceMember svrmem;
	
	@Autowired
	IServiceBorrow svrbor;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/mainpage", method = RequestMethod.GET)
	public String mainpage(Model model) {
		List<ModelBook> list = null;
		try {
            list = svrbook.selectAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("mainpage" + e.getMessage());
            
        }
		model.addAttribute("list", list);
		return "bmgr/mainpage";
	}
	
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
    public String newBook(Model model) {
        
        return "bmgr/newbook";
    }

    @RequestMapping(value = "/newbookcmp", method = RequestMethod.POST)
    public String newBookcomp(Model model
            , @ModelAttribute ModelBook book) {
        try {
            int rs = svrbook.insertBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("newBookcomp" + e.getMessage());
            
        }
        
        String bookname = book.getBookname();
        model.addAttribute("bookname", bookname);
        return "bmgr/newbookcmp";
    }
    

    @RequestMapping(value = "/bseach", method = RequestMethod.POST)
    public String bseach(Model model
            , @RequestParam(value="searchtext") String srh) {
        ModelBook book = new ModelBook();
        book.setNo(Integer.valueOf(srh));
        List<ModelBook> list = null;
        try {
            list = svrbook.selectEqual(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("bseach" + e.getMessage());
            
        }
        model.addAttribute("list", list);
        return "bmgr/mainpage";
    }
	
	
	
}
