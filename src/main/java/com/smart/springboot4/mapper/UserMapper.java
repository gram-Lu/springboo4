package com.smart.springboot4.mapper;

import com.smart.springboot4.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    @Insert("insert into USER (name,account_id,token,gmt_create,gmt_modified) values (#{name},#{account_id},#{token},#{gtmCreate},#{gtmModified})")
      void insert(User user);
}