package com.kgc.service;

import com.kgc.pojo.Users;

/**
 * @author shkstart
 * @create 2020-09-28 16:52
 */
public interface UsersService {

    Users selectByUserName(String username);
}
