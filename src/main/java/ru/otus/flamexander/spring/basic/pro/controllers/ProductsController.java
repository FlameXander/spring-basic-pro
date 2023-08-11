package ru.otus.flamexander.spring.basic.pro.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;
import ru.otus.flamexander.spring.basic.pro.converters.ProductsConverter;
import ru.otus.flamexander.spring.basic.pro.dtos.ProductDtoRq;
import ru.otus.flamexander.spring.basic.pro.dtos.ProductDtoRs;
import ru.otus.flamexander.spring.basic.pro.entities.Product;
import ru.otus.flamexander.spring.basic.pro.exceptions.ResourceNotFoundException;
import ru.otus.flamexander.spring.basic.pro.services.ProductsService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductsController {
    private final ProductsConverter productsConverter;
    private final ProductsService productsService;

    @GetMapping("/{id}")
    public ProductDtoRs getById(@PathVariable Long id) {
        Product product = productsService.getById(id).orElseThrow(() -> new ResourceNotFoundException("Продукт с id = " + id + " не найден"));
        return productsConverter.entityToDto(product);
    }

    @GetMapping
    public List<ProductDtoRs> getAll(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "5") int pageSize) {
        return productsService.getPageAsList(page, pageSize).stream().map(productsConverter::entityToDto).collect(Collectors.toList());
    }

    @PostMapping
    public ProductDtoRs createNew(@RequestBody ProductDtoRq productDtoRq) {
        Product product = productsService.createNew(productDtoRq);
        return productsConverter.entityToDto(product);
    }

    @PutMapping
    public ProductDtoRs update(@RequestBody ProductDtoRq productDtoRq) {
        Product product = productsService.update(productDtoRq);
        return productsConverter.entityToDto(product);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productsService.deleteById(id);
    }
}
