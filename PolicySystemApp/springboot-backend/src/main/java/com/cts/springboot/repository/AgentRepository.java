package com.cts.springboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.springboot.model.Agent;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {

}
