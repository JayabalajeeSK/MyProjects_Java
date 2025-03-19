package com.jb.SpringEcom.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jb.SpringEcom.model.Product;
import com.jb.SpringEcom.service.ProductService;
//import com.jb.SpringEcom.service.impl.ProductServiceImplementation;

@Controller
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:5173/")
public class ProductController {
    @Autowired
    private ProductService productService;
///// get all products
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getAllProducts()
    {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

///// get all products
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id)
    {
        Product product =  productService.getProductById(id);
        if(product.getId() > 0) { return new ResponseEntity<>(product, HttpStatus.OK); }
        else { return new ResponseEntity<>(product, HttpStatus.NOT_FOUND); }
    }
}