package bookmanager.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import bookmanager.inf.IBook;
import bookmanager.model.ModelBook;

@Repository("daobook")
public class DaoBook implements IBook {
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;

    @Override
    public List<ModelBook> selectAll() throws SQLException {
        List<ModelBook> rs = null;
        rs = session.selectList("mapper.mapperBook.selectAll");
        return rs;
    }

    @Override
    public List<ModelBook> selectLike(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        rs = session.selectList("mapper.mapperBook.selectLike", book);
        return rs;
    }

    @Override
    public List<ModelBook> selectEqual(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        rs = session.selectList("mapper.mapperBook.selectEqual", book);
        return rs;
    }

    @Override
    public List<ModelBook> selectDynamic(ModelBook book) throws SQLException {
        List<ModelBook> rs = null;
        rs = session.selectList("mapper.mapperBook.selectDynamic", book);
        return rs;
    }

    @Override
    public int insertBook(ModelBook book) throws SQLException {
        int rs = -1;
        rs = session.insert("mapper.mapperBook.insertBook", book);
        return rs;
    }

    @Override
    public int updateBook(ModelBook wherebook, ModelBook setbook)
            throws SQLException {
        int rs = -1;
        Map<String, ModelBook> map = new HashMap<>();
        map.put("where", wherebook);
        map.put("set", setbook);
        rs = session.update("mapper.mapperBook.updateBook", map);
        return rs;
    }

    @Override
    public int deleteBook(ModelBook book) throws SQLException {
        int rs = -1;
        rs = session.delete("mapper.mapperBook.deleteBook", book);
        return rs;
    }
   

    
    
}
