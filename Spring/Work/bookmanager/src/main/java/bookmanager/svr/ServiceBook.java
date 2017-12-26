package bookmanager.svr;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import bookmanager.inf.IBook;
import bookmanager.inf.IServiceBook;
import bookmanager.model.ModelBook;

@Service("servicebook")
public class ServiceBook implements IServiceBook {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("daobook")
    private IBook dao;
    
    @Override
    public List<ModelBook> selectAll() throws SQLException {
        List<ModelBook> rs = null;
        try {
            rs = dao.selectAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectAll" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBook> selectLike(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        try {
            rs = dao.selectLike(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectLike" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        try {
            rs = dao.selectEqual(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectEqual" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        try {
            rs = dao.selectDynamic(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectDynamic" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = -1;
        try {
            rs = dao.insertBook(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBook" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        int rs = -1;
        try {
            rs = dao.updateBook(wherebook, setbook);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBook" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        try {
            rs = dao.deleteBook(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBook" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
}
