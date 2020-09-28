package com.kgc.service.impl;

import com.kgc.mapper.UsersMapper;
import com.kgc.pojo.Users;
import com.kgc.pojo.UsersExample;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-28 16:53
 */
@Service
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;

    @Override
    public Users selectByUserName(String username) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUserCodeEqualTo(username);
        List<Users> users = usersMapper.selectByExample(usersExample);
        if (users.size()>0){
            return users.get(0);
        }
        return null;
    }
}
