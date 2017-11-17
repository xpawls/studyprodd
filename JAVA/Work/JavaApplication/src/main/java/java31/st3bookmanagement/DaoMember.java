package java31.st3bookmanagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoMember implements IMember {
    private Connection conn = null;
    
    
    
    public DaoMember(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectLike(MemberD member) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectEqual(MemberD member) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectDynamic(MemberD member) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertMember(MemberD member) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateMember(MemberD wheremember, MemberD setmemeber)
            throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteMember(MemberD member) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
