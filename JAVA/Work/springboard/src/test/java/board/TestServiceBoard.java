package board;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.inf.IServiceBoard;
import board.model.ModelArticle;
import board.model.ModelAttachFile;
import board.model.ModelBoard;
import board.model.ModelComments;
import board.service.ServiceBoard;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceboard", ServiceBoard.class);
        
        javax.sql.DataSource dataSource = (DataSource)context.getBean("dataSource");
        org.apache.ibatis.jdbc.ScriptRunner runner = new
        org.apache.ibatis.jdbc.ScriptRunner( dataSource.getConnection() );
        runner.setAutoCommit(true);
        runner.setStopOnError(true);
        
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        String sf = cl.getResource("ddl/board.ddl.mysql.sql").getFile();
        
        java.io.Reader br = new java.io.BufferedReader( new java.io.FileReader(sf) );
        runner.runScript( br);
        runner.closeConnection();
    }
    
    @Test
    public void test01_GetBoardName() {
        String rs = null;
        rs = service.getBoardName("data");
        assertEquals("자료실", rs);
        
    }
    
    @Test
    public void test02_GetBoardOne() {
        List<ModelBoard> rs = null;
        rs = service.getBoardOne("free");
        assertEquals("자유게시판", rs.get(0).getBoardnm());
    }
    
    @Test
    public void test03_GetBoardList() {
        List<ModelBoard> rs = null;
        rs = service.getBoardList();
        assertEquals(3, rs.size());
    }
    
    @Test
    public void test04_InsertBoard() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("abc");
        board.setBoardnm("qqi");
        int rs = -1;
        rs = service.insertBoard(board);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test05_UpdateBoard() {
        ModelBoard searchValue = new ModelBoard();
        searchValue.setBoardcd("abc");
        
        ModelBoard updateValue = new ModelBoard();
        updateValue.setBoardnm("kyle");
        updateValue.setUseYN(false);
        updateValue.setUpdateUID("bbs");
        int rs = -1;
        rs = service.updateBoard(searchValue, updateValue);
        assertNotEquals(-1, rs);
        searchValue = new ModelBoard();
        searchValue.setBoardnm("kyle");
        
        updateValue = new ModelBoard();
        updateValue.setBoardnm("kak");
        updateValue.setUseYN(false);
        updateValue.setUpdateUID("bbs");
        rs = -1;
        rs = service.updateBoard(searchValue, updateValue);
        assertNotEquals(-1, rs);
        
        
    }
    
    @Test
    public void test06_DeleteBoard() {
        ModelBoard board = new ModelBoard();
        board.setBoardnm("kak");
        int rs = -1;
        rs = service.deleteBoard(board);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test07_GetBoardSearch() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("a");
        List<ModelBoard> rs = null;
        rs = service.getBoardSearch(board);
        assertEquals(2, rs.size());
        
        board = new ModelBoard();
        board.setBoardnm("자");
        rs = null;
        rs = service.getBoardSearch(board);
        assertEquals(2, rs.size());
        
        
    }
    
    @Test
    public void test08_GetBoardTotalRecord() {// 확인요망 boardnm값이 들어가지 않음
        int rs = -1;
        rs = service.getBoardTotalRecord("data", "%자료%");
        assertEquals(1, rs);
        
    }
    
    @Test
    public void test09_GetBoardPaging() {// 확인요망 boardnm값이 들어가지 않음
        List<ModelBoard> rs = null;
        rs = service.getBoardPaging("data", "자료실", 0, 1);
        assertEquals(1, rs.size());
    }
    
    @Test
    public void test10_InsertBoardList() {
        int rs = -1;
        List<ModelBoard> lis = new ArrayList<>();
        ModelBoard bo = new ModelBoard();
        bo.setBoardcd("nana");
        bo.setBoardnm("baba");
        bo.setUseYN(false);
        lis.add(bo);
        bo = new ModelBoard();
        bo.setBoardcd("ddd");
        bo.setBoardnm("baaaasdba");
        bo.setUseYN(false);
        lis.add(bo);
        bo = new ModelBoard();
        bo.setBoardcd("nafana");
        bo.setBoardnm("bqwaba");
        bo.setUseYN(false);
        lis.add(bo);
        rs = service.insertBoardList(lis);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test11_GetArticleTotalRecord() {
        int rs = -1;
        rs = service.getArticleTotalRecord("free", "test");
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test12_GetArticleList() {
        List<ModelArticle> rs = null;
        rs = service.getArticleList("free", "", 0, 1);
        assertNotEquals(0, rs.size());
    }
    
    @Test
    public void test13_GetArticle() {
        List<ModelArticle> rs = null;
        rs = service.getArticle(1);
        assertEquals("article test  01", rs.get(0).getTitle());
    }
    
    @Test
    public void test14_InsertArticle() {
        ModelArticle article = new ModelArticle();
        int rs = -1;
        article.setBoardcd("data");
        article.setTitle("tiled");
        rs = service.insertArticle(article);
        article = new ModelArticle();
        rs = -1;
        article.setBoardcd("data");
        article.setTitle("tile");
        rs = service.insertArticle(article);
        article = new ModelArticle();
        rs = -1;
        article.setBoardcd("data");
        article.setTitle("tled");
        rs = service.insertArticle(article);
        article = new ModelArticle();
        rs = -1;
        article.setBoardcd("data");
        article.setTitle("tild");
        rs = service.insertArticle(article);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test15_UpdateArticle() {
        ModelArticle searchValue = new ModelArticle();
        searchValue.setBoardcd("data");
        ModelArticle updateValue = new ModelArticle();
        updateValue.setUseYN(false);
        int rs = -1;
        rs = service.updateArticle(updateValue, searchValue);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test16_DeleteArticle() {
        ModelArticle article = new ModelArticle();
        article.setBoardcd("data");
        int rs = -1;
        rs = service.deleteArticle(article);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test17_IncreaseHit() {
        int rs = -1;
        rs = service.increaseHit(201);
        assertNotEquals(-1, rs);
        
    }
    
    @Test
    public void test18_GetNextArticle() {
        List<ModelArticle> rs = null;
        rs = service.getNextArticle("free", 100, "test");
        assertTrue(rs.size()>0);
        assertEquals(101, (int)rs.get(0).getArticleno());
    }
    
    @Test
    public void test19_GetPrevArticle() {
        List<ModelArticle> rs = null;
        rs = service.getPrevArticle("free", 100, "test");
        assertTrue(rs.size()>0);
        assertEquals(99, (int)rs.get(0).getArticleno());
    }
    
    @Test
    public void test20_GetAttachFile() {
        List<ModelAttachFile> rs = null;
        rs = service.getAttachFile(3);
        assertEquals("어태치파일", rs.get(0).getFilename());
    }
    
    @Test
    public void test21_GetAttachFileList() {
        List<ModelAttachFile> rs = null;
        rs = service.getAttachFileList(1);
        assertEquals(7, rs.size());
    }
    
    @Test
    public void test22_InsertAttachFile() {
        ModelAttachFile attachfile = new ModelAttachFile();
        attachfile.setFilename("aaa");
        attachfile.setArticleno(33);
        int rs = -1;
        rs = service.insertAttachFile(attachfile);
        assertNotEquals(-1, rs);
        attachfile = new ModelAttachFile();
        attachfile.setFilename("bbb");
        attachfile.setArticleno(64);
        rs = -1;
        rs = service.insertAttachFile(attachfile);
        assertNotEquals(-1, rs);
        attachfile = new ModelAttachFile();
        attachfile.setFilename("ccc");
        attachfile.setArticleno(54);
        attachfile.setUseYN(false);
        rs = -1;
        rs = service.insertAttachFile(attachfile);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void test23_DeleteAttachFile() {
        ModelAttachFile attachfile = new ModelAttachFile();
        attachfile.setFilename("aaa");
        int rs = -1;
        rs = service.deleteAttachFile(attachfile);
        assertNotEquals(-1, rs);
        attachfile = new ModelAttachFile();
        attachfile.setAttachfileno(9);
        rs = -1;
        rs = service.deleteAttachFile(attachfile);
        assertNotEquals(-1, rs);
        attachfile = new ModelAttachFile();
        attachfile.setUseYN(false);
        rs = -1;
        rs = service.deleteAttachFile(attachfile);
        assertNotEquals(-1, rs);
        
    }
    
    @Test
    public void test24_GetComment() {
        List<ModelComments> rs = null;
        rs = service.getComment(1);
        assertEquals(1, rs.size());
        assertEquals("aa@aa.co.kr", rs.get(0).getEmail());
    }
    
    @Test
    public void test25_GetCommentList() {
        List<ModelComments> rs = null;
        rs = service.getCommentList(1);
        assertEquals(1, rs.size());
        assertEquals("aa@aa.co.kr", rs.get(0).getEmail());
    }
    
    @Test
    public void test26_InsertComment() {
        int rs = -1;
        ModelComments comments = new ModelComments();
        comments.setEmail("aaaaa");
        comments.setArticleno(25);
        rs = service.insertComment(comments);
        assertNotEquals(-1, rs);
        rs = -1;
        comments = new ModelComments();
        comments.setEmail("bbbb");
        comments.setArticleno(50);
        rs = service.insertComment(comments);
        assertNotEquals(-1, rs);
        rs = -1;
        comments = new ModelComments();
        comments.setEmail("cccc");
        comments.setUseYN(false);
        comments.setArticleno(7);
        rs = service.insertComment(comments);
        assertNotEquals(-1, rs);
        comments = new ModelComments();
        comments.setEmail("dddd");
        comments.setUseYN(false);
        comments.setArticleno(6);
        rs = service.insertComment(comments);
        assertNotEquals(-1, rs);
        
        
    }
    
    @Test
    public void test27_UpdateComment() {
        ModelComments searchValue = new ModelComments();
        searchValue.setCommentno(2);
        ModelComments updateValue = new ModelComments();
        updateValue.setMemo("memomo");        
        int rs = -1;
        rs = service.updateComment(updateValue, searchValue);
        assertNotEquals(-1, rs);
        
        searchValue = new ModelComments();
        searchValue.setArticleno(50);
        updateValue = new ModelComments();
        updateValue.setMemo("artimeno");        
        rs = -1;
        rs = service.updateComment(updateValue, searchValue);
        assertNotEquals(-1, rs);
        
        searchValue = new ModelComments();
        searchValue.setEmail("cccc");
        updateValue = new ModelComments();
        updateValue.setUseYN(false);
        
        rs = -1;
        rs = service.updateComment(updateValue, searchValue);
        assertNotEquals(-1, rs);
        
    }
    
    @Test
    public void test28_DeleteComment() {
        ModelComments comments = new ModelComments();
        int rs = -1;
        comments.setCommentno(2);
        rs = service.deleteComment(comments);
        assertNotEquals(-1, rs);
        comments = new ModelComments();
        rs = -1;
        comments.setArticleno(50);
        rs = service.deleteComment(comments);
        assertNotEquals(-1, rs);
        comments = new ModelComments();
        rs = -1;
        comments.setEmail("dddd");
        rs = service.deleteComment(comments);
        assertNotEquals(-1, rs);
        comments = new ModelComments();
        rs = -1;
        comments.setUseYN(false);
        rs = service.deleteComment(comments);
        assertNotEquals(-1, rs);
        
        
    }
}
