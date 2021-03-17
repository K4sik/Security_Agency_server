package com.kas.security_agency.service;

import com.kas.security_agency.entity.Team;
import com.kas.security_agency.exception.TeamNotFoundException;
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

    public Team findById(Long id){
        return teamRepository.getById(id).orElseThrow(() -> new TeamNotFoundException("Team with id " + id + "was not found"));
    }

    public void deleteById(Long id){
        Team team = findById(id);
        teamRepository.delete(team);
    }
}
