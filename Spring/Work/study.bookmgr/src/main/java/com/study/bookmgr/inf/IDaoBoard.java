package com.study.bookmgr.inf;

import java.util.List;

import com.study.bookmgr.model.ModelBoard;

public interface IDaoBoard {
    List<ModelBoard> selectAll();
    int getBoardTotalRecord(String searchWord);
    void increaseBoardHit(int bno);
    int insertBoard(ModelBoard Board);
    int deleteBoard(int bno);
    int updateBoard(ModelBoard searchValue, ModelBoard updateValue);
    List<ModelBoard> getBoardList(String searchWord, int start, int end);
    ModelBoard getBoard(int bno);
    ModelBoard getNextBoard(int bno, String searchWord);
    ModelBoard getPrevBoard(int bno, String searchWord);
    
}
