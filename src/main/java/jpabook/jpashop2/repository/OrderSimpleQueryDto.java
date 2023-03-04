package jpabook.jpashop2.repository;

import jpabook.jpashop2.domain.Address;
import jpabook.jpashop2.domain.Order;
import jpabook.jpashop2.domain.OrderStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class OrderSimpleQueryDto {

    private Long orderId;
    private String name;
    private LocalDateTime orderDate;
    private OrderStatus orderStatus;
    private Address address;

    public OrderSimpleQueryDto(Long orderId, String name, LocalDateTime orderDate, OrderStatus orderStatus, Address address) {
        this.orderId = orderId;
        this.name = name;//Lazy 초기화 (영속성 컨텍스트에 없으면 db에 쿼리 날림)
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
        this.address = address; //Lazy 초기화
    }

}
