package java23.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoAuth implements IAuth {
    private java.sql.Connection conn = null;
    
    
    
    public DaoAuth(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public int getCount(ModelAuth auth) throws SQLException {
        int result = -1;
        // sql문장
        String query = "SELECT count(*) as total from auth where 1=1";
        
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
    public int getMaxAuthid() throws SQLException {
        int result = -1;
        
        String query = "select max(authid) maxid from auth";
        
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
        
        String query = " select * from auth order by authid asc";
        
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
    public ResultSet selectLike(ModelAuth auth) throws SQLException {
        
        java.sql.ResultSet rs = null;
        
        try {
            // SQL문장 생성
            String query = "select * from auth where name like ? ";
            // 문장객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+ auth.getName() +"%");
            // query 문자열의 첫번째 ? 에 "%"+ auth.getName() +"%"
            // 문장객체 실행
            rs = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelAuth auth) throws SQLException {
        
        java.sql.ResultSet rs = null;
        
        try {
            // SQL문장 생성
            String query = "select * from auth where Name = ? ";
            // 문장객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,  auth.getName() );
            // query 문자열의 첫번째 ? 에 Name
            // 문장객체 실행
            rs = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
        
    }
    
    @Override
    public ResultSet selectDynamic(ModelAuth auth) throws SQLException {
        java.sql.ResultSet result = null;
        
        try {
            // query 작성
                                            String query  = " select * from auth  \n";
                                                   query += " where 1 = 1         \n";
            if( auth.getAuthid() != null        )  query += "   and authid    = ? \n";
            if(!auth.getName().isEmpty()    )  query += "   and Name  = ? \n";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if( auth.getAuthid() != null    ) stmt.setInt   (c++, auth.getAuthid());
            if(!auth.getName().isEmpty()) stmt.setString(c++, auth.getName());
            
            // 문장 객체 실행
            result = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return result;
    }
    
    @Override
    public int insertAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            String query = "INSERT INTO ";
            query += "auth(authid, name, birth) ";
            query += "VALUES(?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt (1, auth.getAuthid());
            stmt.setString (2, auth.getName());
            stmt.setString (3, auth.getBirth());
            
            
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int updateAuth(ModelAuth whereauth, ModelAuth setauth)
            throws SQLException {
        
        int rs = -1;
        
        try {
            // SQL 문장 생성
            String query = "UPDATE auth                        \n";
            query       += "   SET birth     = ? , authid = ?    \n";
            query       += " WHERE Name = ?                \n";
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setauth.getBirth());
            stmt.setInt   (2, setauth.getAuthid());
            stmt.setString(3, whereauth.getName());
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int deleteAuth(ModelAuth auth) throws SQLException {
        int rs = -1;
        
        try {
            // SQL 문장 생성
            String query = "delete from auth where Name = ? ";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, auth.getName());
            
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
