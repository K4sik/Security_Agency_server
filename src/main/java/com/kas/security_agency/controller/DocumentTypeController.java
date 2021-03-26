package com.kas.security_agency.controller;

import com.kas.security_agency.entity.DocumentType;
import com.kas.security_agency.service.DocumentTypeService;
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
@RequestMapping("/api/document_type")
@CrossOrigin
public class DocumentTypeController {

    @Autowired
    private DocumentTypeService documentTypeService;

    @PostMapping("/add")
    public ResponseEntity<?> addDocumentType(@Valid @RequestBody DocumentType documentType, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        DocumentType newDocumentType = documentTypeService.saveOrUpdateDocumentType(documentType);
        return new ResponseEntity<DocumentType>(newDocumentType, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<DocumentType> getAllDocumentTypes(){
        return documentTypeService.findAll();
    }

    @GetMapping("/{document_type_id}")
    public ResponseEntity<?> getDocumentById(@PathVariable Long document_type_id){
        DocumentType documentType = documentTypeService.findById(document_type_id);
        return new ResponseEntity<DocumentType>(documentType, HttpStatus.OK);
    }

    @PutMapping("/{document_type_id}")
    public ResponseEntity<?> putDocumentTypeById(@RequestBody DocumentType documentType){
        DocumentType newDocumentType = documentTypeService.saveOrUpdateDocumentType(documentType);
        return new ResponseEntity<DocumentType>(newDocumentType, HttpStatus.OK);
    }

    @DeleteMapping("/{document_type_id}")
    public ResponseEntity<?> deleteDocumentTypeById(@PathVariable Long document_type_id){
        documentTypeService.deleteById(document_type_id);
        return new ResponseEntity<String>("Type of document deleted", HttpStatus.OK);
    }
}
