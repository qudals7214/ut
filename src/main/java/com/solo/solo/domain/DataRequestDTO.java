package com.solo.solo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DataRequestDTO {
    String firstCategory, secondCategory , thirdCategory , name  , currency ;
    String brand, url , notificationList ,id;

    int price, card , cash , lowestPrice , shipping , quantity , totalPrice ;
    int marketPrice;

    Date purchaseDate , date;
}
