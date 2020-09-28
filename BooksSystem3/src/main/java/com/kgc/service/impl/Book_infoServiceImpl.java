package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.Book_infoMapper;
import com.kgc.pojo.Book_info;
import com.kgc.pojo.Book_infoExample;
import com.kgc.service.Book_infoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 17:40
 */
@Service("book_infoService")
public class Book_infoServiceImpl implements Book_infoService {
    @Resource
    Book_infoMapper book_infoMapper;
    @Override
    public PageInfo<Book_info> select(int lei, String title, int jie, Integer pageIndex, int pageSize) {

        Book_infoExample example = new Book_infoExample();
        Book_infoExample.Criteria criteria = example.createCriteria();
        if (lei != 0) {
            criteria.andBookTypeEqualTo(lei);
        }
        if (title != null) {
            criteria.andBookNameLike("%" + title + "%");
        }
        if (jie != 0) {
            criteria.andIsBorrowEqualTo(jie);
        }
        List<Book_info> book_infos = book_infoMapper.selectByExample(example);
        PageHelper.startPage(pageIndex, pageSize);
        PageInfo<Book_info> book_infoPageInfo = new PageInfo<>(book_infos);
        return book_infoPageInfo;
    }
}
