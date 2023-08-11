package ru.otus.flamexander.spring.basic.pro.converters;

import org.springframework.stereotype.Component;
import ru.otus.flamexander.spring.basic.pro.dtos.ProductDtoRs;
import ru.otus.flamexander.spring.basic.pro.entities.Product;

@Component
public class ProductsConverter {
    public ProductDtoRs entityToDto(Product product) {
        return new ProductDtoRs(
                product.getId(),
                product.getTitle(),
                product.getPrice()
        );
    }
}
