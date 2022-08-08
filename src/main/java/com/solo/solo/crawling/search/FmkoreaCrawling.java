package com.solo.solo.crawling.search;


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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class FmkoreaCrawling{

    private static final Logger log = LoggerFactory.getLogger(FmkoreaCrawling.class);
    private static final int FIRST_PAGE_INDEX = 1;
    private static final int LAST_PAGE_INDEX = 1;
    private static final String PLATFORM = "Fmkorea";


    public List<DataVO> search(String search) {
        List<DataVO> result = new ArrayList<>();

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int mon1 = localDate.getMonthValue();
        boolean first = true;
        boolean end = false;

        String[] check1 = new String[1];
        String[] check2 = new String[1];


        try {
            for (int i = FIRST_PAGE_INDEX; i <= LAST_PAGE_INDEX; i++) {
                final String startUrl = "https://www.fmkorea.com/index.php?mid=hotdeal&listStyle=webzine&search_keyword="+search+"&search_target=title_content&page=" + i;

                Connection conn = Jsoup.connect(startUrl);
                conn.userAgent("Chrome");
                Document document = conn.get();


                Elements titleElements = document.select("div.li > h3.title > a");
                Elements infoElements = document.select("div.li > div.hotdeal_info");
                Elements priceElements = document.select("div.li > div.hotdeal_info :nth-child(2)");
                Elements regdateElements = document.select("div > span.regdate");


                if(first){
                    check1 = new String[titleElements.size()];
                    check2 = new String[titleElements.size()];
                    first=false;
                }

                for (int j = 0; j < titleElements.size(); j++) {
                    final String title = titleElements.get(j).text();
                    final String info = infoElements.get(j).text();
                    final String price = infoElements.get(j).select("span:nth-child(2)").text();

                    String price2 = price.replaceAll("[^0-9]", "");

                    if(price2.equals("")){
                        break;
                    }

                    int realIntPrice = Integer.parseInt(price2);
                    if (price.contains("만")){
                        realIntPrice= realIntPrice*10000;
                    }

                    if (price.contains("."))
                        realIntPrice = realIntPrice/10;

                    final String regdate = removeWhiteSpace(regdateElements.get(j).text());

                    String date= regdate.replaceAll("[.]","-");



                    if(regdate.contains(":"))
                        date = String.valueOf(localDate);


//                    if(j>0){
//                        String before = removeWhiteSpace(regdateElements.get(j-1).text());
//                        String[] cut1 = before.split("-");
//                        String[] today = cut1[0].split(":");
//
//                        mon1 = Integer.parseInt(today[0]);
//                    }
//
//
//                    String[] cut2 = regdate.split("-");
//
//                    int mon2 = mon1;
//                    if(cut2.length>1){
//                        mon2 = Integer.parseInt(cut2[0]);
//                    }
//                    if(mon1<mon2){
//                        year--;
//                    }
//
//                    date = year+"-"+mon1+"-"+cut2[0];
//
//                    if(cut2.length>1){
//                        date = year+"-"+mon2+"-"+cut2[1];
//                    }



//                    mon1=mon2;


                    System.out.println("FM 크롤링");
                    System.out.println("제목: " + title);
                    System.out.println("인포: " + info);
                    System.out.println("가격: " + price);
                    System.out.println("가격 int : " + realIntPrice);
                    System.out.println("날짜: " + date);

                    check1[j]=title;


                    Date resultDate = new Date();
                    DataVO data = new DataVO();






                    DataVO resultData = new DataVO(title,realIntPrice,date);
                    result.add(resultData);


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


            return result;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return null;
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
