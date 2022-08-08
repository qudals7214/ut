package com.solo.solo.crawling.search;


import com.solo.solo.crawling.cut.RandomUserAgent;
import com.solo.solo.domain.DataVO;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class QuasarzoneTemporaryCrawling{

    private static final Logger log = LoggerFactory.getLogger(QuasarzoneTemporaryCrawling.class);
    private static final int FIRST_PAGE_INDEX = 1;
    private static final int LAST_PAGE_INDEX = 1;
    private static final String PLATFORM = "Quasarzone";


    public List<DataVO> search(String search) {
        List<DataVO> result = new ArrayList<>();



        int year = LocalDate.now().getYear();
        LocalDate localDate = LocalDate.now();
        int mon1 = localDate.getMonthValue();
        boolean first = true;
        boolean end = false;

        String[] check1 = new String[1];
        String[] check2 = new String[1];


        try {
            for (int i = FIRST_PAGE_INDEX; i <= LAST_PAGE_INDEX; i++) {
                final String startUrl = "https://quasarzone.com/bbs/qb_tsy?_method=post&kind=subject%7C%7Ccontent&keyword="+search+"&sort=num%2C%20reply&direction=DESC&page="+i;

                Connection conn = Jsoup.connect(startUrl);
                conn.userAgent("Chrome");


                Document document = conn.get();

                Elements titleElements = document.select("a.subject-link > span.ellipsis-with-reply-cnt");
                Elements infoElements = document.select("div.market-info-sub > p");
                Elements priceElements = document.select("div.market-info-sub p span span");
                Elements regdateElements = document.select("p > span.date");


                if(first){
                    check1 = new String[titleElements.size()];
                    check2 = new String[titleElements.size()];
                    first=false;
                }

                for (int j = 0; j < titleElements.size(); j++) {
                    final String title = titleElements.get(j).text();
                    final String info = infoElements.get(j).text();
                    final String price = priceElements.get(j).text();
                    String price2 = price.replaceAll("[^0-9]", "");
                    if(price2.equals("")){
                        break;
                    }
                    int realIntPrice = Integer.parseInt(price2);
                    final String regdate = removeWhiteSpace(regdateElements.get(j).text());

                    String date= "";


                    if(j>0){
                        String before = removeWhiteSpace(regdateElements.get(j-1).text());
                        String[] cut1 = before.split("-");
                        String[] today = cut1[0].split(":");

                        mon1 = Integer.parseInt(today[0]);
                    }


                    String[] cut2 = regdate.split("-");

                    int mon2 = mon1;
                    if(cut2.length>1){
                        mon2 = Integer.parseInt(cut2[0]);
                    }
                    if(mon1<mon2){
                        year--;
                    }

                    date = year+"-"+mon1+"-"+cut2[0];

                    if(cut2.length>1){
                        date = year+"-"+mon2+"-"+cut2[1];
                    }



                    mon1=mon2;


                    System.out.println("퀘이사존 임시 크롤링");
                    System.out.println("제목: " + title);
                    System.out.println("인포: " + info);
                    System.out.println("가격: " + price);
                    System.out.println("가격 int : " + realIntPrice);
                    System.out.println("날짜: " + date);

                    check1[j]=title;



                    DataVO data = new DataVO(title,realIntPrice,date);
                    result.add(data);




                    int n=0;
                    for(String check : check1){
                        if(!check.equals(check2))
                            break;

                        n++;
                    }

                    if(n== titleElements.size()){
                        end = true;
                        break;
                    }
                }
                if(end)
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return result;
    }

    private static String getRealPrice(final String price) {
        final String[] pricesArray = price.split(" ");
        return pricesArray[1];
    }

    private static String getSalePrice(final String price) {
        final String[] pricesArray = price.split(" ");
        return (pricesArray.length == 1) ? price : pricesArray[1];
    }

    // html 태그 제거
    private static String stripHtml(final String html) {
        return Jsoup.clean(html, Whitelist.none());
    }

    // 맨 앞, 맨 뒤 소괄호 제거
    private static String removeBracket(final String str) {
        return str.replaceAll("^[(]|[)]$", "");
    }

    private static String getSessionCount(final String course) {
        return removeNotNumeric(course.substring(0, course.indexOf("개")));
    }

    private static String removeNotNumeric(final String str) {
        return str.replaceAll("\\W", "");
    }

    private static String removeWhiteSpace(final String str) {
        return str.replaceAll("\\s", "");
    }

    private static int toInt(final String str) {
        return Integer.parseInt(str);
    }

    private static float toFloat(final String str) {
        return Float.parseFloat(str);
    }

}
