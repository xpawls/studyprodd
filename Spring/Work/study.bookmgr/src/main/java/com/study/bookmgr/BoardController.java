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
	
	@RequestMapping(value = "bmgr/bookboard/{boardcd}", method = RequestMethod.GET)
    public String bookBoard( Model model
            , @PathVariable String boardcd
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            , HttpSession session
            ) {
        logger.info("bmgr/bookBoard");

        ModelMember mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        model.addAttribute(WebConstants.SESSION_NAME, mem);
        

        if(mem!=null&&mem.getLevel()==0) {
            model.addAttribute("mgr", mem.getMemName());
        }

        model.addAttribute("asidetype", boardcd);
        
        int totalRecord = svrboard.getBoardTotalRecord(searchWord, boardcd);
        
        
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        
        List<ModelBoard> rs = svrboard.getBoardList(searchWord, boardcd, start, end);

        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        model.addAttribute("boardlist", rs);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("curPage", curPage);
        model.addAttribute("nextLink", paging.getNextLink());
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("url", request.getRequestURL().toString());
        return "bmgr/bookBoard";
    }
	
	@RequestMapping(value = "bmgr/bookboardview/{boardcd}/{bno}", method = RequestMethod.GET)
    public String bookBoardview( Model model
            , @PathVariable String  boardcd 
            , @PathVariable Integer bno 
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            , HttpSession session) {
        logger.info("/bmgr/bookBoardview");
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
        ModelBoard nextBoard = svrboard.getNextBoard(bno, boardcd,  searchWord);
        model.addAttribute("nextBoard", nextBoard);
        // prevArticle
        ModelBoard prevBoard = svrboard.getPrevBoard(bno, boardcd,  searchWord);
        model.addAttribute("prevBoard", prevBoard);
        // articleList
        // no
        // prevPage
        // pageLinks
        // nextLink
        int totalRecord = svrboard.getBoardTotalRecord(searchWord, boardcd);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        List<ModelBoard> boardlist = svrboard.getBoardList(searchWord, boardcd, start, end);
        model.addAttribute("boardlist", boardlist);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("PrevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        model.addAttribute("asidetype", boardcd);
        model.addAttribute("boardcd", boardcd);
        
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
        return "bmgr/bookBoardView";
    }
	

    @RequestMapping(value = "bmgr/bookboardwrite/{boardcd}", method = RequestMethod.GET)
    public String bookBoardwrite( Model model
            , @PathVariable String boardcd
            , HttpSession session) {
        logger.info("/bmgr/bookBoardwrite");
        

        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        
        return "bmgr/bookBoardWrite";
    }


    @RequestMapping(value = "bmgr/bookboardwrite", method = RequestMethod.POST)
    public String bookBoardwrite( Model model
            , @RequestParam(value="title") String title
            , @RequestParam(value="content") String content
            , @RequestParam(value="boardcd") String boardcd
            , HttpSession session) {
        logger.info("/bmgr/bookBoardwrite");
        
        ModelMember member = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        long date = new Date().getTime();
        
        java.sql.Date updatedt = new java.sql.Date(date);
        
        ModelBoard Board = new ModelBoard(null,boardcd, title, content, member.getMemID(), null, updatedt, null, null);
        
        int rs = svrboard.insertBoard(Board);
        
        
        return "redirect:/bmgr/bookboardview/"+boardcd+"/" + Board.getBno();
    }
    @RequestMapping(value = "bmgr/bookboardmodify/{bno}", method = RequestMethod.GET)
    public String bookBoardmodify( Model model
            , @PathVariable Integer bno
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpSession session
            , HttpServletRequest request) {
        logger.info("/bmgr/bookBoardmodify : get");
        
        ModelBoard thisBoard = svrboard.getBoard(bno);

        model.addAttribute("boardcd", thisBoard.getBoardcd());
        model.addAttribute("thisBoard", thisBoard);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute(WebConstants.SESSION_NAME, session.getAttribute(WebConstants.SESSION_NAME));
        model.addAttribute("actionurl", request.getRequestURL().toString());
        
        return "bmgr/bookBoardModify";
    }


    @RequestMapping(value = "bmgr/bookboardmodify/{bno}", method = RequestMethod.POST)
    public String bookBoardmodify( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , @RequestParam String boardcd
            , @ModelAttribute ModelBoard updateValue
            , HttpSession session) {
        logger.info("/bmgr/bookBoardmodify : post");
        
        ModelBoard searchValue = new ModelBoard();
        searchValue.setBno(updateValue.getBno());
        
        int rs = svrboard.updateBoard(searchValue, updateValue);
        
        
        return "redirect:/bmgr/bookboardview/"+boardcd+"/" + searchValue.getBno();
    }
    
    @RequestMapping(value = "bmgr/bookboarddelete", method = RequestMethod.POST)
    @ResponseBody
    public int bookBoarddelete( @RequestBody ModelBoard board) {
        logger.info("/bmgr/bookBoarddelete : post");
        
        int rs = svrboard.deleteBoard(board.getBno());
        
        
        return rs;
    }

    @RequestMapping(value = "bmgr/bookboardmatch", method = RequestMethod.POST)
    @ResponseBody
    public int bookBoardmatch(
              @RequestBody ModelBoard board
            , HttpSession session
            ) {
        logger.info("/bmgr/bookBoardmatch : post");
        board = svrboard.getBoard(board.getBno());
        ModelMember sq = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        if(sq.getMemID().equals(board.getMemid())||sq.getLevel()==0) {
            return 1;
        }
        else {
            return 0 ;
        }
    }
    
    @RequestMapping(value = "bmgr/bookboardmatchc", method = RequestMethod.POST)
    @ResponseBody
    public int bookBoardmatchc(
              @RequestBody ModelComments comment
            , HttpSession session
            ) {
        logger.info("/bmgr/bookBoardmatchc : post");
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
    @RequestMapping(value = "bmgr/bookboardinsertc", method = RequestMethod.POST)
    //@ResponseBody
    public String bookBoardinsertc( Model model
            , @RequestBody ModelComments comment
            , HttpSession session
            ) {
        logger.info("/bmgr/bookBoardinsertc : post");
        ModelMember Mem = (ModelMember) session.getAttribute(WebConstants.SESSION_NAME);
        long date = new Date().getTime();
        
        java.sql.Date regdate = new java.sql.Date(date);
        comment.setMemid(Mem.getMemID());
        comment.setRegdate(regdate);
        
        
        int rs = svrcomment.insertComment(comment);
        
        ModelComments result = svrcomment.getCommentOne(rs);
        
        model.addAttribute("comment", result);
        
        
        return "bmgr/bookBoardView-commentlistbody" ;
    }
    
    @RequestMapping(value = "bmgr/bookboardupdatec", method = RequestMethod.POST)
    @ResponseBody
    public int bookBoardupdatec( Model model
            , @RequestBody ModelComments setValue
            ) {
        logger.info("/bmgr/bookBoardupdatec : post");
        
        int rs = -1;
        
        rs = svrcomment.updateComment(setValue.getMemo(), setValue.getCommentno());
        return rs ;
    }
    
    @RequestMapping(value = "bmgr/bookboarddeletec", method = RequestMethod.POST)
    @ResponseBody
    public int bookBoarddeletec( Model model
            , @RequestBody ModelComments comment
            ) {
        logger.info("/bmgr/bookBoarddeletec : post");
        
        int rs = -1;
        
        rs = svrcomment.deleteComment(comment.getCommentno());
        return rs ;
    }
    
}
