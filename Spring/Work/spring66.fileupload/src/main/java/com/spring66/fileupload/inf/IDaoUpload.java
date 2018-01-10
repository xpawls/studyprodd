package com.spring66.fileupload.inf;

import java.util.List;

import com.spring66.fileupload.model.ModelUploadFile;
import com.spring66.fileupload.model.ModelUploadImage;

public interface IDaoUpload {
    
    List<ModelUploadFile> getUploadFile( ModelUploadFile file );
    int insertUploadFile( ModelUploadFile file );
    int insertUploadFileList( List<ModelUploadFile> files );
    int deleteUploadFile( ModelUploadFile file );
    
    ModelUploadImage getImageByte(int attachfileno);
    int insertPhoto(ModelUploadImage attachfile);
}
