package com.kas.security_agency.controller;

import com.kas.security_agency.entity.ListOfProduct;
import com.kas.security_agency.service.ListOfProductService;
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
@RequestMapping("/api/listOfProduct")
@CrossOrigin
public class ListOfProductController {

    @Autowired
    private ListOfProductService listOfProductService;

    @PostMapping("")
    public ResponseEntity<?> addListOfProduct(@Valid @RequestBody ListOfProduct listOfProduct, BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            Map<String, String> errorMap = new HashMap<>(); //bindingResult.getFieldErrors()

            for (FieldError error : bindingResult.getFieldErrors()){
                errorMap.put(error.getField(), error.getDefaultMessage());
            }

            return new ResponseEntity<Map<String, String>>(errorMap, HttpStatus.BAD_REQUEST);
        }

        ListOfProduct newListOfProduct = listOfProductService.saveOrUpdateListOfProduct(listOfProduct);
        return new ResponseEntity<ListOfProduct>(newListOfProduct, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public Iterable<ListOfProduct> getAllListOfProducts(){
        return listOfProductService.findAll();
    }

    @GetMapping("/{list_of_product_id}")
    public ResponseEntity<?> getListOfProductById(@PathVariable Long list_of_product_id){
        ListOfProduct listOfProduct = listOfProductService.findById(list_of_product_id);
        return new ResponseEntity<ListOfProduct>(listOfProduct, HttpStatus.OK);
    }

    @PutMapping("/{list_of_product_id}")
    public ResponseEntity<?> putListOfProductById(@RequestBody ListOfProduct listOfProduct){
        ListOfProduct newListOfProduct = listOfProductService.saveOrUpdateListOfProduct(listOfProduct);
        return new ResponseEntity<ListOfProduct>(newListOfProduct, HttpStatus.OK);
    }

    @DeleteMapping("/{list_of_product_id}")
    public ResponseEntity<?> deleteListOfProductById(@PathVariable Long list_of_product_id){
        listOfProductService.deleteById(list_of_product_id);
        return new ResponseEntity<String>("List Of Product deleted", HttpStatus.OK);
    }
}
