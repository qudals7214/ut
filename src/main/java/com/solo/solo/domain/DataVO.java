package com.solo.solo.domain;

import lombok.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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


        SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(date.contains("-"))
        this.resultDate = sdfymd.parse(date);

        else{
            LocalDate localDate = LocalDate.now();
            System.out.println("로컬데이트 나우 : " +localDate);
            this.resultDate = sdfhms.parse(localDate+" "+date);
        }

//        String sdate = sdf.format(date);



        this.item=item;
        this.price=price;
        System.out.println("data vo 날짜 : " + date);
        System.out.println("data vo 날짜 : " + resultDate);
    }






    @Override
    public int compare(DataVO a, DataVO b) {
        return a.resultDate.compareTo(b.resultDate);
    }

    public int sort(DataVO o2){
        return resultDate.compareTo(o2.getResultDate());
    }

//    public int compare(DataVO o2) {
//        return o2.resultDate;
//    }

//    public int compare(DataVO o2) {
//    }
}
