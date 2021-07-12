package ru.geekbrains.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.firstproject.entities.Product;
import ru.geekbrains.firstproject.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductService productService;

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return this.productService.findProductById(id).get();
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable Long id) {
        this.productService.deleteProductById(id);
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return this.productService.addProduct(product);
    }

    @GetMapping
    public List<Product> getFilterProductByCost(
            @RequestParam(name="min_cost",defaultValue = "0") Double min,
            @RequestParam(name="max_cost", required = false) Double max
    ) {
        if(max==null){
            max=Double.MAX_VALUE;
        }
        return this.productService.findProductByCost(min,max);
    }
    @GetMapping("/filter_title")
    public List<Product> getFilterProductByTitle(@RequestParam String title){
        return this.productService.findProductByTitleLike(title);
    }


}
