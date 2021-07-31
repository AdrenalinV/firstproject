package ru.geekbrains.firstproject.services;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.firstproject.exceptions.ResourceNotFoundException;
import ru.geekbrains.firstproject.model.entities.OrderItem;
import ru.geekbrains.firstproject.model.entities.Product;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class BasketService {
    private final ProductService productService;
    private List<OrderItem> basket;
    private double totalPrice;

    @PostConstruct
    public void init() {
        this.basket = new ArrayList<>();
    }

    public void addBasket(Long product_Id) {
        for (OrderItem o : basket) {
            if (o.getProduct().getId().equals(product_Id)) {
                o.incrementQuantity();
                recalculate();
                return;
            }
        }
        Product p = productService.findProductById(product_Id).orElseThrow(() -> new ResourceNotFoundException("Unable to find product with id: " + product_Id + " (add to basket"));
        OrderItem o = new OrderItem(p);
        basket.add(o);
        recalculate();
    }

    public void decBasketProduct_Id(Long product_Id) {
        for (OrderItem o : basket) {
            if (o.getProduct().getId().equals(product_Id) && o.getQuantity() > 0) {
                o.decrementQuantity();
                recalculate();
                return;
            }
        }
    }

    public void cleanBasket() {
        if (!this.basket.isEmpty()) {
            this.basket.clear();
        }
        recalculate();
    }

    private void recalculate() {
        totalPrice = 0;
        for (OrderItem o : basket) {
            totalPrice += o.getPricePerProduct();
        }
    }
}
