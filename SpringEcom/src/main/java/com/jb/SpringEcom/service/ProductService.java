package com.jb.SpringEcom.service;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.jb.SpringEcom.model.Product;
public interface ProductService  {
    List<Product> getAllProducts();

    Product getProductById(int id);

    Product addProduct(Product product, MultipartFile image) throws IOException;
}
