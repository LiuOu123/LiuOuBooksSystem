package com.kgc.lo.service.impl;

import com.kgc.lo.mapper.BookInfoMapper;
import com.kgc.lo.pojo.BookInfo;
import com.kgc.lo.pojo.BookInfoExample;
import com.kgc.lo.service.BookInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("/bookInfoService")
public class BookInfoServiceImpl implements BookInfoService {
    @Resource
    BookInfoMapper bookInfoMapper;
    @Override
    public List<BookInfo> select(int lei, String title, int jie) {
        BookInfoExample example=new BookInfoExample();
        BookInfoExample.Criteria criteria = example.createCriteria();
        if(lei!=0){
            criteria.andBookTypeEqualTo(lei);
        }
        if(title!=null&&title.length()!=0){
            criteria.andBookNameLike(title);
        }
        if(jie!=10){
            criteria.andIsBorrowEqualTo(jie);
        }
        List<BookInfo> bookInfos = bookInfoMapper.selectByExample(example);
        return bookInfos;
    }

    @Override
    public List<BookInfo> selectAll() {
        List<BookInfo> bookInfos = bookInfoMapper.selectByExample(null);
        return bookInfos;
    }
}
