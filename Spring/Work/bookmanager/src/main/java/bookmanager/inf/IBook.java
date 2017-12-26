package bookmanager.inf;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import bookmanager.model.ModelBook;

public interface IBook {
    List<ModelBook> selectAll() throws SQLException;
    
    List<ModelBook> selectLike(ModelBook book) throws SQLException; 
    
    List<ModelBook> selectEqual(ModelBook book) throws SQLException; 
    
    List<ModelBook> selectDynamic(ModelBook book) throws SQLException;
    
    int insertBook(ModelBook book) throws SQLException;
    
    int updateBook(ModelBook wherebook, ModelBook setbook) throws SQLException;
    
    int deleteBook(ModelBook book) throws SQLException;
}
