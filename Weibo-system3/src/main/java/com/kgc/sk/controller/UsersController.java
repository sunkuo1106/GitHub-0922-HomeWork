package com.kgc.sk.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.sk.pojo.Blog;
import com.kgc.sk.pojo.Users;
import com.kgc.sk.service.UsersService;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {

    @Resource
    UsersService usersService;

    @RequestMapping("/")
    public String toLogin(){
        return "index";
    }

    @RequestMapping("/doLogin")
    @ResponseBody
    public Map<String,Object> doLogin(String username, String password, HttpSession session){
        Map<String,Object> map=new HashMap<>();
        Users user = usersService.login(username);
        if(user==null){
            map.put("status",false);
            map.put("error","用户名不正确");
        }else if(user.getPassword().equals(password)==false){
            map.put("status",false);
            map.put("error","密码不正确");
        }else{
            session.setAttribute("user",user);
            map.put("status", true);
        }
        return map;
    }

    @RequestMapping("/zhuxiao")
    public String zhuxiao(HttpSession session){
        session.invalidate();
        return "index";
    }

    @RequestMapping("/toUser")
    public String toUser(Model model,@RequestParam(value="pageNum",required=false) String pageNumStr){
        int pageNum=1;
        if(pageNumStr!=null&&pageNumStr!=""){
            pageNum=Integer.parseInt(pageNumStr);
        }
        int pageSize=1;
        PageHelper.startPage(pageNum,pageSize);
        List<Users> users = usersService.selectAll();
        PageInfo<Users>pageInfo=new PageInfo<>(users);
        model.addAttribute("pageInfo",pageInfo);
        return "userInfo";
    }

    @RequestMapping("/toAddUsers")
    public String toAddUsers(){
        return "userAdd";
    }

    @RequestMapping("/doAddUsers")
    public String doAddUsers(Users users, MultipartFile picpathZJH,HttpSession session){
        String realPath = session.getServletContext().getRealPath("/static/uploadfiles/");
        String originalFilename = picpathZJH.getOriginalFilename();
        String extension = FilenameUtils.getExtension(originalFilename);
        String fileNewName=System.currentTimeMillis()+"_"+ RandomUtils.nextInt(10000)+"."+extension;
        File file=new File(realPath,fileNewName);
        try {
            picpathZJH.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(users.getSex().equals("1")){
            users.setSex(0);
        }else{
            users.setSex(1);
        }
        users.setPicpath(fileNewName);
        usersService.add(users);
        return "redirect:/toUser";
    }

    @RequestMapping("/delUsers")
    public String delUsers(int id){
        usersService.del(id);
        return "redirect:/toUser";
    }




}
