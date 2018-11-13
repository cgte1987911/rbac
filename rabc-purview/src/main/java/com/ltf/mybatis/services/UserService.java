package com.ltf.mybatis.services;

import com.ltf.model.User;

import java.util.List;

/**
 * @author dreamneverdie
 *
 */
public interface UserService {
    /**
     * @return	用户列表
     */
    List<User> list();
    /**
     * @param user 传入user对象
     * @return	返回插入是否成功的信息
     */
    Long add(User user);
}
