package com.kgc.ssm.service.impl;

import com.kgc.ssm.mapper.UsersMapper;
import com.kgc.ssm.pojo.Users;
import com.kgc.ssm.pojo.UsersExample;
import com.kgc.ssm.service.UsersService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-09-23 15:20
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService{
    @Resource
    UsersMapper usersMapper;
    @Override
    public Users userList(String username) {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        criteria.andUsernameEqualTo(username);
        List<Users> usersList = usersMapper.selectByExample(usersExample);
        if(usersList.size()>0){
            return usersList.get(0);
        }
      return null;
    }

    @Override
    public List<Users> users() {
        UsersExample usersExample=new UsersExample();
        UsersExample.Criteria criteria = usersExample.createCriteria();
        return usersMapper.selectByExample(usersExample);
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
    public void addUsers(Users users) {
        usersMapper.insertSelective(users);
    }

    @Override
    public void delUsers(int id) {
        usersMapper.deleteByPrimaryKey(id);
    }
}
