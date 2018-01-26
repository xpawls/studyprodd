package com.study.bookmgr.inf;

import java.sql.SQLException;
import java.util.List;

import com.study.bookmgr.model.ModelMember;


public interface IMember {
    List<ModelMember> selectAll() throws SQLException;
    
    int newID(String memID) throws SQLException;
    ModelMember Login(String memID, String memPW) throws SQLException;
    
    List<ModelMember> selectLike(ModelMember member) throws SQLException; 
    
    List<ModelMember> selectEqual(ModelMember member) throws SQLException; 
    
    List<ModelMember> selectDynamic(ModelMember member) throws SQLException;
    
    int insertMember(ModelMember member) throws SQLException;
    
    int updateMember(ModelMember wheremember, ModelMember setmemeber) throws SQLException;
    
    int deleteMember(ModelMember member) throws SQLException;
}
