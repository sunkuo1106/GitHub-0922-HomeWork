package com.kgc.springssm.service;

import com.kgc.springssm.pojo.Users;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 13:40
 */
public interface UsersService {
  Users tologin(String username);
  String touXiang(int userId);
  List<Users>selectAll();

  void add(Users users);

  void del(int id);
}
