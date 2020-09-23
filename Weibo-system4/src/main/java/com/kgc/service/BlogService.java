package com.kgc.service;

import com.kgc.pojo.Blog;

import java.util.List;

public interface BlogService {
    List<Blog> selectAllBlog();
    void del(int id);

    void add(Blog blog);
}
