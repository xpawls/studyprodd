package bookmanager.inf;

import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bookmanager.model.ModelBorrow;

public interface IBorrow {
    List<ModelBorrow> selectAll() throws SQLException;
    
    int insertBorrow(ModelBorrow borrow) throws SQLException;
    
    int deleteBorrow(ModelBorrow borrow) throws SQLException;
}
