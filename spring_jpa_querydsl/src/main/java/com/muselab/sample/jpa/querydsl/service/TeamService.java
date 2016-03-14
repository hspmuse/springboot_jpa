package com.muselab.sample.jpa.querydsl.service;

import com.muselab.sample.jpa.querydsl.domain.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team save(Team team) {
        return teamRepository.save(team);
    }
}
