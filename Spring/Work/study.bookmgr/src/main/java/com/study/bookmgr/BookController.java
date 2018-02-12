package com.study.bookmgr;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.bookmgr.inf.IServiceBook;
import com.study.bookmgr.inf.IServiceBorrow;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelBook;
import com.study.bookmgr.model.ModelBorrow;
import com.study.bookmgr.model.ModelMember;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/bmgr")
public class BookController {
	private String pageSelector = "#bookpage";
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	private ModelBook brbook = null;
	@Autowired
	IServiceBook svrbook;
	
	@Autowired
	IServiceMember svrmem;
	
	@Autowired
	IServiceBorrow svrbor;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 메인 페이지
	@RequestMapping(value = "/mainpage", method = {RequestMethod.GET,RequestMethod.POST})
	public String mainpage(Model model
	        , HttpSession session) {
		List<ModelBook> list = null;
		List<ModelMember> listm = null;
		List<ModelBorrow> listbrr = null;
		ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
		if(mem==null) {
		    listbrr = null;
		}
		else if(mem.getLevel()==0) {
		    try {
                listbrr = svrbor.selectAll();
            } catch (SQLException e) {
                logger.error("mainpage" + e.getMessage());
                
            }

	        model.addAttribute("listbrr", listbrr);
		}
		else {
		    try {
                listbrr = svrbor.selectMemID(mem.getMemID());
            } catch (SQLException e) {
                logger.error("mainpage" + e.getMessage());
            }
		    model.addAttribute("listbrr", listbrr);
		}
		try {
            list = svrbook.selectAll();
            listm = svrmem.selectAll();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("mainpage" + e.getMessage());
            
        }
		
		model.addAttribute("list", list);
        model.addAttribute("listm", listm);
        model.addAttribute("open", pageSelector);
        model.addAttribute("bookaside", "bookaside");
        
        if(mem!=null&&mem.getLevel()==0) {
            model.addAttribute("mgr", mem.getMemName());
        }
        
        if(mem!=null) {

            model.addAttribute(WebConstants.SESSION_NAME, mem);
        }
		
		return "bmgr/mainpage";
	}
	// 도서 등록
	@RequestMapping(value = "/newbook", method = RequestMethod.GET)
    public String newBook(Model model
            , HttpSession session) {
        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        model.addAttribute(WebConstants.SESSION_NAME, mem);

        if(mem!=null&&mem.getLevel()==0) {
            model.addAttribute("mgr", mem.getMemName());
        }
        model.addAttribute("bookaside", "bookaside");
        return "bmgr/newbook";
    }

    @RequestMapping(value = "/newbookcmp", method = RequestMethod.POST)
    public String newBookcomp(Model model
            , @ModelAttribute ModelBook book
            , HttpSession session) {
        try {
            int rs = svrbook.insertBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("newBookcomp" + e.getMessage());
            
        }

        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        model.addAttribute(WebConstants.SESSION_NAME, mem);
        String bookname = book.getBookname();
        model.addAttribute("bookname", bookname);
        if(mem!=null&&mem.getLevel()==0) {
            model.addAttribute("mgr", mem.getMemName());
        }
        return "bmgr/newbookcmp";
    }
    
    // 도서페이지
    @RequestMapping(value = "/bseach", method = RequestMethod.POST)
    public String bseach(Model model
            , @RequestParam(value="searchtext") String srh
            , HttpSession session) {
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
        model.addAttribute("open", "#bookpage");
        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        model.addAttribute(WebConstants.SESSION_NAME, mem);
        return "bmgr/mainpage";
    }
    @RequestMapping(value = "/modibook", method = RequestMethod.POST)
    public String modibook(Model model
            , @ModelAttribute ModelBook book
            , @RequestParam(value="no") int no
            , HttpSession session) {
        book.setNo(null);
        ModelBook wherebook = new ModelBook();
        wherebook.setNo(no);
        try {
            int rs = svrbook.updateBook(wherebook, book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("modibook" + e.getMessage());
            
        }
        pageSelector = "#bookpage";
        return "redirect:/bmgr/mainpage";
    }
    
    @RequestMapping(value = "/delbook", method = RequestMethod.POST)
    public String delbook(Model model
            , @ModelAttribute ModelBook book) {
        try {
            int rs = svrbook.deleteBook(book);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("delbook" + e.getMessage());
            
        }
        pageSelector = "#bookpage";
        return "redirect:/bmgr/mainpage";
    }
    
    
    // 대여 페이지
    @RequestMapping(value = "/brrcmp", method = RequestMethod.POST)
    public String brrcmp(Model model
            , @ModelAttribute ModelBorrow borrow) {
        
        ModelBorrow rr = null;
        try {
            rr = svrbor.selectBrrno(borrow.getBrno());
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            // e1.printStackTrace();
            logger.error("brrcmp" + e1.getMessage());
            
        }
        try {
            int rs = svrbor.deleteBorrow(borrow);
            
            svrbor.brrbookN(rr.getBookno());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrcmp" + e.getMessage());
            
        }
        pageSelector = "#rentpage";
        return "redirect:/bmgr/mainpage";
    }
    @RequestMapping(value = "/borrowbook", method = {RequestMethod.POST})
    public String borrowbook(Model model
            , @ModelAttribute ModelBook book
            , HttpSession session) {
        brbook = book;
        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        model.addAttribute(WebConstants.SESSION_NAME, mem);
        model.addAttribute("brrbook", book);
        return "bmgr/borrowbook";
    }
    
    @RequestMapping(value = "/brrbookcmp", method = {RequestMethod.POST})
    public String brrbookcmp(Model model
            , @ModelAttribute ModelBook book
            , HttpSession session) {
        long dd = new Date().getTime();
        java.sql.Date date = new java.sql.Date(dd);
        
        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        ModelBorrow brr = new ModelBorrow();
        brr.setBookname(book.getBookname());
        brr.setBookno(book.getNo());
        brr.setAuthor(book.getAuthor());
        brr.setCategory(book.getCategory());
        brr.setPublisher(book.getPublisher());
        brr.setMemid(mem.getMemID());
        brr.setMemname(mem.getMemName());
        brr.setMemphone(mem.getMemPhone());
        brr.setMememail(mem.getMemEmail());
        brr.setMemprinum(mem.getMemPriNum());
        brr.setBorrowdate(date);
        try {
            int rs = svrbor.insertBorrow(brr);
            svrbor.brrbookY(book.getNo());
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrbookcmp" + e.getMessage());
            
        }
        
        model.addAttribute(WebConstants.SESSION_NAME, mem);
        model.addAttribute("bookname", book.getBookname());
        return "bmgr/brrbookcmp";
    }
    
    @RequestMapping(value = "/brmseach", method = {RequestMethod.POST,RequestMethod.GET})
    public Object[] brmseach(String memNo) {
        List<ModelMember> lis = null;
        ModelMember member = new ModelMember();
        member.setMemNo(Integer.valueOf(memNo));
        try {
            lis = svrmem.selectEqual(member);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brmseach" + e.getMessage());
            
        }
        member = lis.get(0);
        Object[] obj = new Object[5];
        
        obj[0] = member.getMemNo();
        obj[1] = member.getMemName();
        obj[2] = member.getMemPriNum();
        obj[3] = member.getMemPhone();
        obj[4] = member.getMemEmail();
        
        
        
        
        return obj;
    }
    
    
    
	
}
