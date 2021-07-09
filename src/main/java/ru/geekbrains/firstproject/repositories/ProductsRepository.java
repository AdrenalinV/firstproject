package ru.geekbrains.firstproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.firstproject.entities.Product;

import java.util.List;


@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
    public List<Product> findByCostAfter(double min);
    public List<Product> findByCostBefore(double max);
    public List<Product> findByCostBetween(double min, double max);
    public List<Product> findByTitleIgnoreCaseLike(String title);

}
