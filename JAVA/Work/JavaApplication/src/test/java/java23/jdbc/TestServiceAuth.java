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
        ModelAuth auth = null;
        int rs = svr.getCount(auth );
        
        // 검증.
        // 인스턴스 검증
        // 값 검증
        assertEquals(3, rs);
    }
    
    @Test
    public void testGetMaxAuthid() throws SQLException  {
        
        int rs = svr.getMaxAuthid();
        assertEquals(7, rs);
    }
    
    @Test
    public void testSelectAll()  throws SQLException {
        ResultSet rs = svr.selectAll();
        assertNotNull(rs);
        
        // 값으로 검증
        // 1. 갯수로 검증.
        ModelAuth auth =null;
        int count = svr.getCount(auth);
        
        // Resultset의 갯수 가져오기/
        rs.last(); // 마지막 row로 커서를 이동하시오.
        int countset = rs.getRow(); // 현재 커서의 index 값을 가져오기.
        
        assertEquals(count, countset);
        
        // 2. row 값으로 검증.
        rs.first(); // 커서를 첫번째 row로 이동
        int authid = rs.getInt("authid"); // == 1
        assertEquals(1, authid);
        
    }
    
    @Test
    public void testSelectLike()  throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("bo");
        ResultSet rs = svr.selectLike(auth);
        rs.next();
        String aa = rs.getString("name");
        assertEquals("bob", aa);
    }
    
    @Test
    public void testSelectEqual() throws SQLException  {
        ModelAuth auth = new ModelAuth();
        auth.setName("park");
        ResultSet rs = svr.selectEqual(auth);
        rs.next();
        String aa = rs.getString("name");
        assertEquals("park", aa);
        
        
    }
    
    @Test
    public void testSelectDynamic() throws SQLException  {
        ModelAuth auth = new ModelAuth();
        auth.setBirth("1980.05.01");
        ResultSet rs = svr.selectDynamic(auth);
        rs.next();
        String gn = rs.getString("name");
        assertEquals("kim", gn);
        ModelAuth auth2 = new ModelAuth();
        auth2.setAuthid(1);
        auth2.setBirth("1970.05.01");
        rs = svr.selectDynamic(auth2);
        rs.next();
        gn = rs.getString("name");
        assertEquals("bob", gn);
        
    }
    
    @Test
    public void testInsertAuth() throws SQLException  {
        ModelAuth auth = new ModelAuth();
        auth.setAuthid(13);
        auth.setBirth("1922-10-23");
        auth.setName("harry");
        int result = svr.insertAuth(auth);
        
        assertNotEquals(-1, result);
    }
    
    @Test
    public void testUpdateAuth()  throws SQLException {
        ModelAuth whereauth = new ModelAuth();
        ModelAuth setauth = new ModelAuth();
        setauth.setAuthid(13);
        setauth.setBirth("1888-11-23");
        whereauth.setName("harry");
        int result = svr.updateAuth(whereauth, setauth);
        assertNotEquals(-1, result);
    }
    
    @Test
    public void testDeleteAuth()  throws SQLException {
        ModelAuth auth = new ModelAuth();
        auth.setName("harry");
        int result = svr.deleteAuth(auth);
        assertNotEquals(-1, result);
    }
    
    @Test
    public void testTransCommit()  throws SQLException {
    }
    
    @Test
    public void testTransRollback()  throws SQLException {
    }
    
}
