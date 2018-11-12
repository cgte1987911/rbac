package com.ltf.mybatis.dao;

import com.ltf.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    public List<User> findAll();
    public Long insertOne(User user);
}
