package com.spring81.bbs.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.inf.IServiceUser;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;
import com.spring81.bbs.model.ModelUser;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping(value = "/rest")
public class RestController {
    
    private static final Logger logger = LoggerFactory
            .getLogger(RestController.class);
    
    // ServiceUser 인스턴스 만들기.
    @Autowired
    IServiceUser                usersvr;
    
    @Autowired
    IServiceBoard               boardsvr;
    
    @RequestMapping(value = "/curtime", method = { RequestMethod.GET })
    @ResponseBody
    public long curtime(Model model) {
        logger.info("/curtime");
        return new Date().getTime();
    }
    
/*    // http://localhost:8080/rest/selectuserlist
    @RequestMapping(value = "/selectuserlist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelUser> selectuserlist(Model model) {
        
        List<ModelUser> list = usersvr.selectUserList(null);
        return list;
    }*/
    
    @RequestMapping(value = "/login", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public ModelUser login(String userid, String passwd) {
        
        return usersvr.login(userid, passwd);
    }
    
    @RequestMapping(value = "/logout", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int logout(String log) {
        
        return usersvr.logout(log);
    }
    
    @RequestMapping(value = "/checkuseremailpw", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int checkuseremailpw(String email, String passwd) {
        ModelUser user = new ModelUser();
        user.setEmail(email);
        user.setPasswd(passwd);
        int rs = -1;
        List<ModelUser> suser = null;
        suser = usersvr.selectUserList(user);
        if(suser==null) {
            rs = 0;
        }
        return  rs;
    }
    
    @RequestMapping(value = "/checkuserid", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int checkuserid(String userid) {
        
        return usersvr.checkuserid(userid);
    }
    
    @RequestMapping(value = "/updatepasswd", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int updatePasswd(String newPasswd, String currentPasswd, String userid) {
        
        return usersvr.updatePasswd(newPasswd, currentPasswd, userid);
    }
    /*
     * 클라이언트에서 변수명: boardcd
     * 서버의 변수명: boardcd
     * 
     */
    @RequestMapping(value = "/getboardone", method = { RequestMethod.GET })
    @ResponseBody
    public ModelBoard getBoardOne(@RequestParam("cd") String boardcd) {
        ModelBoard board = boardsvr.getBoardOne(boardcd);
        return board;
    }
    
    @RequestMapping(value = "/insertuser", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertuser(@ModelAttribute ModelUser user) {
        logger.info("/rest/insertuser");
        return usersvr.insertUser(user);
    }
    
    @RequestMapping(value = "/updateuserinfo", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int updateuser(@RequestBody ModelUser setValue
           ,              @RequestBody ModelUser whereValue) {
        logger.info("/rest/updateuserinfo");
        return usersvr.updateUserInfo(whereValue, setValue);
    }
    

    @RequestMapping(value = "/selectuserone", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public ModelUser selectuserone(@RequestBody ModelUser user) {
        logger.info("/rest/selectuserone");
        return usersvr.selectUserOne(user);
    }
    
    @RequestMapping(value = "/selectuserlist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelUser> selectuserlist(@RequestBody ModelUser user) {
        logger.info("/rest/selectuserlist");
        return usersvr.selectUserList(user);
    }
    
    @RequestMapping(value = "/getboardname", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public String getBoardName(String boardcd) {
        logger.info("/rest/getboardone");
        return boardsvr.getBoardName(boardcd);
    }
    
    @RequestMapping(value = "/getboardlist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelBoard> getBoardList(String searchWord) {
        logger.info("/rest/getBoardList");
        return boardsvr.getBoardList(searchWord);
    }
    
    @RequestMapping(value = "/getboardtotalrecord", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        logger.info("/rest/getboardtotalrecord");
        return boardsvr.getBoardTotalRecord(boardcd, searchWord);
    }
    
    @RequestMapping(value = "/getboardpaging", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord, @RequestParam(defaultValue="0") int start, @RequestParam(defaultValue="0") int end) {
        logger.info("/rest/getboardpaging");
        return boardsvr.getBoardPaging(boardcd, searchWord, start, end);
    }
    
    @RequestMapping(value = "/insertboard", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertBoard(ModelBoard board) {
        logger.info("/rest/insertboard");
        return boardsvr.insertBoard(board);
    }
    
    @RequestMapping(value = "/updateboard", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        logger.info("/rest/updateboard");
        return boardsvr.updateBoard(searchValue, updateValue);
    }
    
    @RequestMapping(value = "/deleteboard", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int deleteBoard(ModelBoard board) {
        logger.info("/rest/deleteboard");
        return boardsvr.deleteBoard(board);
    }
    
    @RequestMapping(value = "/insertboardlist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertBoardList(List<ModelBoard> list) {
        logger.info("/rest/insertboardlist");
        return boardsvr.insertBoardList(list);
    }
    
    @RequestMapping(value = "/getarticletotalrecord", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        logger.info("/rest/getArticleTotalRecord");
        return boardsvr.getArticleTotalRecord(boardcd, searchWord);
    }
    
    

    @RequestMapping(value = "/getarticlelist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelArticle> getArticleList(String boardcd, String searchWord, @RequestParam(defaultValue="0") int start, @RequestParam(defaultValue="0") int end) {
        logger.info("/rest/getArticleList");
        return boardsvr.getArticleList(boardcd, searchWord, start, end);
    }
    

    @RequestMapping(value = "/getarticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public ModelArticle getArticle(int articleno) {
        logger.info("/rest/getArticle");
        return boardsvr.getArticle(articleno);
    }
    
    @RequestMapping(value = "/insertarticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertArticle(ModelArticle article) {
        logger.info("/rest/insertArticle");
        return boardsvr.insertArticle(article);
    }
    
    @RequestMapping(value = "/deletearticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int deleteArticle(ModelArticle article) {
        logger.info("/rest/deleteArticle");
        return boardsvr.deleteArticle(article);
    }
    

    @RequestMapping(value = "/updatearticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int updateArticle(ModelArticle searchValue, ModelArticle updateValue) {
        logger.info("/rest/updateArticle");
        return boardsvr.updateArticle(updateValue, searchValue);
    }
    
    @RequestMapping(value = "/increasehit", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int increaseHit(int articleno) {
        logger.info("/rest/increaseHit");
        return boardsvr.increaseHit(articleno);
    }
    

    @RequestMapping(value = "/getnextarticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public ModelArticle getNextArticle(String boardcd, String searchWord, int articleno) {
        logger.info("/rest/getNextArticle");
        return boardsvr.getNextArticle(boardcd, articleno, searchWord);
    }
    

    @RequestMapping(value = "/getprevarticle", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public ModelArticle getPrevArticle(String boardcd, String searchWord, int articleno) {
        logger.info("/rest/getPrevArticle");
        return boardsvr.getPrevArticle(boardcd, articleno, searchWord);
    }
    
    @RequestMapping(value = "/getattachfile", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelAttachFile> getAttachFile(int attachFileNo) {
        logger.info("/rest/getAttachFile");
        return boardsvr.getAttachFile(attachFileNo);
    }
    

    @RequestMapping(value = "/getattachfilelist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        logger.info("/rest/getAttachFileList");
        return boardsvr.getAttachFileList(articleno);
    }
    
    @RequestMapping(value = "/insertattachfile", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertAttachFile(ModelAttachFile attachfile) {
        logger.info("/rest/insertAttachFile");
        return boardsvr.insertAttachFile(attachfile);
    }
    
    @RequestMapping(value = "/deleteattachfile", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int deleteAttachFile(ModelAttachFile attachfile) {
        logger.info("/rest/deleteAttachFile");
        return boardsvr.deleteAttachFile(attachfile);
    }
    
    @RequestMapping(value = "/getComment", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelComments> getComment(int commentNo) {
        logger.info("/rest/getComment");
        return boardsvr.getComment(commentNo);
    }
    
    @RequestMapping(value = "/getcommentlist", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public List<ModelComments> getCommentList(int articleno) {
        logger.info("/rest/getCommentList");
        return boardsvr.getCommentList(articleno);
    }
    

    @RequestMapping(value = "/insertcomment", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int insertComment(ModelComments comments) {
        logger.info("/rest/insertComment");
        return boardsvr.insertComment(comments);
    }
    


    @RequestMapping(value = "/deletecomment", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int deleteComment(ModelComments comments) {
        logger.info("/rest/deleteComment");
        return boardsvr.deleteComment(comments);
    }
    

    @RequestMapping(value = "/updatecomment", method = { RequestMethod.GET,
            RequestMethod.POST })
    @ResponseBody
    public int updateComment(ModelComments updateValue, ModelComments searchValue) {
        logger.info("/rest/updateComment");
        return boardsvr.updateComment(updateValue, searchValue);
    }
    
    
    
    
}
