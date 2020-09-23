package com.kgc.springssm.service.impl;

import com.kgc.springssm.mapper.BlogMapper;
import com.kgc.springssm.pojo.Blog;
import com.kgc.springssm.service.BlogService;
import com.kgc.springssm.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 13:41
 */
@Service
public class BlogServiceImpl implements BlogService{
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
