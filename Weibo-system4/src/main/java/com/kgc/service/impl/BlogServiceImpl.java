package com.kgc.service.impl;

import com.kgc.mapper.BlogMapper;
import com.kgc.pojo.Blog;
import com.kgc.service.BlogService;
import com.kgc.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class BlogServiceImpl implements BlogService {

    @Resource
    BlogMapper blogMapper;

    @Resource
    UsersService usersService;

    @Override
    public List<Blog> selectAllBlog() {
        List<Blog> blogs = blogMapper.selectByExample(null);
        for (Blog blog : blogs) {
            String s = usersService.touXiang(blog.getUserid());
            blog.setPicpath(s);
        }
        return blogs;
    }

    @Override
    public void del(int id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void add(Blog blog) {
        blogMapper.insertSelective(blog);
    }


}
