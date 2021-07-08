package ru.geekbrains.firstproject.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.firstproject.entities.Product;


@Repository
public interface ProductsRepository extends CrudRepository<Product, Long> {

}
