package com.seowon.coding.config;

import com.seowon.coding.domain.model.DefaultProductPriceChange;
import com.seowon.coding.domain.model.ProductPriceChange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public ProductPriceChange productPriceChange() {
        return new DefaultProductPriceChange();
    }

}
