package com.solo.solo.service;

import com.solo.solo.crawling.search.Crawling;
import com.solo.solo.crawling.search.FmkoreaCrawling;
import com.solo.solo.domain.DataVO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class DataService {
//    @Autowired
//    private com.solo.solo.domain.DataPurchaseListRepository purchaseListRepository;

    public List<DataVO> Search(String search){
        Crawling crawling = new Crawling();
        List<DataVO> result = crawling.Search(search);
        return result;
    }



//
//
//    public List<DataLowestPriceVO> readAllPrice(String name) {
//        return lowestPriceRepository.getDataLowestPriceVOBy(name);
//    }
}
