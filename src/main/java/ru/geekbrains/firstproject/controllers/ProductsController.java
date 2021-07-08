package ru.geekbrains.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.firstproject.entities.Product;
import ru.geekbrains.firstproject.repositories.ProductsRepository;

import java.util.List;

@RestController
@RequestMapping ("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsRepository productsRepository;

    @GetMapping
    public List<Product> getAllProduct(){
        return (List<Product>) productsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        return productsRepository.findById(id).get();
    }

    @GetMapping("/delete/{id}")
    public void deleteProductById(@PathVariable Long id){
        productsRepository.deleteById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productsRepository.save(product);
    }


}
