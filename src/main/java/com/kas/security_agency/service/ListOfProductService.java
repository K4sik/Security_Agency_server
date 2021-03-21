package com.kas.security_agency.service;

import com.kas.security_agency.entity.ListOfProduct;
import com.kas.security_agency.exception.ListOfProductNotFoundException;
import com.kas.security_agency.repository.ListOfProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListOfProductService {

    @Autowired
    private ListOfProductRepository listOfProductRepository;

    public ListOfProduct saveOrUpdateListOfProduct(ListOfProduct listOfProduct) {
        return listOfProductRepository.save(listOfProduct);
    }

    public Iterable<ListOfProduct> findAll() {
        return listOfProductRepository.findAll();
    }

    public ListOfProduct findById(Long id) {
        return listOfProductRepository.getById(id).orElseThrow(() -> new ListOfProductNotFoundException("ListOfProduct with id " + id + " was not found"));
    }

    public void deleteById(Long id){
        ListOfProduct listOfProduct = findById(id);
        listOfProductRepository.delete(listOfProduct);
    }
}
