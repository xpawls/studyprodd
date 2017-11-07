package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

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
    public void testSelectLike() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectEqual() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testSelectDynamic() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateBook() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteBook() {
        fail("Not yet implemented");
    }
    
}
