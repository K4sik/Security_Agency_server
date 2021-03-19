package com.kas.security_agency.repository;

import com.kas.security_agency.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Long> {

    Optional<Document> getById(Long id);

}
