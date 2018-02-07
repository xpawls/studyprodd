package com.study.bookmgr.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bookmgr.inf.IDaoBoard;
import com.study.bookmgr.inf.IServiceBoard;
import com.study.bookmgr.model.ModelBoard;


@Service
public class ServiceBoard implements IServiceBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    IDaoBoard dao;
    
    @Override
    public List<ModelBoard> selectAll() {
        List<ModelBoard> rs = null;
        
        try {
            rs = dao.selectAll();
        } catch (Exception e) {
            logger.error("selectAll" + e.getMessage());
            throw e;
            
        }
        
        return rs;
    }

    @Override
    public int getBoardTotalRecord(String searchWord) {
        int rs = -1;
        try {
            rs = dao.getBoardTotalRecord(searchWord);
        } catch (Exception e) {
            logger.error("getBoardTotalRecord" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public void increaseBoardHit(int bno) {
        try {
            dao.increaseBoardHit(bno);
        } catch (Exception e) {
            logger.error("increaseBoardHit" + e.getMessage());
            throw e;
            
        }
        
    }

    @Override
    public int insertBoard(ModelBoard Board) {
        int rs = -1;
        try {
            dao.insertBoard(Board);
        } catch (Exception e) {
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
            logger.error("updateBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public List<ModelBoard> getBoardList(String searchWord, int start,
            int end) {
        List<ModelBoard> rs = null;
        try {
            rs = dao.getBoardList(searchWord, start, end);
        } catch (Exception e) {
            logger.error("getBoardList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public ModelBoard getBoard(int bno) {
        ModelBoard rs = null;
        
        try {
            rs = dao.getBoard(bno);
        } catch (Exception e) {
            logger.error("getBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public ModelBoard getNextBoard(int bno, String searchWord) {
        ModelBoard rs = null;
        
        try {
            rs = dao.getNextBoard(bno, searchWord);
        } catch (Exception e) {
            logger.error("getNextBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public ModelBoard getPrevBoard(int bno, String searchWord) {
        ModelBoard rs = null;
        
        try {
            rs = dao.getPrevBoard(bno, searchWord);
        } catch (Exception e) {
            logger.error("getPrevBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }

    @Override
    public int deleteBoard(int bno) {
        int rs = -1;
        try {
            rs = dao.deleteBoard(bno);
        } catch (Exception e) {
            logger.error("deleteBoard" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
