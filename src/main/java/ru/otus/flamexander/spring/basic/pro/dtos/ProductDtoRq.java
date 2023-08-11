package ru.otus.flamexander.spring.basic.pro.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDtoRq {
    private Long id;
    private String title;
    private int price;
}
