package com.seowon.coding.controller;

import com.seowon.coding.domain.model.Order;
import java.util.List;

public record OrderPlaceResponse(String customerName, String customerEmail, List<OrderItemResponse> products) {

    public static OrderPlaceResponse of(Order order) {
        return new OrderPlaceResponse(
            order.getCustomerName(),
            order.getCustomerEmail(),
            order.getItems().stream().map(OrderItemResponse::of).toList()
        );
    }
}
