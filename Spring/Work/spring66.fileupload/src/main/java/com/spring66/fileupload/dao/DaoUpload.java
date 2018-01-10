package com.spring66.fileupload.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.spring66.fileupload.inf.IDaoUpload;
import com.spring66.fileupload.model.ModelUploadFile;
import com.spring66.fileupload.model.ModelUploadImage;

@Repository
public class DaoUpload implements IDaoUpload {
    private Logger     logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    @Qualifier("sqlSession")
    private SqlSession session;
    
    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        return session.selectList("mapper.mapperUpload.getUploadFile", file);
    }
    
    @Override
    public int insertUploadFile(ModelUploadFile file) {
        session.insert("mapper.mapperUpload.insertUploadFile", file);
        return file.getUploadFileNo();
    }
    
    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        return session.insert("mapper.mapperUpload.insertUploadFileList",
                files);
    }
    
    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        return session.delete("mapper.mapperUpload.deleteUploadFile", file);
    }
    
    @Override
    public int insertPhoto(ModelUploadImage imageinfo) {
        /*
         * // Oracle 인 경우 Map<String, Object> map = new HashMap<String, Object>(); map.put("fileinfo" , imageinfo);
         * map.put("result", null); session.insert("mapper.mapperUpload.insertPhoto", map); int result =
         * map.get("result") != null ? (int) map.get("result") : -1; return result;
         */
        // mysql 인 경우
        session.insert("mapper.mapperUpload.insertPhoto", imageinfo);
        return imageinfo.getUploadImageNo();
    }
    
    @Override
    public ModelUploadImage getImageByte(int attachfileno) {
        return session.selectOne("mapper.mapperUpload.getImageByte",
                attachfileno);
    }
}
