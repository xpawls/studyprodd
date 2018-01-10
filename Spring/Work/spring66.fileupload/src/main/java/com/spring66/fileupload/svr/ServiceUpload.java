package com.spring66.fileupload.svr;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring66.fileupload.inf.IDaoUpload;
import com.spring66.fileupload.inf.IServiceUpload;
import com.spring66.fileupload.model.ModelUploadFile;
import com.spring66.fileupload.model.ModelUploadImage;

@Service
public class ServiceUpload implements IServiceUpload {
    private Logger     logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private IDaoUpload uploaddao;
    
    @Override
    public List<ModelUploadFile> getUploadFile(ModelUploadFile file) {
        List<ModelUploadFile> rs = null;
        try {
            rs = uploaddao.getUploadFile(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("getUploadFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertUploadFile(ModelUploadFile file) {
        int rs = -1;
        try {
            rs = uploaddao.insertUploadFile(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertUploadFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertUploadFileList(List<ModelUploadFile> files) {
        int rs = -1;
        try {
            rs = uploaddao.insertUploadFileList(files);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("insertUploadFileList" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int deleteUploadFile(ModelUploadFile file) {
        int rs = -1;
        try {
            rs = uploaddao.deleteUploadFile(file);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            // e.printStackTrace();
            logger.error("deleteUploadFile" + e.getMessage());
            throw e;
            
        }
        return rs;
    }
    
    @Override
    public int insertPhoto(ModelUploadImage attachfile) {
        int result = -1;
        try {
            result = uploaddao.insertPhoto(attachfile);
        } catch (Exception e) {
            logger.error("insertPhoto " + e.getMessage());
        }
        return result;
    }
    
    @Override
    public ModelUploadImage getImageByte(int attachfileno) {
        ModelUploadImage result = null;
        try {
            result = uploaddao.getImageByte(attachfileno);
        } catch (Exception e) {
            logger.error("getImageByte " + e.getMessage());
        }
        return result;
    }
}
