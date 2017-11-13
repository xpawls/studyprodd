package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestServiceAuth {
    private static ServiceAuth svr = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        svr = new ServiceAuth();
        
    }
    
    @Test
    public void testGetCount() throws SQLException {
        ModelAuth auth = new ModelAuth();
        int result = svr.getCount(auth);
        assertEquals(3, result);
    }
    
    @Test
    public void testGetMaxAuthid() throws SQLException  {
        
        int result = svr.getMaxAuthid();
        assertEquals(7, result);
    }
    
    @Test
    public void testSelectAll()  throws SQLException {
        ResultSet result = svr.selectAll();
        result.next();
        int id = result.getInt("authid");
        assertEquals(1, id);
    }
    
    @Test
    public void testSelectLike()  throws SQLException {
        
        ModelAuth auth = new ModelAuth();
        auth.setName("ki");
        ResultSet result = svr.selectLike(auth);
        assertNotNull(result);
    }
    
    @Test
    public void testSelectEqual() throws SQLException  {
        ModelAuth auth = new ModelAuth();
        auth.setName("kim");
        ResultSet result = svr.selectEqual(auth);
        assertNotNull(result);
    }
    
    @Test
    public void testSelectDynamic() throws SQLException  {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertAuth() throws SQLException  {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateAuth()  throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteAuth()  throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransCommit()  throws SQLException {
        fail("Not yet implemented");
    }
    
    @Test
    public void testTransRollback()  throws SQLException {
        fail("Not yet implemented");
    }
    
}
