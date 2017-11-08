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
        
        java.sql.ResultSet rs = null;
        
        try {
            // SQL문장 생성
            String query = "select * from book where bookname like ? ";
            // 문장객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, "%"+ book.getBookname() +"%");
            // query 문자열의 첫번째 ? 에 "%"+bookname+"%"
            // 문장객체 실행
            rs = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(ModelBook book) throws SQLException {
        
        java.sql.ResultSet rs = null;
        
        try {
            // SQL문장 생성
            String query = "select * from book where bookname = ? ";
            // 문장객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1,  book.getBookname() );
            // query 문자열의 첫번째 ? 에 bookname
            // 문장객체 실행
            rs = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
        
    }
    
    @Override
    public ResultSet selectDynamic(ModelBook book) throws SQLException {
        java.sql.ResultSet result = null;
        
        try {
            // query 작성
                                            String query  = " select * from book  \n";
                                                   query += " where 1 = 1         \n";
            if( book.getBookid() != null        )  query += "   and bookid    = ? \n";
            if(!book.getBookname().isEmpty()    )  query += "   and bookname  = ? \n";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if( book.getBookid() != null    ) stmt.setInt   (c++, book.getBookid());
            if(!book.getBookname().isEmpty()) stmt.setString(c++, book.getBookname());
            
            // 문장 객체 실행
            result = stmt.executeQuery();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return result;
    }
    
    @Override
    public int insertBook(ModelBook book) throws java.sql.SQLException {
        int rs = 0;
        
        try {
            String query = "INSERT INTO ";
            query += "BOOK(BOOKNAME, PUBLISHER, YEAR, PRICE, DTM, USE_YN, AUTHID) ";
            query += "VALUES(?,?,?,?,?,?,?)";
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString (1, book.getBookname());
            stmt.setString (2, book.getPublisher());
            stmt.setString (3, book.getYear());
            stmt.setInt    (4, book.getPrice());
            stmt.setDate   (5, (java.sql.Date) book.getDtm());
            stmt.setBoolean(6, book.getUse_yn());
            stmt.setInt    (7, book.getAuthid());
            
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        
        int rs = 0;
        
        try {
            // SQL 문장 생성
            String query = "UPDATE book                        \n";
            query       += "   SET year     = ? , price = ?    \n";
            query       += " WHERE bookname = ?                \n";
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, setbook.getYear());
            stmt.setInt   (2, setbook.getPrice());
            stmt.setString(3, wherebook.getBookname());
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        
        try {
            // SQL 문장 생성
            String query = "delete from book where bookname = ? ";
            
            // 문장 객체 생성
            java.sql.PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            
            // 문장 객체 실행
            rs = stmt.executeUpdate();
        } catch (java.sql.SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return rs;
    }
    
}
