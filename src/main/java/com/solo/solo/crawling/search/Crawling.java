package com.solo.solo.crawling.search;

import com.solo.solo.domain.DataVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Crawling {
    FmkoreaCrawling fmkoreaCrawling = new FmkoreaCrawling();
    PpomppuCrawling ppomppuCrawling = new PpomppuCrawling();
    QuasarzoneCrawling quasarzoneCrawling = new QuasarzoneCrawling();
    QuasarzoneTemporaryCrawling quasarzoneTemporaryCrawling = new QuasarzoneTemporaryCrawling();


    public List<DataVO> Search(String search) {
        List<DataVO> fmkorea = fmkoreaCrawling.search(search);
        List<DataVO> ppomppu = ppomppuCrawling.search(search);
        List<DataVO> quasarzone = quasarzoneCrawling.search(search);
        List<DataVO> quasarzoneTemporary = quasarzoneTemporaryCrawling.search(search);

        List<DataVO> result = new ArrayList<>();
        result.addAll(fmkorea);
        result.addAll(ppomppu);
        result.addAll(quasarzone);
        result.addAll(quasarzoneTemporary);

        Collections.sort(result, new Comparator<DataVO>() {
            @Override
            public int compare(DataVO o1, DataVO o2) {
                return o1.getResultDate().compareTo(o2.getResultDate());
            }
        });
        return  result;
    }

}
