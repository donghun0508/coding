package com.seowon.coding.domain.model;

import java.math.BigDecimal;

public interface ProductPriceChange {

    BigDecimal calculate(double base, double percentage, boolean includeTax);
}
