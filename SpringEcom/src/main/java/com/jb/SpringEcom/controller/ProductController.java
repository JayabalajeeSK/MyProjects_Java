package com.jb.SpringEcom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping("/api")
public class ProductController {
    @GetMapping("/products")
    public String getProducts()
    {
        return "All Products";
    }
}