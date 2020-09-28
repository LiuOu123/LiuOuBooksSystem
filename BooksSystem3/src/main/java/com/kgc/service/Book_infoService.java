package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.pojo.Book_info;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 17:40
 */
public interface Book_infoService {
    PageInfo<Book_info> select(int lei, String title, int jie,Integer pageIndex, int pageSize);
}
