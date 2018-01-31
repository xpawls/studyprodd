package com.spring.test;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IDaoPhone {
    List<ModelPhone> selectAll();
    
    int insertPhone(ModelPhone phone);
}
