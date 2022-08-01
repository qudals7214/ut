package com.solo.solo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "purchaseList")
@Entity(name = "purchaseList")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataPurchaseListVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY 전략 사용
    private Long key;

    @Column(name="name" , nullable = false)
    private String name;

    @Column(name="price" , nullable = false)
    private int price;

    @Column(name="quantity" , nullable = false)
    private int quantity;

    @Column(name="shipping" , nullable = false)
    private int shipping;

    @Column(name="totalPrice" , nullable = false)
    private int totalPrice;

    @Column(name="marketPrice" , nullable = false)
    private int marketPrice;

    @Column(name="purchaseDate" , nullable = false)
    private Date purchaseDate;

    @Column(name="id" , nullable = false)
    private String id;

    @Column(name="notificationList" , nullable = false)
    private String notificationList;

}
