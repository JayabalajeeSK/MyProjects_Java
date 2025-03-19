package com.jb.SpringEcom.controller;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
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

///// get product by id
    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") int id)
    {
        Product product =  productService.getProductById(id);
        if(product.getId() > 0) { return new ResponseEntity<>(product, HttpStatus.OK); }
        else { return new ResponseEntity<>(product, HttpStatus.NOT_FOUND); }
    }

///// Add product
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile imageFile ) //@RequestBody//
    {
        Product savedProduct;
        try 
        {
            savedProduct = productService.addProduct(product, imageFile);
            return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
        } 
        catch (IOException e) 
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
///// get products image
    @GetMapping("/product/{productId}/image") // from React UI
    public ResponseEntity<byte[]> getImageByProductId(@PathVariable int productId)
    {
        Product product = productService.getProductById(productId);
        return new ResponseEntity<>(product.getImageData(), HttpStatus.OK);
        
    }
///// Update Product by id
    @PutMapping("/product/{id}") // from React UI
    public ResponseEntity<String> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile)
    {
        Product updatedProduct = null;
        try 
        {
            updatedProduct = productService.UpdateProduct(product, imageFile);
            return new ResponseEntity<>("Updated", HttpStatus.OK);
        } 
        catch (IOException e) 
        {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    ///// Update Product by id
    @DeleteMapping("/product/{id}") // from React UI
    public ResponseEntity<String> deleteProduct(@PathVariable int id)
    {
        Product product = productService.getProductById(id);
        if (product!=null) 
        {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
    }
}