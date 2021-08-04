package ru.geekbrains.firstproject.model.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "order_items")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price_per_product")
    private double pricePerProduct;

    @Column(name = "price")
    private double price;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public OrderItem (Product product){
        this.product=product;
        this.quantity=1;
        this.pricePerProduct=product.getCost();
        this.price=this.pricePerProduct;
    }

    public void incrementQuantity(){
        quantity++;
        pricePerProduct=price*quantity;
    }

    public void decrementQuantity(){
        quantity--;
        pricePerProduct=price*quantity;
    }
}
