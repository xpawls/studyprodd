package board.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import board.inf.IBoard;
import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;


@Repository("daoboard")
public class DaoBoard implements IBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public String getBoardName(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardOne(String boardcd) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelBoard> getBoardList() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteBoard(ModelBoard board) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertBoardList(ModelBoard item) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            int start, int end) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelArticle> getArticle(int articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteArticle(ModelArticle article) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int increaseHit(int articleno) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelArticle> getNextArticle(String boardcd, int articleno,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelArticle> getPrevArticle(String boardcd, int articleno,
            String searchWord) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFile(int attachFileNo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public List<ModelComments> getComment(int commentNo) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public List<ModelComments> getCommentList(int articleno) {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteComment(ModelComments comments) {
        // TODO Auto-generated method stub
        return 0;
    }
}
