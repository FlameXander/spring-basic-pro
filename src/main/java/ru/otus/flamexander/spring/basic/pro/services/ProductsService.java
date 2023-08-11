package ru.otus.flamexander.spring.basic.pro.services;

import ru.otus.flamexander.spring.basic.pro.dtos.ProductDtoRq;
import ru.otus.flamexander.spring.basic.pro.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<Product> getAll();
    List<Product> getPageAsList(int realPageIndex, int pageSize);
    Optional<Product> getById(Long id);
    void deleteById(Long id);
    Product save(Product product);
    Product update(ProductDtoRq productDtoRq);
    Product createNew(ProductDtoRq productDtoRq);
}
