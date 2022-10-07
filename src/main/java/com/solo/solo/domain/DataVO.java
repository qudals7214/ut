package com.solo.solo.domain;

import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

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

    Date date;

    String resultDate1;
    String resultDate2;





    public DataVO(String item , int price , String date) throws ParseException {
//        this.resultDate=date;


        SimpleDateFormat sdfymd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdfhms = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(date.contains("-"))
        this.date = sdfymd.parse(date);

        else{
            LocalDate localDate = LocalDate.now();
            System.out.println("로컬데이트 나우 : " +localDate);
            this.date = sdfhms.parse(localDate+" "+date);
        }

//        String sdate = sdf.format(date);



        this.item=item;
        this.price=price;
        System.out.println("data vo 날짜 : " + date);
        System.out.println("data vo 날짜 : " + date);
    }

    public void resultDate(){

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yy년 MM월 dd일");
        //원하는 데이터 포맷 지정
        String strNowDate = simpleDateFormat.format(date);
        //지정한 포맷으로 변환
        System.out.println("포맷 지정 후 : " + strNowDate);
        this.resultDate2=strNowDate;
    }




    @Override
    public int compare(DataVO a, DataVO b) {
        return a.date.compareTo(b.date);
    }

    public int sort(DataVO o2){
        return date.compareTo(o2.getDate());
    }

//    public int compare(DataVO o2) {
//        return o2.resultDate;
//    }

//    public int compare(DataVO o2) {
//    }
}
