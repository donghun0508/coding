package com.seowon.coding.domain.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DefaultProductPriceChange implements ProductPriceChange {

    @Override
    public BigDecimal calculate(double base, double percentage, boolean includeTax) {
        double changed = base + (base * (percentage / 100.0));
        if (includeTax) {
            changed = changed * 1.1;
        }
        return BigDecimal.valueOf(changed).setScale(2, RoundingMode.HALF_UP);
    }
}
