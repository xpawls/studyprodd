package com.study.bookmgr;

import java.sql.SQLException;
import java.util.List;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.bookmgr.inf.IServiceBook;
import com.study.bookmgr.inf.IServiceBorrow;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelBook;
import com.study.bookmgr.model.ModelMember;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/bmgr")
public class MemberController {
	private String pageSelector = "#bookpage";
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
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
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        
        return "bmgr/register";
    }

    @RequestMapping(value = "/newID", method = {RequestMethod.POST})
    @ResponseBody
    public int newID(@RequestParam String memID) {
        int rs = -1;
        try {
            rs = svrmem.newID(memID);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("newID" + e.getMessage());            
        }
        return rs;
    }
    // 멤버 페이지
    @RequestMapping(value = "/joinmember", method = RequestMethod.GET)
    public String joinmember(Model model) {
        
        return "bmgr/joinmember";
    }
    @RequestMapping(value = "/joinmembercmp", method = RequestMethod.POST)
    public String joinmembercomp(Model model
            , @RequestParam(value="memID") String memID
            , @RequestParam(value="memPW") String memPW
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
        member.setMemID(memID);
        member.setMemPW(memPW);
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
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model
            , @RequestParam(defaultValue = "") String url
            , HttpServletRequest request) {

        logger.info("/bmgr/login : get");
        
        // 로그인 후 이동할 페이지를 변수로 넘긴다
        if (url.isEmpty())
            url = request.getHeader("Refer");
        
        model.addAttribute("url", url);
        return "bmgr/login"; // views/user/login.jsp
    }
    

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Model model
            , @RequestParam(value="memID") String memID
            , @RequestParam(value="memPW") String memPW
            , @RequestParam String url
            , HttpSession session
            , RedirectAttributes rttr
            ) {
        ModelMember result = null;
        try {
            result = svrmem.Login(memID, memPW);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("login" + e.getMessage());
            
        }

        if (result != null) {
            // 로그인 성공
            session.setAttribute(WebConstants.SESSION_NAME,
                    /* 세션값 */result);
            if (url.isEmpty())
                return "redirect:/"; // --> http://localhost/ 페이지가 열림.
            else
                return "redirect:" + url;
        } else {
            // 로그인 실패
            // RedirectAttributes는 redirect시 사용되는 변수를 전달한 때 사용되는 객체다.
            rttr.addFlashAttribute("url", url);
            return "redirect:/bmgr/login"; // views/user/login.jsp
        }
        
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {

        logger.info("/bmgr/logout : get");
        
        session.removeAttribute(WebConstants.SESSION_NAME);
        
        return "redirect:/";
    }
}
