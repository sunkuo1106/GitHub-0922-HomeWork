package com.kgc.ssm.service;

import com.kgc.ssm.pojo.Blog;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 16:13
 */
public interface BlogService {
    List<Blog> blogList();
    void delBlog(int id);
    void addBlog(Blog blog);
}
