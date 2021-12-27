package com.cts.springboot.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.cts.springboot.model.Agent;

public interface AgentDao {

    int insertUser(Agent user);

    List<Agent> selectAllUsers();

    Optional<Agent> selectUserByEmail(String USER_EMAIL);

}
