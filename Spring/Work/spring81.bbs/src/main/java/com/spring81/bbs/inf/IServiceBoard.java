package com.spring81.bbs.inf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring81.bbs.model.ModelArticle;

public interface IServiceBoard extends IBoard {
    ModelArticle transArticle(int articleno);
    int transDeleteArticle(int articleno);
    
}
