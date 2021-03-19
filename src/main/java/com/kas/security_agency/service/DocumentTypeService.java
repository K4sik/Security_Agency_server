package com.kas.security_agency.service;

import com.kas.security_agency.entity.DocumentType;
import com.kas.security_agency.exception.DocumentTypeNotFoundException;
import com.kas.security_agency.repository.DocumentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocumentTypeService {

    @Autowired
    private DocumentTypeRepository documentTypeRepository;

    public DocumentType saveOrUpdateDocumentType(DocumentType documentType){
        return documentTypeRepository.save(documentType);
    }

    public Iterable<DocumentType> findAll(){
        return documentTypeRepository.findAll();
    }

    public DocumentType findById(Long id){
        return documentTypeRepository.getById(id).orElseThrow(() -> new DocumentTypeNotFoundException("Type of document with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        DocumentType documentType = findById(id);
        documentTypeRepository.delete(documentType);
    }
}
