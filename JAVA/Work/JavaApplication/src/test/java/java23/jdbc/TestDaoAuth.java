package java23.jdbc;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.jws.WebParam.Mode;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestDaoAuth {
    static Connection conn = null;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        conn = DBConnect.makeConnection();
    }
    
    @Test
    public void testGetCount() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth model = new ModelAuth();
        int result = dao.getCount(model);
        assertEquals(3, result);
    }
    
    @Test
    public void testGetMaxAuthid() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        
        int result = dao.getMaxAuthid();
        assertEquals(7, result);
    }
    
    @Test
    public void testSelectAll() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ResultSet result = dao.selectAll();
        result.next();
        int ai = result.getInt("authid");
        assertEquals(1, ai);
    }
    
    @Test
    public void testSelectLike() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        auth.setName("bo");
        ResultSet result = dao.selectLike(auth);
        
        assertNotNull(result);
    }
    
    @Test
    public void testSelectEqual() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        auth.setName("bob");
        ResultSet result = dao.selectEqual(auth);
        
        assertNotNull(result);
        
    }
    
    @Test
    public void testSelectDynamic() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(1);
        ResultSet result = dao.selectDynamic(auth);
        result.next();
        String name = result.getString("name");
        assertEquals("bob", name);
    }
    
    @Test
    public void testInsertAuth() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(12);
        auth.setName("panic1");
        auth.setBirth("2000-01-01");
        int result = dao.insertAuth(auth);
        assertNotEquals(-1, result);
    }
    
    @Test
    public void testUpdateAuth() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth whereauth = new ModelAuth();
        whereauth.setName("panic1");
        ModelAuth setauth = new ModelAuth();
        setauth.setAuthid(15);
        setauth.setBirth("2014-03-04");
        int result = dao.updateAuth(whereauth, setauth);
        assertNotEquals(-1, result);
        
        
    }
    
    @Test
    public void testDeleteAuth() throws SQLException {
        DaoAuth dao = new DaoAuth(conn);
        ModelAuth auth = new ModelAuth();
        
        auth.setName("panic1");
        int result = dao.deleteAuth(auth);
        assertNotEquals(-1, result);
    }
    
}
