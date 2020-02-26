package com.example.uaa.mapper;


import com.example.uaa.model.UserDto;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.security.core.parameters.P;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UserDto> {

    @Select(value = "select c.code from t_permission c where c.id in " +
            "(select b.permission_id from t_role_permission b where b.role_id in " +
            "(select a.role_id from t_user_role a where a.user_id = #{userId}))")
    public List<String> findPermissionsByUserId(@Param("userId")String userId);

}
