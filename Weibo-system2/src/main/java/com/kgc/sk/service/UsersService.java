package com.kgc.sk.service;

import com.kgc.sk.pojo.Users;

import java.util.List;

public interface UsersService {
    Users login(String username);
    String touXiang(int userId);
    List<Users>selectAll();

    void add(Users users);

    void del(int id);
}
