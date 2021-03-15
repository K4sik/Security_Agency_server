package com.kas.security_agency.service;

import com.kas.security_agency.entity.Position;
import com.kas.security_agency.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositionService {

    @Autowired
    private PositionRepository positionRepository;

    public Position saveOrUpdatePosition(Position position){
        return positionRepository.save(position);
    }

    public Iterable<Position> findAll(){
        return positionRepository.findAll();
    }


}
