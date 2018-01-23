package com.exam08.hn;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface IDaoPhone {
    ModelPhone getPhoneOne(String name);
    List<ModelPhone> getPhoneList(int start, int end);
    int getPhoneTotalRecord();
    int insertPhone(ModelPhone phone);
}
