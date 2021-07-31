package ru.geekbrains.firstproject.model.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.firstproject.services.BasketService;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class BasketDto {
    private List<OrderItemDto> items;
    private double totalPrice;

    public BasketDto(BasketService basket) {
        this.totalPrice = basket.getTotalPrice();
        this.items = basket.getBasket().stream().map(OrderItemDto::new).collect(Collectors.toList());
    }
}
