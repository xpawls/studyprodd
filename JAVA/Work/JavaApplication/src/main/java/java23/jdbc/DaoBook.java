package java23.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.PreparedStatement;

public class DaoBook implements IBook {
    private java.sql.Connection conn = null;
    
    public DaoBook(Connection conn) {
        super();
        this.conn = conn;
    }
    
    @Override
    public int getCount(ModelBook book) throws SQLException {
        int result = -1;
        // sql문장
        String query = "SELECT count(*) as total from book where 1=1";
        
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            java.sql.ResultSet rs = stmt.executeQuery();
            
            rs.next(); // 커서 이동. ResultSet 첫번째로 로우로.
            result = rs.getInt("total"); //total 컬럼의 값을 가져온다.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    @Override
    public int getMaxBookid() throws SQLException {
        int result = -1;
        
        String query = "select max(bookid) maxid from book";
        
        try {
            // 문장 객체 생성
            PreparedStatement stmt = conn.prepareStatement(query);
            // SQL 문장 실행
            ResultSet rs = stmt.executeQuery();
            
            rs.next(); // 커서 이동. ResultSet 첫번째로 로우로.
            result = rs.getInt("maxid");//maxid 컬럼의 값을 가져온다.
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
        return result;
    }
    
    @Override
    public ResultSet selectAll() throws SQLException {
        java.sql.ResultSet rs = null;
        
        String query = "select * from book order by bookid asc";
        
        try {
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            rs = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
