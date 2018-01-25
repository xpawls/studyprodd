package com.spring81.bbs.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring81.bbs.inf.IBoard;
import com.spring81.bbs.model.ModelArticle;
import com.spring81.bbs.model.ModelAttachFile;
import com.spring81.bbs.model.ModelBoard;
import com.spring81.bbs.model.ModelComments;


@Repository("daoboard")
public class DaoBoard implements IBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public String getBoardName(String boardcd) {
        String rs = null;
        rs = session.selectOne("mapper.mapperBoard.getBoardName", boardcd);
        return rs;
    }

    @Override
    public ModelBoard getBoardOne(String boardcd) {
        ModelBoard rs = new ModelBoard();
        rs = session.selectOne("mapper.mapperBoard.getBoardOne", boardcd);
        return rs;
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord) {
        List<ModelBoard> rs = null;
        rs = session.selectList("mapper.mapperBoard.getBoardList", searchWord);
        return rs;
    }

    @Override
    public int insertBoard(ModelBoard board) {
        int rs = -1;
        rs = session.insert("mapper.mapperBoard.insertBoard", board);
        return rs;
    }

    @Override
    public int updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        int rs = -1;
        Map<String, ModelBoard> map = new HashMap<>();
        map.put("searchValue", searchValue);
        map.put("updateValue", updateValue);
        rs = session.update("mapper.mapperBoard.updateBoard", map);
        return rs;
    }

    @Override
    public int deleteBoard(ModelBoard board) {
        int rs = -1;
        rs = session.delete("mapper.mapperBoard.deleteBoard", board);
        return rs;
    }

    @Override
    public List<ModelBoard> getBoardSearch(ModelBoard board) {
        List<ModelBoard> rs = null;
        rs = session.selectList("mapper.mapperBoard.getBoardSearch", board);
        return rs;
    }

    @Override
    public int getBoardTotalRecord(String boardcd, String searchWord) {
        int rs = -1;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        rs = session.selectOne("mapper.mapperBoard.getBoardTotalRecord", map);
        return rs;
    }

    @Override
    public List<ModelBoard> getBoardPaging(String boardcd, String searchWord,
            int start, int end) {
        List<ModelBoard> rs = null;
        Map<String, Object> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        rs = session.selectList("mapper.mapperBoard.getBoardPaging", map);
        return rs;
    }

    @Override
    public int insertBoardList(List<ModelBoard> list) {
        int rs = -1;
        rs = session.insert("mapper.mapperBoard.insertBoardList", list);
        return rs;
    }

    @Override
    public int getArticleTotalRecord(String boardcd, String searchWord) {
        int rs = -1;
        Map<String, String> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        rs = session.selectOne("mapper.mapperBoard.getArticleTotalRecord", map);
        return rs;
    }

    @Override
    public List<ModelArticle> getArticleList(String boardcd, String searchWord,
            int start, int end) {
        List<ModelArticle> rs = null;
        Map<String, Object> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        rs = session.selectList("mapper.mapperBoard.getArticleList", map);
        return rs;
    }

    @Override
    public ModelArticle getArticle(int articleno) {
        ModelArticle rs = null;
        rs = session.selectOne("mapper.mapperBoard.getArticle", articleno);
        return rs;
    }

    @Override
    public int insertArticle(ModelArticle article) {
        int rs = -1;
        rs = session.insert("mapper.mapperBoard.insertArticle", article);
        return article.getArticleno();
    }

    @Override
    public int updateArticle(ModelArticle updateValue,
            ModelArticle searchValue) {
        int rs = -1;
        Map<String, ModelArticle> map = new HashMap<>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        rs = session.update("mapper.mapperBoard.updateArticle", map);
        return rs;
    }

    @Override
    public int deleteArticle(ModelArticle article) {
        int rs = -1;
        rs = session.delete("mapper.mapperBoard.deleteArticle", article);
        return rs;
    }

    @Override
    public int increaseHit(int articleno) {
        int rs = -1;
        rs = session.update("mapper.mapperBoard.increaseHit", articleno);
        return rs;
    }

    @Override
    public ModelArticle getNextArticle(String boardcd, int articleno,
            String searchWord) {
        ModelArticle rs = null;
        Map<String, Object> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        rs = session.selectOne("mapper.mapperBoard.getNextArticle", map);
        return rs;
    }

    @Override
    public ModelArticle getPrevArticle(String boardcd, int articleno,
            String searchWord) {
        ModelArticle rs = null;
        Map<String, Object> map = new HashMap<>();
        map.put("boardcd", boardcd);
        map.put("articleno", articleno);
        map.put("searchWord", searchWord);
        rs = session.selectOne("mapper.mapperBoard.getPrevArticle", map);
        return rs;}

    @Override
    public List<ModelAttachFile> getAttachFile(int attachFileNo) {
        List<ModelAttachFile> rs = null;
        rs = session.selectList("mapper.mapperBoard.getAttachFile", attachFileNo);
        return rs;
    }

    @Override
    public List<ModelAttachFile> getAttachFileList(int articleno) {
        List<ModelAttachFile> rs = null;
        rs = session.selectList("mapper.mapperBoard.getAttachFileList", articleno);
        return rs;
    }

    @Override
    public int insertAttachFile(ModelAttachFile attachfile) {
        int rs = -1;
        rs = session.insert("mapper.mapperBoard.insertAttachFile", attachfile);
        return rs;
    }

    @Override
    public int deleteAttachFile(ModelAttachFile attachfile) {
        int rs = -1;
        rs = session.delete("mapper.mapperBoard.deleteAttachFile", attachfile);
        return rs;
    }

    @Override
    public List<ModelComments> getComment(int commentNo) {
        List<ModelComments> rs = null;
        rs = session.selectList("mapper.mapperBoard.getComment", commentNo);
        return rs;
    }

    @Override
    public List<ModelComments> getCommentList(int articleno) {
        List<ModelComments> rs = null;
        rs = session.selectList("mapper.mapperBoard.getCommentList", articleno);
        return rs;
    }

    @Override
    public int insertComment(ModelComments comments) {
        int rs = -1;
        rs = session.insert("mapper.mapperBoard.insertComment", comments);
        return rs;
    }

    @Override
    public int updateComment(ModelComments updateValue,
            ModelComments searchValue) {
        int rs = -1;
        Map<String, ModelComments> map = new HashMap<>();
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        rs = session.update("mapper.mapperBoard.updateComment", map);
        return rs;
    }

    @Override
    public int deleteComment(ModelComments comments) {
        int rs = -1;
        rs = session.delete("mapper.mapperBoard.deleteComment", comments);        
        return rs;
    }
    
    
}
