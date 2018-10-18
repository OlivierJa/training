package com.ecommerce.microcommerce.dao;

import com.ecommerce.microcommerce.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImplementation implements ProductDao {

    public static List<Product> products = new ArrayList<>();

    static {

        products.add(new Product(1, new String ("ordinateur portable"), 1000, 200));
        products.add(new Product(2, new String ("Aspirateur robot "), 200, 450));
        products.add(new Product(3, new String ("Lave-linge "), 1500, 300));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
           if (product.getId() == id)
               return product;
        }
        return null;
    }

    @Override
    public Product save(Product product) {
        products.add(product);
        return product;
    }
}
