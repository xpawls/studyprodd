package com.spring81.bbs.controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring81.bbs.common.PagingHelper;
import com.spring81.bbs.common.WebConstants;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	IServiceBoard srvboard;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	

    // /board/boardlist
    // /board/boardlist?searchWord=&curPage=2
	@RequestMapping(value = "/board/boardlist", method = RequestMethod.GET)
	public String boardlist( Model model
	        , @RequestParam(defaultValue="") String searchWord 
            , @RequestParam(defaultValue="1") Integer curPage) {
		logger.info("/board/boardlist");
		
		// 전체 레코드 수 가져오기.
		int totalRecord = srvboard.getBoardTotalRecord(null, searchWord);
        // 페이징을 위한 코드 추가.
		PagingHelper paging = new PagingHelper(totalRecord, curPage, 5, 5);
		int start = paging.getStartRecord();
		int end   = paging.getEndRecord();
		List<ModelBoard> result = srvboard.getBoardPaging("", searchWord, start, end);
		
		// List
		model.addAttribute("list", result);
		
		// 페이징을 위한 변수들 추가
		model.addAttribute("curPage", curPage);
		model.addAttribute("searchWord", searchWord);
		
		// 페이징을 처리하기 위한 변수 추가
		model.addAttribute("no", paging.getListNo());
		model.addAttribute("prevLink", paging.getPrevLink());
		model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
		return "board/boardlist";
	}
	// /board/boardview  ===> /board/boardview?boardcd=free
	// /board/boardview?boardcd=qna
	@RequestMapping(value = "/board/boardview", method = RequestMethod.GET)
    public String boardview( Model model
            , @RequestParam(defaultValue="free") String boardcd ) {
        logger.info("/board/boardview");
        
        ModelBoard result = srvboard.getBoardOne(boardcd);
        String boardNm = srvboard.getBoardName(boardcd);

        // model.addAttribute("boardNm", boardNm);
        model.addAttribute("board", result);
        model.addAttribute("boardNm", result.getBoardnm());
        return "board/boardview";
    }
	
	// /board/boardview  ===> /board/boardview?boardcd=free
    // /board/boardview?boardcd=qna
    @RequestMapping(value = "/board/boardview/{boardcd}", method = RequestMethod.GET)
    public String boardviewPath( Model model
            , @PathVariable(value="boardcd") String boardcd ) {
        logger.info("/board/boardviewPath");
        
        ModelBoard result = srvboard.getBoardOne(boardcd);
        String boardNm = srvboard.getBoardName(boardcd);

        // model.addAttribute("boardNm", boardNm);
        model.addAttribute("board", result);
        model.addAttribute("boardNm", result.getBoardnm());
        return "board/boardview";
    }
    // /board/boardmodify  ===> /board/boardview?boardcd=free
    // /board/boardmodify?boardcd=qna
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.GET)
    public String boardmodify( Model model
            , @RequestParam(defaultValue="free") String boardcd 
            , HttpServletRequest request) {
        logger.info("/board/boardmodify");
        
        ModelBoard result = srvboard.getBoardOne(boardcd);
        String actionurl = request.getRequestURL().toString();

        // model.addAttribute("boardNm", boardNm);
        model.addAttribute("board", result);
        model.addAttribute("boardnm", result.getBoardnm());
        model.addAttribute("actionurl", actionurl);
        return "board/boardmodify";
    }
    
    // /board/boardmodify 
    // /board/boardmodify/qna
    @RequestMapping(value = "/board/boardmodify/{boardcd}", method = RequestMethod.GET)
    public String boardmodifyPath( Model model
            , @PathVariable(value="boardcd") String boardcd 
            , HttpServletRequest request) {
        logger.info("/board/boardmodify/{boardcd}");
        
        ModelBoard result = srvboard.getBoardOne(boardcd);
        String actionurl = request.getRequestURL().toString();

        // model.addAttribute("boardNm", boardNm);
        model.addAttribute("board", result);
        model.addAttribute("boardnm", result.getBoardnm());
        model.addAttribute("actionurl", actionurl);
        return "board/boardmodify";
    }
    
    // /board/boardmodify  ===> /board/boardview?boardcd=free
    // /board/boardmodify?boardcd=qna
    @RequestMapping(value = "/board/boardmodify", method = RequestMethod.POST)
    public String boardmodify( Model model
                             , @ModelAttribute ModelBoard setValue
                             , RedirectAttributes rttr) {
        
        logger.info("/board/boardmodify");
        ModelBoard searchValue = new ModelBoard();
        searchValue.setBoardcd(setValue.getBoardcd());
        int result = srvboard.updateBoard(searchValue, setValue);
        
        if(result>0){
            return "redirect:/board/boardlist";
        }
        else {
            // RedirectAttributes 를 이용하여 오류 메시지 전달.
            rttr.addFlashAttribute("msg", WebConstants.MSG_FAIL_UPDATE_TABLE);
            rttr.addFlashAttribute("boardcd", setValue.getBoardcd());
            return "redirect:/board/boardmodify";
        }
        
    }

    // /board/boardwrite  ===> /board/boardwrite?boardcd=free
    // /board/boardwrite?boardcd=qna
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.GET)
    public String boardwrite( Model model) {
        logger.info("/board/boardwrite");
        return "board/boardwrite";
    }

    // /board/boardwrite  ===> /board/boardwrite?boardcd=free
    // /board/boardwrite?boardcd=qna
    @RequestMapping(value = "/board/boardwrite", method = RequestMethod.POST)
    public String boardwrite( Model model
            , @ModelAttribute ModelBoard board
            , RedirectAttributes rttr) {
        logger.info("/board/boardwrite");
        
        int result = srvboard.insertBoard(board);
        
        if(result>0) {
            return "redirect:/board/boardview/"+board.getBoardcd();
        }
        else {
            rttr.addFlashAttribute("msg", WebConstants.MSG_FAIL_INSERT_TABLE);
            rttr.addFlashAttribute("board", board);
            return "redirect:/board/boardwrite";
            
        }
    }
    

    // /board/boarddelete 
    @RequestMapping(value = "/board/boarddelete", method = RequestMethod.POST)
    public String boarddelete( Model model
            , @RequestParam(value="boardcd") String boardcd
            , RedirectAttributes rttr) {
        logger.info("/board/boarddelete");
        ModelBoard board = new ModelBoard();
        board.setBoardcd(boardcd);
        int result = srvboard.deleteBoard(board);
        
        if(result>0) {
            return "redirect:/board/boardlist";
        }
        else {
            rttr.addFlashAttribute("msg", WebConstants.MSG_FAIL_DELETE_TABLE);
            rttr.addFlashAttribute("board", board);
            return "redirect:/board/boardwrite";
            
        }
    }
    
 // /board/articlelist/free?curPage=1&searchWord=&start=&end=
    @RequestMapping(value = "/board/articlelist", method = RequestMethod.GET)
    public String articlelist( Model model
            , @RequestParam(defaultValue="free") String boardcd ) {
        logger.info("/board/articlelist");
        
        
        return "redirect:/board/articlelist/"+boardcd;
    }
    
    // /board/articlelist/free?curPage=1&searchWord=&start=&end=
    @RequestMapping(value = "/board/articlelist/{boardcd}", method = RequestMethod.GET)
    public String articlelist( Model model
            , @PathVariable String boardcd
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request
            ) {
        logger.info("/board/articlelist");

        // boardnm
        // boardcd
        // searchWord
        // articleList
        // curPage
        
        
        // no
        // prevLink
        // pageLinks
        // nextLink
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        
        List<ModelArticle> result = srvboard.getArticleList(boardcd, searchWord, start, end);
        
        model.addAttribute("boardnm", srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd", boardcd);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("articleList", result);
        model.addAttribute("curPage", curPage);
        
        // 페이징 처리
        
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("prevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());
        model.addAttribute("url", request.getRequestURL().toString());
        return "board/articlelist";
    }
    

    // /board/boardview  ===> /board/boardview?boardcd=free
    // /board/articleview?boardcd=qna
    @RequestMapping(value = "/board/articleview/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articleview( Model model
            , @PathVariable String boardcd
            , @PathVariable Integer articleno 
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , HttpServletRequest request) {
        logger.info("/board/articleview");
        
        // searchWord
        // boardcd
        // articleno
        // curPage
        model.addAttribute("articleno",articleno);
        model.addAttribute("boardcd", boardcd);
        model.addAttribute("searchWord", searchWord);
        model.addAttribute("curPage", curPage);
        // boardNm
        model.addAttribute("boardNm", srvboard.getBoardName(boardcd));
        // thisArticle
        ModelArticle thisArticle = srvboard.transArticle(articleno);
        model.addAttribute("thisArticle", thisArticle);
        // attachFileList --> 첨부파일이 있는 경우.
        List<ModelAttachFile> attachFileList = srvboard.getAttachFileList(articleno);
        model.addAttribute("attachFileList", attachFileList);
        
        // commentList --> 댓글 목록을 출력하는 경우.
        List<ModelComments> commentList = srvboard.getCommentList(articleno);
        model.addAttribute("commentList", commentList);
        // nextArticle
        ModelArticle nextArticle = srvboard.getNextArticle(boardcd, articleno, searchWord);
        model.addAttribute("nextArticle", nextArticle);
        // prevArticle
        ModelArticle prevArticle = srvboard.getPrevArticle(boardcd, articleno, searchWord);
        model.addAttribute("prevArticle", prevArticle);
        // articleList
        // no
        // prevPage
        // pageLinks
        // nextLink
        int totalRecord = srvboard.getArticleTotalRecord(boardcd, searchWord);
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        int start = paging.getStartRecord();
        int end = paging.getEndRecord();
        List<ModelArticle> articleList = srvboard.getArticleList(boardcd, searchWord, start, end);
        model.addAttribute("articleList", articleList);
        model.addAttribute("no", paging.getListNo());
        model.addAttribute("PrevLink", paging.getPrevLink());
        model.addAttribute("pageLinks", paging.getPageLinks());
        model.addAttribute("nextLink", paging.getNextLink());

        // actionurl
        String actionurl = request.getRequestURL().toString();
        model.addAttribute("actionurl", actionurl);
        return "board/articleview";
    }
    
    @RequestMapping(value = "/board/articlewrite/{boardcd}", method = RequestMethod.GET)
    public String articlewrite( Model model
            , @PathVariable String boardcd
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            ) {
        logger.info("/board/articlewrite :: get");
        // boardNm
        // boardcd
        model.addAttribute("boardNm", srvboard.getBoardName(boardcd));
        model.addAttribute("boardcd", boardcd);
        
        return "board/articlewrite";
    }
    
    @RequestMapping(value = "/board/articlewrite", method = RequestMethod.POST)
    public String articlewrite( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , @ModelAttribute ModelArticle article
            , @RequestParam(value="upload") MultipartFile upload
            ) {
        logger.info("/board/articlewrite :: post");
        
        // 1. tb_bbs_article table insert. inserted 된 pk 값을 반환 받아야 한다.
        // 2. client의 파일을 server로 upload.
        // 3. tb_bbs_attachfile 테이블에 insert.
        
        // tb_bbs_article table insert. inserted 된 pk 값을 반환 받아야 한다.
        java.util.Date date1 = new java.util.Date();
        article.setRegdate(date1);
        int insertedpk = srvboard.insertArticle(article);
        
        // client의 파일을 server로 upload.
        if(!upload.getOriginalFilename().isEmpty()) {
            // 서버의 업로드 폴더 존재 여부 체크. 없으면 폴더 생성
            java.io.File uploadDir = new java.io.File(WebConstants.UPLOAD_PATH);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            // 클라이언트 파일을 서버로 복사
            String fileName = upload.getOriginalFilename();
            String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String newFile = WebConstants.UPLOAD_PATH + tempName;
            java.io.File serverfile = new java.io.File(newFile);
            
            try {
                upload.transferTo(serverfile);
            } catch (IllegalStateException | IOException e) {
                logger.error("articlewrite" + e.getMessage());
                
            }
            

            // 파일을 서버로 복사 성공 여부 체크 .
            // 성공한 경우만  tb_bbs_article table에 insert
            if(serverfile.exists()) {

                // 3. tb_bbs_attachfile 테이블에 insert.
                ModelAttachFile attachfile = new ModelAttachFile();
                attachfile.setArticleno(insertedpk);
                attachfile.setFilenameorig(fileName);

                attachfile.setFilenametemp(tempName);
                attachfile.setFilesize((int)serverfile.length());
                attachfile.setFiletype(upload.getContentType());
                int result = srvboard.insertAttachFile(attachfile);
            }
        }
        
        String url = String.format("redirect:/board/articleview/%s/%d", article.getBoardcd(), insertedpk);
        return url;
    }
    

    @RequestMapping(value = "/board/articlemodify/{boardcd}/{articleno}", method = RequestMethod.GET)
    public String articlemodify( Model model
            , @PathVariable String boardcd
            , @PathVariable Integer articleno
            
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , @ModelAttribute ModelArticle article
            , HttpServletRequest request
            ) {
        logger.info("/board/articlemodify :: get");
        
        //boardNm
        //articleno
        //boardcd
        //curPage
        //searchWord
        //thisArticle
        model.addAttribute("actionurl", request.getRequestURL().toString());
        model.addAttribute("boardNm", srvboard.getBoardName(boardcd));
        model.addAttribute("articleno", articleno);
        model.addAttribute("boardcd", boardcd);
        model.addAttribute("curPage", curPage);
        model.addAttribute("searchWord", searchWord);
        
        model.addAttribute("thisArticle", srvboard.getArticle(articleno));
        model.addAttribute("attachFileList", srvboard.getAttachFileList(articleno));
        
        
        return "board/articlemodify";
    }
    

    @RequestMapping(value = "/board/articlemodify/{boardcd}/{articleno}", method = RequestMethod.POST)
    public String articlemodify( Model model
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            , @ModelAttribute ModelArticle setValue
            , @RequestParam(value="upload") MultipartFile upload
            ) {
        logger.info("/board/articlewrite :: post");
        
        // 1. tb_bbs_article table insert. inserted 된 pk 값을 반환 받아야 한다.
        // 2. client의 파일을 server로 upload.
        // 3. tb_bbs_attachfile 테이블에 insert.
        
        
        // client의 파일을 server로 upload.
        if(!upload.getOriginalFilename().isEmpty()) {
            // 서버의 업로드 폴더 존재 여부 체크. 없으면 폴더 생성
            java.io.File uploadDir = new java.io.File(WebConstants.UPLOAD_PATH);
            if(!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            
            // 클라이언트 파일을 서버로 복사
            String fileName = upload.getOriginalFilename();
            String tempName = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String newFile = WebConstants.UPLOAD_PATH + tempName;
            java.io.File serverfile = new java.io.File(newFile);
            
            try {
                upload.transferTo(serverfile);
            } catch (IllegalStateException | IOException e) {
                logger.error("articlewrite" + e.getMessage());
                
            }
            

            // 파일을 서버로 복사 성공 여부 체크 .
            // 성공한 경우만  tb_bbs_article table에 insert
            if(serverfile.exists()) {

                // 3. tb_bbs_attachfile 테이블에 insert.
                ModelAttachFile attachfile = new ModelAttachFile();
                attachfile.setArticleno(setValue.getArticleno());
                attachfile.setFilenameorig(fileName);

                attachfile.setFilenametemp(tempName);
                attachfile.setFilesize((int)serverfile.length());
                attachfile.setFiletype(upload.getContentType());
                int result = srvboard.insertAttachFile(attachfile);
            }
            
        }

        // tb_bbs_article table update
        ModelArticle searchValue = new ModelArticle(setValue.getArticleno());
        int insertedpk = srvboard.updateArticle(setValue, searchValue);
        
        String url = String.format("redirect:/board/articleview/%s/%d", setValue.getBoardcd(), setValue.getArticleno());
        return url;
    }
    
    // REST 서비스
    @RequestMapping(value = "/board/deleteattachfile", method = RequestMethod.POST)
    @ResponseBody
    public String deleteattachfile( Model model
            , @RequestParam Integer attachfileno
            ) {
        logger.info("/board/deleteattachfile :: post");
        
        
        ModelAttachFile attachfile = new ModelAttachFile(attachfileno);
        int result = srvboard.deleteAttachFile(attachfile );
        
        return "board/articlemodify";
    }

    // REST 서비스
    @RequestMapping(value = "/board/articledelete/{boardcd}/{articleno}", method = RequestMethod.POST)
    @ResponseBody
    public String articledelete( Model model
            , @PathVariable String boardcd
            , @PathVariable Integer articleno 
            , @RequestParam(defaultValue="1") Integer curPage
            , @RequestParam(defaultValue="") String searchWord
            ) {
        logger.info("/board/articledelete :: post");
        
        // transaction 을 이용하여 삭제를 묶는 것이 좋다.
        srvboard.transDeleteArticle(articleno);
        return "board/articlemodify";
    }
}
