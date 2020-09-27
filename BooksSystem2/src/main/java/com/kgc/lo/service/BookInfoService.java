package com.kgc.lo.service;

import com.kgc.lo.pojo.BookInfo;

import java.util.List;

public interface BookInfoService {
    List<BookInfo> select(int lei,String title,int jie);
    List<BookInfo> selectAll();
}
