package com.cc.smartx.user.codehelper;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.cc.smartx.user.codehelper.UserExample;
import com.cc.smartx.user.codehelper.User;
import com.cc.smartx.user.codehelper.UserMapper;

@Service
public class UserService{

    @Resource
    private UserMapper userMapper;

    public long countByExample(UserExample example){
        return userMapper.countByExample(example);
    }

    public int deleteByExample(UserExample example){
        return userMapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long id){
        return userMapper.deleteByPrimaryKey(id);
    }

    public int insert(User record){
        return userMapper.insert(record);
    }

    public int insertSelective(User record){
        return userMapper.insertSelective(record);
    }

    public List<User> selectByExample(UserExample example){
        return userMapper.selectByExample(example);
    }

    public User selectByPrimaryKey(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public int updateByExampleSelective(User record,UserExample example){
        return userMapper.updateByExampleSelective(record,example);
    }

    public int updateByExample(User record,UserExample example){
        return userMapper.updateByExample(record,example);
    }

    public int updateByPrimaryKeySelective(User record){
        return userMapper.updateByPrimaryKeySelective(record);
    }

    public int updateByPrimaryKey(User record){
        return userMapper.updateByPrimaryKey(record);
    }

}
