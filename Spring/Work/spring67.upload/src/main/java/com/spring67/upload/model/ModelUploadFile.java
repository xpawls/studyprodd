package com.spring67.upload.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelUploadFile {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private Integer uploadFileNo = null;      //uploadFileNo` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    private String  fileNameOrig = "";      //fileNameOrig` VARCHAR(100) NOT NULL,
    private String  fileNameTemp = "";      //fileNameTemp` VARCHAR(100) NOT NULL,
    private Integer fileSize     = null;      //fileSize      ` INT(10) UNSIGNED NOT NULL,
    private String  contentType  = "";      //contentType  ` VARCHAR(30) NOT NULL,
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public Integer getUploadFileNo() {
        return uploadFileNo;
    }
    public void setUploadFileNo(Integer uploadFileNo) {
        this.uploadFileNo = uploadFileNo;
    }
    public String getFileNameOrig() {
        return fileNameOrig;
    }
    public void setFileNameOrig(String fileNameOrig) {
        this.fileNameOrig = fileNameOrig;
    }
    public String getFileNameTemp() {
        return fileNameTemp;
    }
    public void setFileNameTemp(String fileNameTemp) {
        this.fileNameTemp = fileNameTemp;
    }
    public Integer getFileSize() {
        return fileSize;
    }
    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }
    public String getContentType() {
        return contentType;
    }
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
    @Override
    public String toString() {
        return "ModelUploadFile [logger=" + logger + ", uploadFileNo="
                + uploadFileNo + ", fileNameOrig=" + fileNameOrig
                + ", fileNameTemp=" + fileNameTemp + ", fileSize=" + fileSize
                + ", contentType=" + contentType + "]";
    }
    public ModelUploadFile(Integer uploadFileNo, String fileNameOrig,
            String fileNameTemp, Integer fileSize, String contentType) {
        super();
        this.uploadFileNo = uploadFileNo;
        this.fileNameOrig = fileNameOrig;
        this.fileNameTemp = fileNameTemp;
        this.fileSize = fileSize;
        this.contentType = contentType;
    }
    public ModelUploadFile() {
        super();
    }
    
    
    
}
