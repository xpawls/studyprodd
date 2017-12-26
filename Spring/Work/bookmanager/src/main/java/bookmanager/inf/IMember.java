package bookmanager.inf;

import java.sql.SQLException;
import java.util.List;

import bookmanager.model.ModelMember;


public interface IMember {
    List<ModelMember> selectAll() throws SQLException;
    
    List<ModelMember> selectLike(ModelMember member) throws SQLException; 
    
    List<ModelMember> selectEqual(ModelMember member) throws SQLException; 
    
    List<ModelMember> selectDynamic(ModelMember member) throws SQLException;
    
    int insertMember(ModelMember member) throws SQLException;
    
    int updateMember(ModelMember wheremember, ModelMember setmemeber) throws SQLException;
    
    int deleteMember(ModelMember member) throws SQLException;
}
