package com.jb.SpringEcom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jb.SpringEcom.model.Product;
import com.jb.SpringEcom.repo.ProductRepo;
import com.jb.SpringEcom.service.ProductService;
@Service
public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
}