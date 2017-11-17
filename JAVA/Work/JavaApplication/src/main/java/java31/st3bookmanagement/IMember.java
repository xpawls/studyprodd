package java31.st3bookmanagement;

import java.sql.ResultSet;
import java.sql.SQLException;


public interface IMember {
    ResultSet selectAll() throws SQLException;
    
    ResultSet selectLike(MemberD member) throws SQLException; 
    
    ResultSet selectEqual(MemberD member) throws SQLException; 
    
    ResultSet selectDynamic(MemberD member) throws SQLException;
    
    int insertMember(MemberD member) throws SQLException;
    
    int updateMember(MemberD wheremember, MemberD setmemeber) throws SQLException;
    
    int deleteMember(MemberD member) throws SQLException;
}
