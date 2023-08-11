package ru.otus.flamexander.spring.basic.pro.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.otus.flamexander.spring.basic.pro.entities.Product;

@Repository
public interface ProductsRepository extends JpaRepository<Product, Long> {
}