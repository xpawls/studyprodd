package java31.st3bookmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IBook {
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(BookD book) throws SQLException; 
    
    ResultSet selectEqual(BookD book) throws SQLException; 
    
    ResultSet selectDynamic(BookD book) throws SQLException;
    
    int insertMember(BookD book) throws SQLException;
    
    int updateMember(BookD wherebook, BookD setbook) throws SQLException;
    
    int deleteMember(BookD book) throws SQLException;
}
