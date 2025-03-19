package com.jb.SpringEcom.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/products")
    public List<Product> getProducts()
    {
        return productService.getAllProducts();
    }
}