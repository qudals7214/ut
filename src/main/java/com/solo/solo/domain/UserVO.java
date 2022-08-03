package com.solo.solo.domain;


import com.solo.solo.util.TimeStamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "users")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserVO extends TimeStamp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //IDENTITY 전략 사용
    private Long key;

    @Column(name="id" , nullable = false)
    private String id;

    @Column(name="name" , nullable = true)
    private String name;


    @Column(name ="platform" , nullable = false)
    private String platform;

    public UserVO(String id , String name ,String platform){
        this.id=id;
        this.name=name;
        this.platform=platform;
    }

    public UserVO(UserRequestDTO userRequestDTO){
        this.id=userRequestDTO.getId();
        this.platform= userRequestDTO.getPlatform();
        this.name= userRequestDTO.getName();
    }
//
//    public void update(UserRequestDTO userRequestDTO){
//        this.name= userRequestDTO.getName();
////        this.pw= userRequestDTO.getPw();
//    }


}
