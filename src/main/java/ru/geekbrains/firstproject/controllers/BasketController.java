package ru.geekbrains.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.firstproject.model.dtos.BasketDto;
import ru.geekbrains.firstproject.services.BasketService;


@RestController
@RequestMapping("/api/v1/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;

    // Получить корзину
    @GetMapping
    public BasketDto getBasketAll() {
        return new BasketDto(basketService);
    }

    // Увеличить кол-во в корзине
    @GetMapping("/add/{product_id}")
    public void addProductIdInBasket(@PathVariable Long product_id) {
        this.basketService.addBasket(product_id);
    }

    // очистить корзину
    @GetMapping("/clear")
    public void delAllProductInBasket() {
        this.basketService.cleanBasket();
    }

    // Уменьшить кол-во в корзине
    @GetMapping("/dec/{product_id}")
    public void decProductIdInBasket(@PathVariable Long product_id) {
        this.basketService.decBasketProduct_Id(product_id);
    }

}
