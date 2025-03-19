package com.jb.SpringEcom.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jb.SpringEcom.model.Product;
@Repository
public interface ProductRepo extends JpaRepository<Product, Integer>{

}