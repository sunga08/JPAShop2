package jpabook.jpashop2.service;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateItemDto {

    private int price;
    private String name;
    private int stockQuantity;
}
