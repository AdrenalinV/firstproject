package ru.geekbrains.firstproject.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.firstproject.entities.Product;
import ru.geekbrains.firstproject.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductsRepository productsRepository;

    public Optional<Product> findProductById(Long id) {
        return this.productsRepository.findById(id);
    }

    public List<Product> findProductAll() {
        return (List<Product>) this.productsRepository.findAll();

    }

    public List<Product> findProductByCost(double minCost, double maxCost) {
        return this.productsRepository.findByCostBetween(minCost, maxCost);
    }

    public void deleteProductById(Long id) {
        this.productsRepository.deleteById(id);
    }

    public Product addProduct(Product p) {
        return this.productsRepository.save(p);
    }

    public List<Product> findProductByTitleLike(String title) {
        return this.productsRepository.findByTitleIgnoreCaseLike('%' + title + '%');
    }
}
