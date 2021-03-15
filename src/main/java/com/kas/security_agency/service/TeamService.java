package com.kas.security_agency.service;

import com.kas.security_agency.entity.Team;
import com.kas.security_agency.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    @Autowired
    private TeamRepository teamRepository;

    public Team saveOrUpdateTeam(Team team){
        return teamRepository.save(team);
    }

    public Iterable<Team> findAll(){
        return teamRepository.findAll();
    }
}
