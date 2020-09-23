package com.kgc.ssm.service.impl;

import com.kgc.ssm.mapper.BlogMapper;
import com.kgc.ssm.pojo.Blog;
import com.kgc.ssm.pojo.BlogExample;
import com.kgc.ssm.service.BlogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 16:13
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService {
    @Resource
    BlogMapper blogMapper;
    @Override
    public List<Blog> blogList() {
        BlogExample blogExample=new BlogExample();
        BlogExample.Criteria criteria = blogExample.createCriteria();
        return blogMapper.selectByExample(blogExample);
    }

    @Override
    public void delBlog(int id) {
        blogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void addBlog(Blog blog) {
        blogMapper.insertSelective(blog);
    }
}
