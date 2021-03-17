package com.kas.security_agency.service;

import com.kas.security_agency.entity.Position;
import com.kas.security_agency.exception.PositionNotFoundException;
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

    public Position findById(Long id){
        return positionRepository.getById(id).orElseThrow(() -> new PositionNotFoundException("Position with id " + id + "was not found"));
    }

    public void deleteById(Long id){
        Position position = findById(id);
        positionRepository.delete(position);
    }

}
