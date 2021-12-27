package com.cts.springboot.dao;

import org.springframework.stereotype.Repository;

import com.cts.springboot.model.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("ArrayListDao")
public class ArrayListDao implements AgentDao {

    private static List<Agent> DB = new ArrayList<>();

    static {
        DB.add(new Agent("Divakar@gmail.com", "12345"));
        DB.add(new Agent("vijay@gmail.com", "abcasd"));
        DB.add(new Agent("sanjai@gmail.com", "tasdsd"));
        DB.add(new Agent("hasan@gmail.com", "kjghas"));
        DB.add(new Agent("huseyin@gmail.com", "fahgwa"));
    }

    @Override
    public int insertUser(Agent user) {
        DB.add(user);
        return 1;
    }

    @Override
    public List<Agent> selectAllUsers(){
        return DB;
    }

    @Override
    public Optional<Agent> selectUserByEmail(String USER_EMAIL) {
        return DB.stream()
                .filter(user -> user.getUSER_EMAIL().equals(USER_EMAIL))
                .findFirst();
    }


}
