package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Team;
import com.kas.security_agency.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("")
    public ResponseEntity<?> addPosition(@Valid @RequestBody Team team, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Team newTeam = teamService.saveOrUpdateTeam(team);
        return new ResponseEntity<Team>(newTeam, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Team> getAllPositions(){
        return teamService.findAll();
    }

    @GetMapping("/{team_id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long team_id){
        Team team = teamService.findById(team_id);
        return new ResponseEntity<Team>(team, HttpStatus.OK);
    }

    @PutMapping("/{team_id}")
    public ResponseEntity<?> putTeamById(@RequestBody Team team){
        Team newTeam = teamService.saveOrUpdateTeam(team);
        return new ResponseEntity<Team>(newTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{team_id}")
    public ResponseEntity<?> deleteTeamById(@PathVariable Long team_id){
        teamService.deleteById(team_id);
        return new ResponseEntity<String>("Team deleted", HttpStatus.OK);
    }
}
