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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class PpomppuCrawling {

    private static final Logger log = LoggerFactory.getLogger(PpomppuCrawling.class);
    private static final int FIRST_PAGE_INDEX = 1;
    private static final int LAST_PAGE_INDEX = 1;
    private static final String PLATFORM = "ppomppu";


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
                final String startUrl = "https://www.ppomppu.co.kr/zboard/zboard.php?id=ppomppu&page="+i+"&search_type=sub_memo&keyword="+search;

                Connection conn = Jsoup.connect(startUrl);
                conn.userAgent("Chrome");

//                System.out.println(conn.get());
                Document document = conn.get();

                Elements titleElements = document.select("td > div > a > font");
//                Elements infoElements = document.select("div.market-info-sub > p");
//                Elements priceElements = document.select("div.market-info-sub p span span");
                Elements regdateElements = document.select("td.list_vspace > nobr.list_vspace");

                if(first){
                    check1 = new String[titleElements.size()];
                    check2 = new String[titleElements.size()];
                    first=false;
                }

                for (int j = 0; j < titleElements.size(); j++) {
                    final String title = titleElements.get(j).text();


                    String price = "";
                    boolean checkChar = false;

                    ArrayList<String> list = new ArrayList<>();

                    for(int k =0; k<title.length(); k++){
                        if(title.charAt(k)=='[' || title.charAt(k)=='('){
                            checkChar=true;
                        }

                        if(checkChar){
                            price = price+title.charAt(k);
                        }

                        if(title.charAt(k)==']' || title.charAt(k)==')'){
                            checkChar=false;

                            if(price.contains("만") || price.contains("원") || price.contains(",")){
//                                String priceSplit2[] = price.split(">");
                                String priceSplit[] = price.split("/");
                                String resultPrice=priceSplit[0];
                                if(priceSplit[0].length()<4 && price.contains("만"))
                                    resultPrice=priceSplit[0]+"0000";

//                                if(price.contains("만")){
//                                    System.out.println("만만만");
//                                    result=priceSplit[0]+"0000";
//                                    if(!price.contains("."))
//                                        result=priceSplit[0]+"000";
//                                }


                                if(resultPrice.length()>3)
                                    list.add(resultPrice);
                            }



                            price="";
                        }
                    }
                    System.out.println(list.size());
                    if(list.size()!=1){
                        System.out.println("브레이크");
                        break;
                    }

//                    for(int k=0; k<list.size(); k++){
//
//                    }



//                    final String info = infoElements.get(j).text();
//                    final String price = priceElements.get(j).text();
                    final int realIntPrice = Integer.parseInt(list.get(0).replaceAll("[^0-9]", ""));
                    final String regdate = removeWhiteSpace(regdateElements.get(j).text());

                    String date= regdate.replaceAll("[/]" ,"-");


                    System.out.println("Ppom 크롤링");
                    System.out.println("제목: " + title);
//                    System.out.println("인포: " + info);
                    System.out.println("가격: " + list.get(0));
                    System.out.println("가격 int : " + realIntPrice);
                    System.out.println("날짜: " + date);

                    check1[j]=title;




                    DataVO data = new DataVO(title,realIntPrice,date);
                    result.add(data);





//                    int n=0;
//                    for(String check : check1){
//                        if(!check.equals(check2))
//                            break;
//                        n++;
//                    }
//
//                    if(n== titleElements.size()){
//                        end = true;
//                        break;
//                    }
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
