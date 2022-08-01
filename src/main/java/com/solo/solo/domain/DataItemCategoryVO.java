package com.solo.solo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Table(name = "itemCategory")
@Entity(name = "itemCategory")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataItemCategoryVO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY 전략 사용
    private Long key;

    @Column(name="firstCategory" , nullable = false)
    private String firstCategory;

    @Column(name="secondCategory" , nullable = false)
    private String secondCategory;

    @Column(name="thirdCategory" , nullable = false)
    private String thirdCategory;

    @Column(name="name" , nullable = false)
    private String name;

    @Column(name="price" , nullable = false)
    private int price;

    @Column(name="currency" , nullable = false)
    private String currency;

    @Column(name="brand" , nullable = false)
    private String brand;
}
