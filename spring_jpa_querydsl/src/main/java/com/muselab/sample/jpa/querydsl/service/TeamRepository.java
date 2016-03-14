package com.muselab.sample.jpa.querydsl.service;

import com.muselab.sample.jpa.querydsl.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@Transactional
public class TeamRepository {

    @Autowired
    private EntityManager em;

    public Team save(Team team) {
        em.persist(team);
        return em.find(Team.class,team.getTeamId());
    }
}
