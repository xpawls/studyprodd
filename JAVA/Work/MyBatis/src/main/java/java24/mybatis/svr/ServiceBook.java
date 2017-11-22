package java24.mybatis.svr;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java24.mybatis.inf.IBook;
import java24.mybatis.inf.IServiceBook;
import java24.mybatis.model.ModelBook;

@Service("servicebook") // servicebook은 ServiceBook의 인스턴스명이 된다.
public class ServiceBook implements IServiceBook {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired //  daobook클래스의 인스턴스를 만들고 dao필드에 해당인스턴으를 넣는다.
    @Qualifier("daobook")
    private IBook dao;
    

    @Override
    public int getCount(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.getCount(book);
        } catch (Exception e) {
            // e.printStackTrace();
            logger.error("getCount" + e.getMessage());
            
        }
        return result;
    }

    @Override
    public int getMaxBookid() throws Exception {
        int result = -1;
        try {
            result = dao.getMaxBookid();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getMaxBookid" + e.getMessage());
            
        }
        return result;
    }

    @Override
    public List<ModelBook> selectAll() throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectAll();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectAll" + e.getMessage());
            
        }
        return result;
    }

    @Override
    public List<ModelBook> selectLike(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectLike(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectLike" + e.getMessage());
            throw e;
            
        }
        return result;
    }

    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectEqual(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectEqual" + e.getMessage());
            
        }
        return result;
    }

    @Override
    public int insertBook(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.insertBook(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertBook" + e.getMessage());
            throw e;
            
        }
        return result;

    }

    @Override
    public int insertMap(String bookname, Date dtm, int authid)
            throws Exception {
        int result = -1;
        try {
            result = dao.insertMap(bookname, dtm, authid);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertMap" + e.getMessage());
            throw e;
            
        }
        return result;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws Exception {
        int result = -1;
        try {
            result = dao.updateBook(wherebook, setbook);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("updateBook" + e.getMessage());
            throw e;
            
        }
        return result;
    }

    @Override
    public int deleteBook(ModelBook book) throws Exception {
        int result = -1;
        try {
            result = dao.deleteBook(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteBook" + e.getMessage());
            throw e;
            
        }
        return result;

    }

    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws Exception {
        List<ModelBook> result = null;
        try {
            result = dao.selectDynamic(book);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("selectDynamic" + e.getMessage());
            throw e;
            
        }
        return result;
    }
}
