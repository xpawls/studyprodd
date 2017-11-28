package board;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import board.inf.IServiceBoard;
import board.model.ModelArticle;
import board.model.ModelBoard;
import board.service.ServiceBoard;

public class TestServiceBoard {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private static IServiceBoard service = null;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:ApplicationContext.xml");
        
        service = context.getBean("serviceboard", ServiceBoard.class);
    }
    
    @Test
    public void testGetBoardName() {
        String rs = null;
        rs = service.getBoardName("data");
        assertEquals("자료실", rs);
        
    }
    
    @Test
    public void testGetBoardOne() {
        List<ModelBoard> rs = null;
        rs = service.getBoardOne("free");
        assertEquals("자유게시판", rs.get(0).getBoardnm());
    }
    
    @Test
    public void testGetBoardList() {
        List<ModelBoard> rs = null;
        rs = service.getBoardList();
        assertEquals(3, rs.size());
    }
    
    @Test
    public void testInsertBoard() {
        ModelBoard board = new ModelBoard();
        board.setBoardcd("abc");
        board.setBoardnm("qqi");
        int rs = -1;
        rs = service.insertBoard(board);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testUpdateBoard() {
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
    public void testDeleteBoard() {
        ModelBoard board = new ModelBoard();
        board.setBoardnm("kyle");
        int rs = -1;
        rs = service.deleteBoard(board);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testGetBoardSearch() {
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
    public void testGetBoardTotalRecord() {// 확인요망 boardnm값이 들어가지 않음
        int rs = -1;
        rs = service.getBoardTotalRecord("data", "%자료%");
        assertEquals(1, rs);
        
    }
    
    @Test
    public void testGetBoardPaging() {// 확인요망 boardnm값이 들어가지 않음
        List<ModelBoard> rs = null;
        rs = service.getBoardPaging("data", "자료실", 0, 1);
        assertEquals(1, rs.size());
    }
    
    @Test
    public void testInsertBoardList() {
        int rs = -1;
        List<ModelBoard> lis = new ArrayList<>();
        ModelBoard bo = new ModelBoard();
        bo.setBoardcd("nana");
        bo.setBoardnm("baba");
        bo.setUseYN(false);
        lis.add(bo);
        rs = service.insertBoardList(lis);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testGetArticleTotalRecord() {
        int rs = -1;
        rs = service.getArticleTotalRecord("free", "test");
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testGetArticleList() {
        List<ModelArticle> rs = null;
        rs = service.getArticleList("free", "", 0, 1);
        assertNotEquals(0, rs.size());
    }
    
    @Test
    public void testGetArticle() {
        List<ModelArticle> rs = null;
        rs = service.getArticle(1);
        assertEquals("article test  01", rs.get(0).getTitle());
    }
    
    @Test
    public void testInsertArticle() {
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
    public void testUpdateArticle() {
        ModelArticle searchValue = new ModelArticle();
        searchValue.setBoardcd("data");
        ModelArticle updateValue = new ModelArticle();
        updateValue.setUseYN(false);
        int rs = -1;
        rs = service.updateArticle(updateValue, searchValue);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testDeleteArticle() {
        ModelArticle article = new ModelArticle();
        article.setBoardcd("data");
        int rs = -1;
        rs = service.deleteArticle(article);
        assertNotEquals(-1, rs);
    }
    
    @Test
    public void testIncreaseHit() {
        int rs = -1;
        rs = service.increaseHit(201);
        assertNotEquals(-1, rs);
        
    }
    
    @Test
    public void testGetNextArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetPrevArticle() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetAttachFileList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteAttachFile() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testGetCommentList() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testInsertComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testUpdateComment() {
        fail("Not yet implemented");
    }
    
    @Test
    public void testDeleteComment() {
        fail("Not yet implemented");
    }
}
