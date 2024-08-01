package com.bezkoder.spring.datajpa.controller;

import com.bezkoder.spring.datajpa.model.Product;
import com.bezkoder.spring.datajpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
@CrossOrigin
public class ProductController {

    @Autowired
    ProductRepository productRepository;


    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return new ResponseEntity<>("Hello ",HttpStatus.OK);
    }

    //ADD A NEW PRODUCT TO THE INVENTORY
    @PostMapping("/products")
    public ResponseEntity<String> createProduct(@RequestBody Product product)
    {
        productRepository.save(product);
        return new ResponseEntity<>("Product Saved success", HttpStatus.CREATED);
    }

    //SEARCH A NEW PRODUCT FROM THE INVENTORY
    @GetMapping("/products")
    public ResponseEntity<List<Product>> searchProduct(@RequestParam(required = false) String name){
        List<Product> products;
        if(name != null){
            products =  productRepository.findAllByProductNameContains(name);
            return new ResponseEntity<>(products,HttpStatus.OK);
        }
        products = productRepository.findAll();
        return new ResponseEntity<>(products,HttpStatus.OK);

    }

    //DELETE PRODUCT
    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Integer productId){
        try{
            productRepository.deleteById(productId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //UPDATE PRODUCT
    @PutMapping("/products/{productId}")
    public ResponseEntity<String> updateProduct(@PathVariable Integer productId, @RequestBody Product productRequest){
        try{
           Product existingProduct  = productRepository.findById(productId).get();
           existingProduct.setProductName(productRequest.getProductName());
            existingProduct.setProductPrice(productRequest.getProductPrice());
            existingProduct.setProductQty(productRequest.getProductQty());
            productRepository.save(existingProduct);
            return new ResponseEntity<>("Update successfull",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.toString(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
