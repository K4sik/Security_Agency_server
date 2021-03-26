package com.kas.security_agency.controller;

import com.kas.security_agency.entity.Document;
import com.kas.security_agency.service.DocumentService;
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
@RequestMapping("/api/document")
@CrossOrigin
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @PostMapping("/add")
    public ResponseEntity<?> addDocument(@Valid @RequestBody Document document, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        Document newDocument = documentService.saveOrUpdateDocument(document);
        return new ResponseEntity<Document>(newDocument, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<Document> getAllDocuments(){
        return documentService.findAll();
    }

    @GetMapping("/{document_id}")
    public ResponseEntity<?> getDocumentById(@PathVariable Long document_id){
        Document document = documentService.findById(document_id);
        return new ResponseEntity<Document>(document, HttpStatus.OK);
    }

    @PutMapping("/{document_id}")
    public ResponseEntity<?> putDocumentById(@RequestBody Document document){
        Document newDocument = documentService.saveOrUpdateDocument(document);
        return new ResponseEntity<Document>(newDocument, HttpStatus.OK);
    }

    @DeleteMapping("/{document_id}")
    public ResponseEntity<?> deleteDocumentById(@PathVariable Long document_id){
        documentService.deleteById(document_id);
        return new ResponseEntity<String>("Document deleted", HttpStatus.OK);
    }
}
