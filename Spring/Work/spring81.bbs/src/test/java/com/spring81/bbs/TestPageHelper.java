package com.spring81.bbs;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.spring81.bbs.common.PagingHelper;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestPageHelper {
    @Test
    public void test01_paging() {
        
        // 총레코드수 : 1000
        // 현재 페이지 : 1
        // 페이지당 레코드수(rowsPerBlock) : 10개
        // 블락당 출력할 페이지수(pagesPerBlock) : 10개 
        
        int totalRecord = 1000;
        int curPage     = 1;
        
        PagingHelper paging = new PagingHelper(totalRecord, curPage);
        
        // ListNo
        assertEquals(paging.getListNo(), 1000);
        
        // totalPage
        assertEquals(paging.getTotalPage(), 100);
        
        // firstPage
        assertEquals(paging.getFirstPage(), 1);
        
        // prevLink
        assertEquals(paging.getPrevLink(), 0);
        
        // totalFirstPage
        assertEquals(paging.getTotalFirstPage(), 1);
        
        // lastPage
        assertEquals(paging.getLastPage(), 10);
        
        // nextLink
        assertEquals(paging.getNextLink(), 11);
        
        // totalLastPage
        assertEquals(paging.getTotalLastPage(), 100);
        
        // endRecord
        assertEquals(paging.getEndRecord(), 10);
        
        // startRecord
        assertEquals(paging.getStartRecord(), 1);
        
        // pageLinks
        assertEquals(paging.getPageLinks(), new int[] {1,2,3,4,5,6,7,8,9,10});
    }
}
