package com.spring.pj;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.pj.inf.IServiceQnaBoard;
import com.spring.pj.model.ModelQnaBoard;

/**
 * Handles requests for the application home page.
 */
@Controller
public class QnaBoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(QnaBoardController.class);
	
	@Autowired
	IServiceQnaBoard svrboard;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "pj_mn10/pj_mn11", method = RequestMethod.GET)
	public String pj_index( Model model) {
		logger.info("/pj_mn10/pj_mn11");
		return "pj_mn10/pj_mn11";
	}
	
	@RequestMapping(value = "pj_mn40/pj_mn41", method = RequestMethod.GET)
    public String pj_41( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            ) {
        logger.info("pj_mn40/pj_mn41");
        
        int totalRecord = svrboard.getQnaBoardTotalRecord(searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        
        List<ModelQnaBoard> rs = svrboard.getQnaList(searchWord, start, end);
        model.addAttribute("boardlist", rs);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("curPage", curPage);
        model.addAttribute("nextLink", paging.getNextLink());
        return "pj_mn40/pj_mn41";
    }
	
	@RequestMapping(value = "pj_mn40/pj_mn42", method = RequestMethod.GET)
    public String pj_mn42( Model model) {
        logger.info("/pj_mn40/pj_mn42");
        return "pj_mn40/pj_mn42";
    }
	
}
