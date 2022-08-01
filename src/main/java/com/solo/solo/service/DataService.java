package com.solo.solo.service;

import org.springframework.beans.factory.annotation.Autowired;

public class DataService {

    @Autowired
    private com.solo.solo.domain.DataItemCategoryRepository DataItemCategoryRepository;


    @Autowired
    private com.solo.solo.domain.DataLowestPriceRepository DataLowestPriceRepository;


    @Autowired
    private com.solo.solo.domain.DataPurchaseListRepository DataPurchaseListRepository;


}
