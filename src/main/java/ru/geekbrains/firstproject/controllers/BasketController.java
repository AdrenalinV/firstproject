package ru.geekbrains.firstproject.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.firstproject.services.BasketService;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/basket")
@RequiredArgsConstructor
public class BasketController {
    private final BasketService basketService;
    // Получить корзину
    @GetMapping
    public Map<Long, Integer> getBasketAll(){
        return this.basketService.getBasket();
    }
    // Увеличить кол-во в корзине
    @GetMapping("/{product_id}")
    public void addProductIdInBasket(@PathVariable Long product_id){
        this.basketService.addBasket(product_id);
    }
    // очистить корзину
    @DeleteMapping
    public void delAllProductIdInBasket(){
        this.basketService.cleanBasket();
    }
    // Уменьшить кол-во в корзине
    @DeleteMapping("/{product_id}")
    public void decProductIdInBasket(@PathVariable Long product_id){
        this.basketService.decBasketProduct_Id(product_id);
    }

}
