package com.study.bookmgr.inf;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.study.bookmgr.model.ModelBook;
import com.study.bookmgr.model.ModelBorrow;

public interface IBorrow {
    List<ModelBorrow> selectAll() throws SQLException;
    List<ModelBorrow> selectMemID(String memid) throws SQLException;
    ModelBorrow selectBrrno(int brno) throws SQLException;
    
    int insertBorrow(ModelBorrow borrow) throws SQLException;
    
    int deleteBorrow(ModelBorrow borrow) throws SQLException;
    
    int brrbookY(int no) throws SQLException;
    
    int brrbookN(int no) throws SQLException;
}
