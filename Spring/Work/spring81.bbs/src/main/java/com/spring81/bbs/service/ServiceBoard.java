package com.spring81.bbs.service;

import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.spring81.bbs.inf.IBoard;
import com.spring81.bbs.inf.IServiceBoard;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;

@Service("serviceboard")
public class ServiceBoard implements IServiceBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daoboard")
    private IBoard dao;
    
    
    @Override
    public String getBoardName(String boardcd) {
        String rs = null;
        try {
            rs = dao.getBoardName(boardcd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardName" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard rs = new ModelBoard();
        try {
            rs = dao.getBoardOne(boardcd);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardOne" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBoard> getBoardList(String searchWord) {
        List<ModelBoard> rs = null;
        try {
            rs = dao.getBoardList(searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertBoard(ModelBoard board) {
        int rs = -1;
        try {
            rs = dao.insertBoard(board);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        int rs = -1;
        try {
            rs = dao.updateBoard(searchValue, updateValue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) {
        int rs = -1;
        try {
            rs = dao.deleteBoard(board);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        List<ModelBoard> rs = null;
        try {
            rs = dao.getBoardSearch(board);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardSearch" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        int rs = -1;
        try {
            rs = dao.getBoardTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardTotalRecord" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        List<ModelBoard> rs = null;
        try {
            rs = dao.getBoardPaging(boardcd, searchWord, start, end);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getBoardPaging" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int rs = -1;
        try {
            rs = dao.insertBoardList(list);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBoardList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int rs = -1;
        try {
            rs = dao.getArticleTotalRecord(boardcd, searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticleTotalRecord" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            int start, int end) {
        List<ModelArticle> rs = null;
        try {
            rs = dao.getArticleList(boardcd, searchWord, start, end);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticleList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelArticle getArticle(int articleno) {
        ModelArticle rs = null;
        int rr = -1;
        //rr = increaseHit(articleno);
        try {
            
            rs = dao.getArticle(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
//        
//        throw new NotImplementedException("transArticle 메서드를 사용하시오.");
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
        int rs = -1;
        try {
            rs = dao.insertArticle(article);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        int rs = -1;
        try {
            rs = dao.updateArticle(updateValue, searchValue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) {
        int rs = -1;
        try {
            rs = dao.deleteArticle(article);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int increaseHit(int articleno) {
        int rs = -1;
        try {
            rs = dao.increaseHit(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("increaseHit" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelArticle getNextArticle(String boardcd, int articleno,
            String searchWord) {
        ModelArticle rs = null;
        try {
            rs = dao.getNextArticle(boardcd, articleno, searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getNextArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelArticle getPrevArticle(String boardcd, int articleno,
            String searchWord) {
        ModelArticle rs = null;
        try {
            rs = dao.getPrevArticle(boardcd, articleno, searchWord);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getPrevArticle" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFile(int attachFileNo) {
        List<ModelAttachFile> rs = null;
        try {
            rs = dao.getAttachFile(attachFileNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getAttachFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        List<ModelAttachFile> rs = null;
        try {
            rs = dao.getAttachFileList(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getAttachFileList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        int rs = -1;
        try {
            rs = dao.insertAttachFile(attachfile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertAttachFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) {
        int rs = -1;
        try {
            rs = dao.deleteAttachFile(attachfile);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteAttachFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public ModelComments getComment(int commentNo) {
        ModelComments rs = null;
        try {
            rs = dao.getComment(commentNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getComment" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleno) {
        List<ModelComments> rs = null;
        try {
            rs = dao.getCommentList(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getCommentList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertComment(ModelComments comments) {
        int rs = -1;
        try {
            rs = dao.insertComment(comments);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertComment" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        int rs = -1;
        try {
            rs = dao.updateComment(updateValue, searchValue);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateComment" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteComment(ModelComments comments) {
        int rs = -1;
        try {
            rs = dao.deleteComment(comments);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteComment" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public ModelArticle transArticle(int articleno) {
        ModelArticle rs = null;
        int rr = -1;
        //rr = increaseHit(articleno);
        try {
                 dao.increaseHit(articleno);
            rs = dao.getArticle(articleno);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getArticle" + e.getMessage());
            throw e;
            
        }
       
        return rs;
    }

    @Override
    public int transDeleteArticle(int articleno) {
        
        int rs = -1;
        
        try {
            ModelAttachFile attachfile = new ModelAttachFile();
            attachfile.setArticleno(articleno);
            dao.deleteAttachFile(attachfile);
            dao.deleteComment(new ModelComments(articleno));
            dao.deleteArticle(new ModelArticle(articleno));
            rs = 1;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("transDeleteArticle" + e.getMessage());
            
        }
        return rs;
    }
}
