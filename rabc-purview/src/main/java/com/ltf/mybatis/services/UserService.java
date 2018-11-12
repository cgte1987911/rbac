package com.ltf.mybatis.services;

import com.ltf.model.User;

import java.util.List;

public interface UserService {
    public List<User> list();
    public Long add(User user);
}
