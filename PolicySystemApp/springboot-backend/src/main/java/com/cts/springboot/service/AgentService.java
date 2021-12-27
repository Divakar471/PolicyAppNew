package com.cts.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cts.springboot.dao.AgentDao;
import com.cts.springboot.model.Agent;

import java.util.List;
import java.util.Optional;

@Service
public class AgentService {

    private final AgentDao userDao;

    @Autowired
    public AgentService(@Qualifier("ArrayListDao") AgentDao userDao) {
        this.userDao = userDao;
    }

    public int addUser(Agent user){
        return userDao.insertUser(user);
    }

    public List<Agent> getAllUsers(){
        return userDao.selectAllUsers();
    }

    public Optional<Agent> getUserByEmail(String USER_EMAIL){
        return userDao.selectUserByEmail(USER_EMAIL);
    }


}
