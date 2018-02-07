package com.study.bookmgr.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.study.bookmgr.inf.IDaoBoard;
import com.study.bookmgr.model.ModelBoard;


@Repository
public class DaoBoard implements IDaoBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    SqlSession session;
    
    @Override
    public List<ModelBoard> selectAll() {
        return session.selectList("mapper.mapperBoard.selectAll");
    }

    @Override
    public int getBoardTotalRecord(String searchWord) {
        return session.selectOne("mapper.mapperBoard.getBoardTotalRecord", searchWord);
    }

    @Override
    public void increaseBoardHit(int bno) {
        session.update("mapper.mapperBoard.increaseBoardHit", bno);
        
    }

    @Override
    public int insertBoard(ModelBoard Board) {
        return session.insert("mapper.mapperBoard.insertBoard", Board);
    }

    @Override
    public int updateBoard(ModelBoard searchValue, ModelBoard updateValue) {
        Map<String, ModelBoard> map = new HashMap<>();
        
        map.put("updateValue", updateValue);
        map.put("searchValue", searchValue);
        return session.update("mapper.mapperBoard.updateBoard", map);
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord, int start,
            int end) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchWord", searchWord);
        map.put("start", start);
        map.put("end", end);
        return session.selectList("mapper.mapperBoard.getBoardList", map);
    }

    @Override
    public ModelBoard getBoard(int bno) {
        return session.selectOne("mapper.mapperBoard.getBoard", bno);
    }

    @Override
    public ModelBoard getNextBoard(int bno, String searchWord) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchWord", searchWord);
        map.put("bno", bno);
        return session.selectOne("mapper.mapperBoard.getNextBoard", map);
    }

    @Override
    public ModelBoard getPrevBoard(int bno, String searchWord) {
        Map<String, Object> map = new HashMap<>();
        map.put("searchWord", searchWord);
        map.put("bno", bno);
        return session.selectOne("mapper.mapperBoard.getPrevBoard", map);
    }

    @Override
    public int deleteBoard(int bno) {
        return session.update("mapper.mapperBoard.deleteBoard", bno);
    }
}
