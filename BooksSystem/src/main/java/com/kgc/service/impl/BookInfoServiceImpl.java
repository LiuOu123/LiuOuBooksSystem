package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.mapper.BookInfoMapper;
import com.kgc.pojo.BookInfo;
import com.kgc.pojo.BookInfoExample;
import com.kgc.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 16:53
 */
@Service
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    BookInfoMapper bookInfoMapper;


    @Override
    public PageInfo<BookInfo> selectAll(Integer type, String name, Integer chaozuo, Integer pageIndex, Integer pageSize) {
        BookInfoExample bookInfoExample=new BookInfoExample();
        BookInfoExample.Criteria criteria = bookInfoExample.createCriteria();
        if (type!=null&&type!=0){
            criteria.andBookTypeEqualTo(type);
        }
        if (name!=null&&!name.equals("")){
            criteria.andBookNameLike("%"+name+"%");
        }
        if (chaozuo!=null&&chaozuo!=10){
            criteria.andIsBorrowEqualTo(chaozuo);
        }
        PageHelper.startPage(pageIndex,pageSize);
        List<BookInfo> bookInfos = bookInfoMapper.selectByExample(bookInfoExample);
        PageInfo<BookInfo> pageInfo=new PageInfo<>(bookInfos);
        return pageInfo;
    }
}
