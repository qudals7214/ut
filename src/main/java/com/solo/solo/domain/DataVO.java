package com.solo.solo.domain;

import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Getter
//@Setter
@Data
public class DataVO implements Comparator<DataVO> {
//    String date;
    String item;
    int price;

    Date resultDate;





    public DataVO(String item , int price , String date) throws ParseException {
//        this.resultDate=date;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        this.resultDate = sdf.parse(date);
        this.item=item;
        this.price=price;
    }






    @Override
    public int compare(DataVO a, DataVO b) {
        return a.resultDate.compareTo(b.resultDate);
    }
}
