package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoBook {
    static java.sql.Connection conn = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
    }
    
    @Test
    public void testGetCount() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook model = new ModelBook();
        int result = dao.getCount(model);
        assertEquals(4, result);
    }
    
    @Test
    public void testGetMaxBookid() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        
        int result = dao.getMaxBookid();
        assertEquals(4, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ResultSet result = dao.selectAll();
        result.next();
        Integer bi = result.getInt("bookid");
        String bn = result.getString("bookname");
        assertEquals("operating system", bn);
        assertSame(1, bi);
        result.next();
        bi = result.getInt("bookid");
        assertSame(2, bi);
        assertNotNull(result);
        
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        DaoBook dao = new DaoBook(conn);
        ModelBook book = new ModelBook();
        book.setBookname("ja");
        java.sql.ResultSet rs = dao.selectLike(book);
        
        // resultset을 이용한 검증
        assertNotNull(rs);
        // assertTrue(rs.getRow()>=1); // 커서가 가르키는 위치
        rs.getRow(); // ResultSet 에 들어있는 row의 총 수. 레코드 수
        
        // 값을 이용한 검증
        rs.next(); // 커서가 첫번째 row로 이동.
        String name = rs.getString("bookname"); // java
        assertTrue(name.contains("ja"));
        assertTrue(name.contains(book.getBookname()));
        
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        
        ModelBook book = new ModelBook();
        book.setBookname("mysql");
        
        DaoBook dao = new DaoBook(conn);
        java.sql.ResultSet rs = dao.selectEqual(book);
        
        // resultset을 이용한 검증
        assertNotNull(rs);
        
        // 값을 이용한 검증
        rs.next(); // 커서가 첫번째 row로 이동.
        String name = rs.getString("bookname"); // mysql
        assertTrue(name.contains("mysql"));
        assertTrue(name.contains(book.getBookname()));
        
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        ModelBook book = new ModelBook();
        DaoBook   dao  = new DaoBook(conn);
        
        // 첫번째 검증. select * from book where 1=1;
        //              select count(*) from book where 1=1;
        book.setBookid(null);
        book.setBookname("");
        java.sql.ResultSet rs = dao.selectDynamic(book);
        
        assertNotNull(rs); // 인스턴스 검증
        rs.last(); // 커서의 위치를 마지막 row로 이동.
        int rows = rs.getRow(); // 현재 커서의 index 번호를 가져온다.
        assertEquals(dao.getCount(book), rows);
        // resultset 사용법
        // rs.next(); 커서를 현재 row에서 다음 row로 이동.
        // rs.last(); 마지막 row로 이동.
        // rs.first(); 첫번째 row로 이동.
        // rs.getRow(); 현재 커서의 index 번호
        // rs.getInt("컬럼명"); 
        // rs.getStirng("컬럼명"); 
        // rs.getBoolean("컬럼명"); 
        // rs.getDate("컬럼명"); 
    }
    
    @Test
    public void testInsertBook() throws SQLException {
        java.util.Date date = new java.util.Date(117, 10, 8);
        java.sql.Date date2 = java.sql.Date.valueOf("2017-11-08");
        
        ModelBook book = new ModelBook();
        book.setBookname("test");
        book.setPublisher("abc");
        book.setYear("2017");
        book.setPrice(20000);
        book.setDtm(date2);
        book.setUse_yn(true);
        book.setAuthid(3);
        
        DaoBook dao = new DaoBook(conn);
        int result = dao.insertBook(book);
        
        // insert 검증 :
        // 1 리턴되는 경우 : insert 성공
        // 0 리턴되는 경우 : insert 실패
        assertEquals(1, result);
        
    }
    
    @Test
    public void testUpdateBook() throws SQLException {
        ModelBook wherebook = new ModelBook();
        wherebook.setBookname("test");
        
        ModelBook setbook = new ModelBook();
        setbook.setPrice(15000);
        setbook.setYear("2016");
        
        DaoBook dao = new DaoBook(conn);
        int result = dao.updateBook(wherebook, setbook);
        
        // 검증 코드
        // 1 이상의 값이 리턴되는 경우 : 성공
        // 0 값이 리턴되는 경우 : 성공
        assertTrue(result>=0);

    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        ModelBook book = new ModelBook();
        book.setBookname("test");
        
        DaoBook dao = new DaoBook(conn);
        int result = dao.deleteBook(book); // result == 1

        // 검증 코드
        // 1 이상의 값이 리턴되는 경우 : 성공
        // 0 값이 리턴되는 경우 : 성공
        assertTrue(result>=0);
        
        book.setBookname("test2");
        result = dao.deleteBook(book); // result == 0

        // 검증 코드
        // 1 이상의 값이 리턴되는 경우 : 성공
        // 0 값이 리턴되는 경우 : 성공
        assertTrue(result>=0);
        
    }
    
}
