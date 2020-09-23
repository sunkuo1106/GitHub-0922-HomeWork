package com.kgc.sk.service;

import com.kgc.sk.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAllBlog();
    void del(int id);

    void add(Blog blog);
}
