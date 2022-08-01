package com.solo.solo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;


@Table(name = "lowestPrice")
@Entity(name = "lowestPrice")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataLowestPriceVO {
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

    @Column(name="date" , nullable = false)
    private Date date;

    @Column(name="card" , nullable = false)
    private int card;

    @Column(name="cash" , nullable = false)
    private int cash;

    @Column(name="lowestPrice" , nullable = false)
    private int lowestPrice;

    @Column(name="url" , nullable = false)
    private String url;

    @Column(name="shipping" , nullable = false)
    private int shipping;
}
