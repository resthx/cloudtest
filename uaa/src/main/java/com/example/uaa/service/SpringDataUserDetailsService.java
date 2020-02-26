package com.example.uaa.service;
import com.alibaba.fastjson.JSON;
import com.example.uaa.mapper.UserMapper;
import com.example.uaa.model.UserDto;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 **/
@Service
public class SpringDataUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    //根据 账号查询用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if (StringUtils.isEmpty(username)){
            return null;
        }
        //根据用户的id查询用户的权限
//        List<String> permissions = userDao.findPermissionsByUserId(userDto.getId());
        //将permissions转成数组
//        String[] permissionArray = new String[permissions.size()];
//        permissions.toArray(permissionArray);
        //将userDto转成json
//        String principal = JSON.toJSONString(userDto);
        UserDto eq = new UserDto();
        eq.setUsername(username);
        UserDto userDto = userMapper.selectOne(eq);
        if (userDto==null){
            return null;
        }
        //查找权限
        List<String> permissions = userMapper.findPermissionsByUserId(userDto.getId());
        String[] permissionArray = new String[permissions.size()];
        permissions.toArray(permissionArray);
        String user = JSON.toJSONString(userDto);
        UserDetails userDetails = User.withUsername(user).password(userDto.getPassword()).authorities(permissionArray).build();
        return userDetails;
    }
}
