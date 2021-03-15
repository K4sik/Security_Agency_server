package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Position;
import com.kas.security_agency.service.PositionService;
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
@RequestMapping("/api/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @PostMapping("")
    public ResponseEntity<?> addPosition(@Valid @RequestBody Position position, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Position newPosition = positionService.saveOrUpdatePosition(position);
        return new ResponseEntity<Position>(newPosition, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Position> getAllPositions(){
        return positionService.findAll();
    }
}
