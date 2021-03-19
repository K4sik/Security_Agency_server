package com.kas.security_agency.service;

import com.kas.security_agency.entity.Document;
import com.kas.security_agency.exception.DocumentNotFoundException;
import com.kas.security_agency.repository.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;

    public Document saveOrUpdateDocument(Document document){
        return documentRepository.save(document);
    }

    public Iterable<Document> findAll(){
        return documentRepository.findAll();
    }

    public Document findById(Long id){
        return documentRepository.getById(id).orElseThrow(() -> new DocumentNotFoundException("Document with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        Document document = findById(id);
        documentRepository.delete(document);
    }
}
