package com.study.bookmgr;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.bookmgr.inf.IServiceBoard;
import com.study.bookmgr.inf.IServiceComments;
import com.study.bookmgr.inf.IServiceMember;
import com.study.bookmgr.model.ModelBoard;
import com.study.bookmgr.model.ModelComments;
import com.study.bookmgr.model.ModelMember;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IServiceBoard svrboard;
	@Autowired
	IServiceComments svrcomment;
    @Autowired
    IServiceMember svrmem;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	@RequestMapping(value = "pj_mn30/pj_mn31", method = RequestMethod.GET)
    public String pj_mn31( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            , HttpSession session
            ) {
        logger.info("pj_mn30/pj_mn31");
        
        int totalRecord = svrboard.getBoardTotalRecord(searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        
        List<ModelBoard> rs = svrboard.getBoardList(searchWord, start, end);

        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        model.addAttribute("boardlist", rs);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("curPage", curPage);
        model.addAttribute("nextLink", paging.getNextLink());
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("url", request.getRequestURL().toString());
        return "pj_mn30/pj_mn31";
    }
	
	@RequestMapping(value = "pj_mn30/pj_mn32", method = RequestMethod.GET)
    public String pj_mn32( Model model) {
        logger.info("/pj_mn30/pj_mn32");
        return "pj_mn30/pj_mn32";
    }
	
	@RequestMapping(value = "pj_mn30/pj_mn31view/{bno}", method = RequestMethod.GET)
    public String pj_mn31view( Model model
            , @PathVariable Integer bno 
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            , HttpSession session) {
        logger.info("/pj_mn30/pj_mn31_view");
        svrboard.increaseBoardHit(bno);
        
        // searchWord
        // boardcd
        // articleno
        // curPage
        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        model.addAttribute("bno",bno);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("curPage", curPage);
        ModelBoard board = svrboard.getBoard(bno);
        
        String content = board.getContent();
        String contents = content.replace("\r\n", "<br>");
        board.setContent(contents);
        model.addAttribute("board", board);
        
        /*// commentList --> 댓글 목록을 출력하는 경우.
        List<ModelComments> commentList = srvboard.getCommentList(articleno);
        model.addAttribute("commentList", commentList);*/
        // nextArticle
        ModelBoard nextBoard = svrboard.getNextBoard(bno, searchWord);
        model.addAttribute("nextBoard", nextBoard);
        // prevArticle
        ModelBoard prevBoard = svrboard.getPrevBoard(bno, searchWord);
        model.addAttribute("prevBoard", prevBoard);
        // articleList
        // no
        // prevPage
        // pageLinks
        // nextLink
        int totalRecord = svrboard.getBoardTotalRecord(searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        List<ModelBoard> boardlist = svrboard.getBoardList(searchWord, start, end);
        model.addAttribute("boardlist", boardlist);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("PrevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        List<ModelComments> commentList = svrcomment.getComment(bno);
        
        if(commentList!=null) {
            String memo = "";
            for(int i=0; i<commentList.size(); i++) {
                memo = commentList.get(i).getMemo();
                commentList.get(i).setMemo(memo.replace("\n", "<br>"));
            }
            model.addAttribute("commentList", commentList);
        }

        // actionurl
        String url = request.getRequestURL().toString();
        model.addAttribute("url", url);
        return "pj_mn30/pj_mn31view";
    }
	

    @RequestMapping(value = "pj_mn30/pj_mn31write", method = RequestMethod.GET)
    public String pj_mn31write( Model model
            , HttpSession session) {
        logger.info("/pj_mn30/pj_mn31write");
        

        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        
        return "pj_mn30/pj_mn31write";
    }


    @RequestMapping(value = "pj_mn30/pj_mn31write", method = RequestMethod.POST)
    public String pj_mn31write( Model model
            , @RequestParam(value="title") String title
            , @RequestParam(value="content") String content
            , HttpSession session) {
        logger.info("/pj_mn30/pj_mn31write");
        
        ModelMember Mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        long date = new Date().getTime();
        
        java.sql.Date updatedt = new java.sql.Date(date);
        
        ModelBoard Board = new ModelBoard(null, title, content, Mem.getMemID(), null, updatedt, null, null);
        
        int rs = svrboard.insertBoard(Board);
        
        
        return "redirect:/pj_mn30/pj_mn31view/" + Board.getBno();
    }
    @RequestMapping(value = "pj_mn30/pj_mn31modify/{bno}", method = RequestMethod.GET)
    public String pj_mn31modify( Model model
            , @PathVariable Integer bno
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpSession session
            , HttpServletRequest request) {
        logger.info("/pj_mn30/pj_mn31modify : get");
        
        ModelBoard thisBoard = svrboard.getBoard(bno);
        
        model.addAttribute("thisBoard", thisBoard);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        model.addAttribute("actionurl", request.getRequestURL().toString());
        
        return "pj_mn30/pj_mn31modify";
    }


    @RequestMapping(value = "pj_mn30/pj_mn31modify/{bno}", method = RequestMethod.POST)
    public String pj_mn31modify( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , @ModelAttribute ModelBoard updateValue
            , HttpSession session) {
        logger.info("/pj_mn30/pj_mn31modify : post");
        
        ModelBoard searchValue = new ModelBoard();
        searchValue.setBno(updateValue.getBno());
        
        int rs = svrboard.updateBoard(searchValue, updateValue);
        
        
        return "redirect:/pj_mn30/pj_mn31view/" + searchValue.getBno();
    }
    
    @RequestMapping(value = "pj_mn30/pj_mn31delete", method = RequestMethod.POST)
    @ResponseBody
    public int pj_mn31delete( @RequestBody ModelBoard board) {
        logger.info("/pj_mn30/pj_mn31delete : post");
        
        int rs = svrboard.deleteBoard(board.getBno());
        
        
        return rs;
    }

    @RequestMapping(value = "pj_mn30/pj_mn31match", method = RequestMethod.POST)
    @ResponseBody
    public int pj_mn31match(
              @RequestBody ModelBoard board
            , HttpSession session
            ) {
        logger.info("/pj_mn30/pj_mn31match : post");
        board = svrboard.getBoard(board.getBno());
        ModelMember sq = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        if(sq.getMemID().equals(board.getMemid())||sq.getLevel()==0) {
            return 1;
        }
        else {
            return 0 ;
        }
    }
    
    @RequestMapping(value = "pj_mn30/pj_mn31matchc", method = RequestMethod.POST)
    @ResponseBody
    public int pj_mn31matchc(
              @RequestBody ModelComments comment
            , HttpSession session
            ) {
        logger.info("/pj_mn30/pj_mn31matchc : post");
        comment = svrcomment.getCommentOne(comment.getCommentno());
        ModelMember sq = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        if(sq.getMemID().equals(comment.getMemid())||sq.getLevel()==0) {
            return 1;
        }
        else {
            return 0 ;
        }
    }
    
    
    //코멘트
    @RequestMapping(value = "pj_mn30/pj_mn31insertc", method = RequestMethod.POST)
    //@ResponseBody
    public String pj_mn31insertc( Model model
            , @RequestBody ModelComments comment
            , HttpSession session
            ) {
        logger.info("/pj_mn30/pj_mn31insertc : post");
        ModelMember Mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        long date = new Date().getTime();
        
        java.sql.Date regdate = new java.sql.Date(date);
        comment.setMemid(Mem.getMemID());
        comment.setRegdate(regdate);
        
        
        int rs = svrcomment.insertComment(comment);
        
        ModelComments result = svrcomment.getCommentOne(rs);
        
        model.addAttribute("comment", result);
        
        
        return "pj_mn30/Boardview-commentlistbody" ;
    }
    
    @RequestMapping(value = "pj_mn30/pj_mn31updatec", method = RequestMethod.POST)
    @ResponseBody
    public int pj_mn31updatec( Model model
            , @RequestBody ModelComments setValue
            ) {
        logger.info("/pj_mn30/pj_mn31updatec : post");
        
        int rs = -1;
        
        rs = svrcomment.updateComment(setValue.getMemo(), setValue.getCommentno());
        return rs ;
    }
    
    @RequestMapping(value = "pj_mn30/pj_mn31deletec", method = RequestMethod.POST)
    @ResponseBody
    public int pj_mn31deletec( Model model
            , @RequestBody ModelComments comment
            ) {
        logger.info("/pj_mn30/pj_mn31deletec : post");
        
        int rs = -1;
        
        rs = svrcomment.deleteComment(comment.getCommentno());
        return rs ;
    }
    
}
