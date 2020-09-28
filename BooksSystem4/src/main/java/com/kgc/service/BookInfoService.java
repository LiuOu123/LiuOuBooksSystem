package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.BookInfo;

/**
 * @author shkstart
 * @create 2020-09-28 16:53
 */
public interface BookInfoService {
    PageInfo<BookInfo> selectAll(Integer type,String name,Integer chaozuo,Integer pageIndex,Integer pageSize);
}
