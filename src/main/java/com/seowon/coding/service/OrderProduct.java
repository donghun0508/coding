package com.seowon.coding.service;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
public class OrderProduct {
    private Long productId;
    private Integer quantity;

    public OrderProduct(Long productId, int qty) {
        if (qty <= 0) {
            throw new IllegalArgumentException("quantity must be positive: " + qty);
        }
        this.productId = productId;
        this.quantity = qty;
    }
}