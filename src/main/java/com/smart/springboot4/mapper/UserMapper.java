package com.smart.springboot4.mapper;

import com.smart.springboot4.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Insert("insert into community (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{account_id},#{token},#{gtmCreate},#{gtmModified})")
      void insert(User user);
    @Select("select * from community where token = #{token}")
     User findToken(@Param("token") String token);
}
