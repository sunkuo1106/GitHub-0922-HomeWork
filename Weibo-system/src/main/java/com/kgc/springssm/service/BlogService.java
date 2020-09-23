package com.kgc.springssm.service;

import com.kgc.springssm.pojo.Blog;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 13:40
 */
public interface BlogService {
    List<Blog> selectAllBlog();
    void del(int id);
    void add(Blog blog);

}
