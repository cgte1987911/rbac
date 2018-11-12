package com.ltf.mybatis.dao;

import com.ltf.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dreamneverdie
 *
 */
@Mapper
public interface UserDao {
    /**
     * @return	所有用户
     */
     List<User> findAll();
    /**
     * @param user 传入user对象
     * @return 数据库插入一个用户
     */
     Long insertOne(User user);
}
