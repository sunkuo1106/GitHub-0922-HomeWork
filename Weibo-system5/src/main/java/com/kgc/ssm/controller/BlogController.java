package com.kgc.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.ssm.pojo.Blog;
import com.kgc.ssm.pojo.Users;
import com.kgc.ssm.service.BlogService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 16:12
 */
@Controller
public class BlogController {
    @Resource
    BlogService blogService;
    @RequestMapping("/toblog")
    public String toblog(Model model, @RequestParam(value = "pageNum",required = false)String pageNumBlog){
        int pageNum=1;
        if(pageNumBlog!=null&&pageNumBlog.isEmpty()==false){
            pageNum=Integer.parseInt(pageNumBlog);
        }
        int pageSize=1;
        PageHelper.startPage(pageNum,pageSize);
        List<Blog> blogs = blogService.blogList();
        PageInfo<Blog> pageInfo=new PageInfo<>(blogs);
        model.addAttribute("pageInfo",pageInfo);
        return "blogInfo";
    }
    @RequestMapping("/delBlog")
    public String delBlog(int id){
        blogService.delBlog(id);
        return "redirect:/toblog";
    }
    @RequestMapping("/fabu")
    public String fabu(){
        return "blogAdd";
    }
    @RequestMapping("/doBlogAdd")
    public String doBlogAdd(HttpSession session, String content){
        Users user = (Users) session.getAttribute("users");
        Blog blog=new Blog();
        blog.setUserid(user.getId());
        blog.setContent(content);
        blog.setPublishtime(new Date());
        blogService.addBlog(blog);
        return "redirect:/toblog";
    }
}

