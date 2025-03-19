package com.jb.SpringEcom.service;
import java.util.List;
import com.jb.SpringEcom.model.Product;
public interface ProductService  {
    List<Product> getAllProducts();

    Product getProductById(int id);


}
