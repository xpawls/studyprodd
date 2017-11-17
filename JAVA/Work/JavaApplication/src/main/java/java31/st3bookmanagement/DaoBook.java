package java31.st3bookmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoBook implements IBook {
    private Connection conn = null;
    
    
    public DaoBook(Connection conn) {
        super();
        this.conn = conn;
    }

    @Override
    public ResultSet selectAll() throws SQLException {
        ResultSet rs = null;
        String query = " select * from bookd ";
        
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
        return rs;
    }
    
    @Override
    public ResultSet selectLike(BookD book) throws SQLException {
        ResultSet rs = null;
        String query = " select * from bookd where ";
        
        return rs;
    }
    
    @Override
    public ResultSet selectEqual(BookD book) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public ResultSet selectDynamic(BookD book) throws SQLException {
        ResultSet rs = null;
        try {
                                              String query = " select * from bookd ";
                                                     query+= " where 1=1    ";
            if( book.getNo()!=null)            query+= " and no=? ";
            if(!book.getBookname().isEmpty())  query+= " and bookname like ? ";
            if(!book.getAuthor().isEmpty())    query+= " and author like ? ";
            if(!book.getCategory().isEmpty())  query+= " and Category = ? ";
            if(!book.getPublisher().isEmpty()) query+= " and Publisher like ? ";
            if( book.getPrice()!=null)         query+= " and Price = ? ";
            
            PreparedStatement stmt = conn.prepareStatement(query);
            
            int c = 1;
            if( book.getNo()!=null)            stmt.setInt(c++, book.getNo());
            if(!book.getBookname().isEmpty())  stmt.setString(c++, book.getBookname());
            if(!book.getAuthor().isEmpty())    stmt.setString(c++, book.getAuthor());
            if(!book.getCategory().isEmpty())  stmt.setString(c++, book.getCategory());
            if(!book.getPublisher().isEmpty()) stmt.setString(c++, book.getPublisher());
            if( book.getPrice()!=null)         stmt.setInt(c++, book.getPrice());
            
            rs = stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return rs;
    }
    
    @Override
    public int insertMember(BookD book) throws SQLException {
        int rs = -1;
        String query = "insert into bookd (bookname, author, Category, Publisher, Price)";
               query+= "           values ( ?, ?, ?, ?, ?)";
               
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, book.getBookname());
            stmt.setString(2, book.getAuthor());
            stmt.setString(3, book.getCategory());
            stmt.setString(4, book.getPublisher());
            stmt.setInt   (5, book.getPrice());
            
            rs = stmt.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        
                
        return rs;
    }
    
    @Override
    public int updateMember(BookD wherebook, BookD setbook)
            throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
    @Override
    public int deleteMember(BookD book) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }
    
}
