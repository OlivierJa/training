package com.ecommerce.microcommerce.controller;

import com.ecommerce.microcommerce.dao.ProductDao;
import com.ecommerce.microcommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductDao productDao;

    //Product
    @GetMapping(value = "Product")
    public List<Product> showAllProducts(){
        return productDao.findAll();
    }



    //Product/{id}
    @GetMapping(value = "Product/{id}")
    public Product showAProduct(@PathVariable int id) {
        return productDao.findById(id);
    }

    @PostMapping(value = "Product")
    public ResponseEntity<Void> addProduct(@RequestBody Product product){
        Product product1 = productDao.save(product);

        if (product == null) {
            return ResponseEntity.noContent().build(); //build permet dee creer la reponse et de la renvoyer
        }

        //permet de creer un lien a partir d'une requete
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(product1.getId())
                        .toUri();

         return ResponseEntity.created(location).build();
    }



}
