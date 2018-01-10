package com.spring66.fileupload.model;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class ModelUploadImage {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    private Integer uploadImageNo ;
    private String fileName ;
    private Long fileSize ;
    private String contentType ;
    private byte[] imageBytes ; // BLOB 컬럼
    private String imageBase64 ; // CLOB(TEXT) 컬럼
    private CommonsMultipartFile image;
    public Logger getLogger() {
        return logger;
    }
    public void setLogger(Logger logger) {
        this.logger = logger;
    }
    public Integer getUploadImageNo() {
        return uploadImageNo;
    }
    public void setUploadImageNo(Integer uploadImageNo) {
        this.uploadImageNo = uploadImageNo;
    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
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
    public byte[] getImageBytes() {
        return imageBytes;
    }
    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
    public String getImageBase64() {
        return imageBase64;
    }
    public void setImageBase64(String imageBase64) {
        this.imageBase64 = imageBase64;
    }
    public CommonsMultipartFile getImage() {
        return image;
    }
    public void setImage(CommonsMultipartFile image) {
        this.image = image;
    }
    @Override
    public String toString() {
        return "ModelUploadImage [logger=" + logger + ", uploadImageNo="
                + uploadImageNo + ", fileName=" + fileName + ", fileSize="
                + fileSize + ", contentType=" + contentType + ", imageBytes="
                + Arrays.toString(imageBytes) + ", imageBase64=" + imageBase64
                + ", image=" + image + "]";
    }
    public ModelUploadImage(Integer uploadImageNo, String fileName,
            Long fileSize, String contentType, byte[] imageBytes,
            String imageBase64, CommonsMultipartFile image) {
        super();
        this.uploadImageNo = uploadImageNo;
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.contentType = contentType;
        this.imageBytes = imageBytes;
        this.imageBase64 = imageBase64;
        this.image = image;
    }
    public ModelUploadImage() {
        super();
    }
    
    
}
