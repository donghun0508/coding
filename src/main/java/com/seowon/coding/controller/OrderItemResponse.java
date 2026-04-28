package com.seowon.coding.controller;

import com.seowon.coding.domain.model.OrderItem;

public record OrderItemResponse(
    Long productId, int quantity
) {

    public static OrderItemResponse of(OrderItem orderItem) {
        return new OrderItemResponse(orderItem.getProduct().getId(), orderItem.getQuantity());
    }
}
