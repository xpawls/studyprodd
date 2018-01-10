package com.spring66.fileupload.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ModelUploadFile {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private Integer uploadFileNo ;
    private String fileNameOrig ;
    private String fileNameTemp ;
    private Long fileSize ;
    private String contentType ;
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
    public Long getFileSize() {
        return fileSize;
    }
    public void setFileSize(Long fileSize) {
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
            String fileNameTemp, Long fileSize, String contentType) {
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
