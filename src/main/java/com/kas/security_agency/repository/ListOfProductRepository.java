package com.kas.security_agency.repository;

import com.kas.security_agency.entity.ListOfProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ListOfProductRepository extends JpaRepository<ListOfProduct, Long> {

    Optional<ListOfProduct> getById(Long id);

}
