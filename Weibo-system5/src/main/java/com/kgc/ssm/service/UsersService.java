package com.kgc.ssm.service;

import com.kgc.ssm.pojo.Users;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 15:20
 */
public interface UsersService {
    Users userList(String username);
    List<Users> users();
    String touXiang(int userId);
    void addUsers(Users users);

    void delUsers(int id);
}
