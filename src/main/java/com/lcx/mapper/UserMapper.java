package com.lcx.mapper;

import com.lcx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where mobile=#{mobile}")
    User find(int mobile);

    @Insert("insert into user values(#{age},#{mobile},#{password})")
    void add(User user);
}
