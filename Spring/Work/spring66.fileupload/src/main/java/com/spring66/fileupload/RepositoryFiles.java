package com.spring66.fileupload;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public class RepositoryFiles {
    private Logger              logger = LoggerFactory
            .getLogger(this.getClass());
    
    private List<MultipartFile> files;
    
    public List<MultipartFile> getFiles() {
        return files;
    }
    
    public void setFiles(List<MultipartFile> files) {
        this.files = files;
    }
    
    public RepositoryFiles() {
        super();
    }
}
