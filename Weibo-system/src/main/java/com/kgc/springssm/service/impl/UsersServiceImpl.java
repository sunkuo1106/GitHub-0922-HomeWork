package com.kgc.springssm.service.impl;

import com.kgc.springssm.mapper.UsersMapper;
import com.kgc.springssm.pojo.Users;
import com.kgc.springssm.pojo.UsersExample;
import com.kgc.springssm.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 13:41
 */
@Service
public class UsersServiceImpl implements UsersService{
    @Resource
    UsersMapper usersMapper;

    @Override
    public Users tologin(String username) {
        Users user=null;
       /* UsersExample example=new UsersExample();*/
       UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        if(username!=null&&username.isEmpty()==false){
            criteria.andUsernameEqualTo(username);
        }
        List<Users> users = usersMapper.selectByExample(example);
        if(users!=null&&users.size()>0){
            user=users.get(0);
        }
        return user;
    }

    @Override
    public String touXiang(int userId) {
        String tx=null;
        UsersExample example=new UsersExample();
        UsersExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userId);
        List<Users> users = usersMapper.selectByExample(example);
        if(users!=null&&users.size()>0){
            tx=users.get(0).getPicpath();
        }
        return tx;
    }

    @Override
    public List<Users> selectAll() {
        List<Users> users = usersMapper.selectByExample(null);
        return users;
    }

    @Override
    public void add(Users users) {
        usersMapper.insertSelective(users);
    }

    @Override
    public void del(int id) {
        usersMapper.deleteByPrimaryKey(id);
    }
}
