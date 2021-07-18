package ru.geekbrains.firstproject.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.firstproject.model.entities.Product;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private double cost;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.cost = p.getCost();
    }
}
