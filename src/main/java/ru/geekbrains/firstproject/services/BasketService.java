package ru.geekbrains.firstproject.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@Service
@RequiredArgsConstructor
public class BasketService {
    private TreeMap<Long, Integer> basket;

    @PostConstruct
    public void init(){
        this.basket=new TreeMap<>();
        addBasket(1L);
        addBasket(3L);
    }

    public void addBasket(Long product_Id) {
        if (this.basket.containsKey(product_Id)) {
            this.basket.put(product_Id, this.basket.get(product_Id) + 1);
        } else {
            this.basket.put(product_Id, 1);
        }
    }

    public void decBasketProduct_Id(Long product_Id) {
        if (this.basket.containsKey(product_Id) && this.basket.get(product_Id) > 1) {
            this.basket.put(product_Id, this.basket.get(product_Id) - 1);
        } else {
            this.basket.remove(product_Id);
        }
    }

    public void cleanBasket(){
        if(!this.basket.isEmpty()){
            this.basket.clear();
        }
    }
    public Map<Long, Integer> getBasket(){
        return  Collections.unmodifiableMap(this.basket);
    }
}
