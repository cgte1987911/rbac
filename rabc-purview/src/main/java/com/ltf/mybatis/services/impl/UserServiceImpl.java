package com.ltf.mybatis.services.impl;

import com.ltf.model.User;
import com.ltf.mybatis.dao.UserDao;
import com.ltf.mybatis.services.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dreamneverdie
 *
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;
    @Override
	public List<User> list() {
        return this.userDao.findAll();
    }

    @Override
    public Long add(User user) {
        return this.userDao.insertOne(user);
    }
}
