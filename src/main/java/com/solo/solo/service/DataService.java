package com.solo.solo.service;

import com.solo.solo.domain.DataLowestPriceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DataService {
    @Autowired
    private com.solo.solo.domain.DataItemCategoryRepository categoryRepository;
    @Autowired
    private com.solo.solo.domain.DataLowestPriceRepository lowestPriceRepository;
    @Autowired
    private com.solo.solo.domain.DataPurchaseListRepository purchaseListRepository;





    public List<DataLowestPriceVO> readAllPrice(String name) {
        return lowestPriceRepository.getDataLowestPriceVOBy(name);
    }
}
