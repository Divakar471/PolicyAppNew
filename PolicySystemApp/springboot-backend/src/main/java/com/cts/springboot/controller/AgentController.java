package com.cts.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cts.springboot.model.Agent;
import com.cts.springboot.repository.AgentRepository;
import com.cts.springboot.service.AgentService;

import java.util.List;

@RestController
@RequestMapping("/rest")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AgentController {

    private final AgentService userService;
    @Autowired
    private AgentRepository userRepo;
    
    @Autowired
    public AgentController(AgentService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-user")
    public int addUser(@RequestBody Agent user){
        return userService.addUser(user);
    }

    @GetMapping("/users")
    public List<Agent> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{email}")
    public Agent getUserByEmail(@PathVariable("email") String USER_EMAIL){
        return userService.getUserByEmail(USER_EMAIL)
                .orElse(null);
    }


}
