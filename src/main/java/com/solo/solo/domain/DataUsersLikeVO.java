package com.solo.solo.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "usersLike")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DataUsersLikeVO {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY 전략 사용
    private Long key;

    @Column(name="id" , nullable = false)
    private String id;

    @Column(name ="platform" , nullable = false)
    private String platform;

    @Column(name="item" , nullable = false)
    private String item;

    @Column(name="defaultPrice" , nullable = false)
    private int defaultPrice;

    @Column(name="setPrice" , nullable = false)
    private int setPrice;


    public DataUsersLikeVO(String id  ,String platform , String item , int defaultPrice , int setPrice){
        this.id=id;
        this.item=item;
        this.platform=platform;
        this.defaultPrice=defaultPrice;
        this.setPrice=setPrice;
    }
//    public DataUsersLikeVO(DataRequestDTO dataRequestDTO){
//        this.id=dataRequestDTO.getId();
//        this.item=dataRequestDTO.getItem();
//        this.platform=dataRequestDTO.getPlatform();
//        this.defaultPrice=dataRequestDTO.getDefaultPrice();
//        this.setPrice=dataRequestDTO.getSetPrice();
//    }
}
