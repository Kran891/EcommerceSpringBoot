package com.kran.commerce.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kran.commerce.entities.Product;
import com.kran.commerce.services.interfaces.IProductService;





@RestController
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;
    public ProductController(IProductService productService) {
        this.productService = productService;
    }
    
    
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable int id) {
        productService.Delete(id);
        return "Deleted Product With Id -"+id;
    }
    @PostMapping("")
    public Product Save(@RequestBody Product entity) {
        return  productService.Save(entity);
    }
    @PutMapping("/")
    public Product Update(@RequestBody Product entity) {
        return productService.Update(entity);
    }
    @GetMapping("/{id}")
    public Product FindById(@PathVariable int id) {
       return productService.FindById(id);
    }
    @GetMapping("/category/{cId}")
    public List<Product> FindByCategory(@PathVariable int cId) {
        return productService.FindByCategory(cId);
    }
    
}
