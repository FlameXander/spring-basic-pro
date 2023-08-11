package ru.otus.flamexander.spring.basic.pro.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.flamexander.spring.basic.pro.dtos.ProductDtoRq;
import ru.otus.flamexander.spring.basic.pro.entities.Product;
import ru.otus.flamexander.spring.basic.pro.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductsServiceImpl implements ProductsService {
    private final ProductsRepository productsRepository;

    @Override
    public List<Product> getAll() {
        return productsRepository.findAll();
    }

    @Override
    public List<Product> getPageAsList(int realPageIndex, int pageSize) {
        return productsRepository.findAll(PageRequest.of(realPageIndex - 1, pageSize)).getContent();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productsRepository.findById(id);
    }

    @Override
    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    @Override
    public Product save(Product product) {
        return productsRepository.save(product);
    }

    @Transactional
    @Override
    public Product update(ProductDtoRq productDtoRq) {
        Product product = productsRepository.findById(productDtoRq.getId()).get();
        product.setPrice(productDtoRq.getPrice());
        product.setTitle(productDtoRq.getTitle());
        return save(product);
    }

    @Override
    public Product createNew(ProductDtoRq productDtoRq) {
        Product product = new Product();
        product.setPrice(productDtoRq.getPrice());
        product.setTitle(productDtoRq.getTitle());
        return save(product);
    }
}