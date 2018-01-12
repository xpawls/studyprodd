package com.spring67.upload.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class RepositoryFiles {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // 필드명으로는 클라이언트에서 넘어오는 변수명(input 태그의 name 속성 값을)을 사용해야 한다.
    // <input type="file" name="files[0]" />
    private List<org.springframework.web.multipart.MultipartFile> files;

    public List<org.springframework.web.multipart.MultipartFile> getFiles() {
        return files;
    }

    public void setFiles(
            List<org.springframework.web.multipart.MultipartFile> files) {
        this.files = files;
    }

    public RepositoryFiles() {
        super();
    }
    
    
}
