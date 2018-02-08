package com.study.bookmgr.inf;

import java.util.List;

import com.study.bookmgr.model.ModelBoard;

public interface IDaoBoard {
    List<ModelBoard> selectAll();
    int getBoardTotalRecord(String searchWord, String boardcd);
    void increaseBoardHit(int bno);
    int insertBoard(ModelBoard Board);
    int deleteBoard(int bno);
    int updateBoard(ModelBoard searchValue, ModelBoard updateValue);
    List<ModelBoard> getBoardList(String searchWord, String boardcd, int start, int end);
    ModelBoard getBoard(int bno);
    ModelBoard getNextBoard(int bno,String boardcd, String searchWord);
    ModelBoard getPrevBoard(int bno,String boardcd, String searchWord);
    
}
