package com.kgc.lo.service.impl;

import com.kgc.lo.mapper.UsersMapper;
import com.kgc.lo.pojo.Users;
import com.kgc.lo.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("/usersService")
public class UsersServiceImpl implements UsersService {
    @Resource
    UsersMapper usersMapper;
    @Override
    public List<Users> selectAll() {
        List<Users> users = usersMapper.selectByExample(null);
        return users;
    }
}
