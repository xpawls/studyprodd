package com.spring67.upload.inf;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring67.upload.model.ModelUploadFile;

public interface IDaoUpload {
    List<ModelUploadFile> getUploadFile(ModelUploadFile file);
    int insertUploadFile(ModelUploadFile file);
    int insertUploadFileList(List<ModelUploadFile> files);
    int deleteUploadFile(ModelUploadFile file);
}
