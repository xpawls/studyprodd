package com.study.bookmgr;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

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
	public String mainpage(Model model) {
		List<ModelBook> list = null;
		List<ModelMember> listm = null;
		List<ModelBorrow> listbrr = null;
		try {
            list = svrbook.selectAll();
            listm = svrmem.selectAll();
            listbrr = svrbor.selectAll();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("mainpage" + e.getMessage());
            
        }
		model.addAttribute("list", list);
        model.addAttribute("listm", listm);
        model.addAttribute("listbrr", listbrr);
        model.addAttribute("open", pageSelector);
		
		return "bmgr/mainpage";
	}
	// 도서 등록
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
    
    // 도서페이지
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
        model.addAttribute("open", "#bookpage");
        return "bmgr/mainpage";
    }
    @RequestMapping(value = "/modibook", method = RequestMethod.POST)
    public String modibook(Model model
            , @ModelAttribute ModelBook book
            , @RequestParam(value="no") int no) {
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
    
    // 멤버 페이지
    @RequestMapping(value = "/joinmember", method = RequestMethod.GET)
    public String joinmember(Model model) {
        
        return "bmgr/joinmember";
    }
    @RequestMapping(value = "/joinmembercmp", method = RequestMethod.POST)
    public String joinmembercomp(Model model
            , @RequestParam(value="memName") String memName
            , @RequestParam(value="memPriNum1") String memPriNum1
            , @RequestParam(value="memPriNum2") String memPriNum2
            , @RequestParam(value="memPhone1") String memPhone1
            , @RequestParam(value="memPhone2") String memPhone2
            , @RequestParam(value="memPhone3") String memPhone3
            , @RequestParam(value="memEmail") String memEmail) {
        String memPriNum = memPriNum1+"-"+memPriNum2;
        String memPhone = memPhone1+"-"+memPhone2+"-"+memPhone3;
        ModelMember member = new ModelMember(null, memName, memPriNum, memPhone, memEmail);
        try {
            int rs = svrmem.insertMember(member);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("joinmembercomp" + e.getMessage());
            
        }
        
        String bookname = member.getMemName();
        model.addAttribute("bookname", bookname);
        return "bmgr/joinmembercmp";
    }
    
    @RequestMapping(value = "/mseach", method = RequestMethod.POST)
    public String mseach(Model model
            , @RequestParam(value="msearchtext") String srh) {
        ModelMember member = new ModelMember();
        member.setMemNo(Integer.valueOf(srh));
        List<ModelMember> listm = null;
        try {
            listm = svrmem.selectEqual(member);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("mseach" + e.getMessage());
            
        }
        model.addAttribute("listm", listm);
        model.addAttribute("open", "#memberpage");
        return "bmgr/mainpage";
    }
    @RequestMapping(value = "/modimem", method = RequestMethod.POST)
    public String modimem(Model model
            , @ModelAttribute ModelMember setmember
            , @RequestParam(value="memNo") int no) {
        setmember.setMemNo(null);
        ModelMember wheremember = new ModelMember();
        wheremember.setMemNo(no);
        try {
            int rs = svrmem.updateMember(wheremember, setmember);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("modimem" + e.getMessage());
            
        }
        pageSelector = "#memberpage";
        return "redirect:/bmgr/mainpage";
    }
    
    @RequestMapping(value = "/delmem", method = RequestMethod.POST)
    public String delmem(Model model
            , @ModelAttribute ModelMember member) {
        try {
            int rs = svrmem.deleteMember(member);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("delmem" + e.getMessage());
            
        }
        pageSelector = "#memberpage";
        return "redirect:/bmgr/mainpage";
    }
    
    // 대여 페이지
    @RequestMapping(value = "/brrcmp", method = RequestMethod.POST)
    public String brrcmp(Model model
            , @ModelAttribute ModelBorrow borrow) {
        try {
            int rs = svrbor.deleteBorrow(borrow);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrcmp" + e.getMessage());
            
        }
        pageSelector = "#rentpage";
        return "redirect:/bmgr/mainpage";
    }
    @RequestMapping(value = "/borrowbook", method = {RequestMethod.POST,RequestMethod.GET})
    public String borrowbook(Model model
            , @ModelAttribute ModelBook book) {
        brbook = book;
        model.addAttribute("brrbook", book);
        return "bmgr/borrowbook";
    }
    
    @RequestMapping(value = "/brrbookcmp", method = {RequestMethod.POST,RequestMethod.GET})
    public String brrbookcmp(Model model
            , @ModelAttribute ModelBook book
            , @RequestParam(value="memNo") int memNo) {
        List<ModelMember> mlist = null;
        ModelMember member = new ModelMember();
        member.setMemNo(memNo);
        try {
            mlist = svrmem.selectEqual(member);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrbookcmp" + e.getMessage());
        }
        member = mlist.get(0);
        
        ModelBorrow brr = new ModelBorrow();
        brr.setBookname(book.getBookname());
        brr.setBookno(book.getNo());
        brr.setAuthor(book.getAuthor());
        brr.setCategory(book.getCategory());
        brr.setPublisher(book.getPublisher());
        brr.setMemname(member.getMemName());
        brr.setMemphone(member.getMemPhone());
        brr.setMememail(member.getMemEmail());
        brr.setMemprinum(member.getMemPriNum());
        brr.setBorrowdate(null);
        try {
            int rs = svrbor.insertBorrow(brr);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("brrbookcmp" + e.getMessage());
            
        }
        model.addAttribute("bookname", book.getBookname());
        return "bmgr/borrowbookcmp";
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
