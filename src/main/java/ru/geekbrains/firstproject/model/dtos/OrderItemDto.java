package ru.geekbrains.firstproject.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.firstproject.model.entities.OrderItem;

@Data
@NoArgsConstructor
public class OrderItemDto {
    private String productTitle;
    private int quantity;
    private double pricePerProduct;
    private double price;


    public OrderItemDto(OrderItem o) {
        this.productTitle = o.getProduct().getTitle();
        this.quantity = o.getQuantity();
        this.pricePerProduct = o.getPricePerProduct();
        this.price = o.getPrice();
    }
}
