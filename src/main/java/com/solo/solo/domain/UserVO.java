package com.solo.solo.domain;


import com.solo.solo.util.TimeStamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
@Entity(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserVO extends TimeStamp {

    @Id
    private String id;

    @Column(name="pw" , nullable = false)
    private String pw;

    @Column(name="name" , nullable = false)
    private String name;

    public UserVO(UserRequestDTO userRequestDTO){
        this.id=userRequestDTO.getId();
        this.pw= userRequestDTO.getPw();
        this.name= userRequestDTO.getName();
    }

    public void update(UserRequestDTO userRequestDTO){
        this.name= userRequestDTO.getName();
        this.pw= userRequestDTO.getPw();
    }


}
