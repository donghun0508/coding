package com.seowon.coding.controller;

import java.util.List;

public record OrderPlaceRequest(
    String customerName, String customerEmail, List<Long> productIds, List<Integer> quantities
) {

}
