package com.solo.solo.domain;

import java.util.Comparator;

public class DataVOComparator implements Comparator<DataVO> {


    @Override
    public int compare(DataVO o1, DataVO o2) {
        return Long.valueOf(o1.getDate().getTime()).compareTo(o2.getDate().getTime());
    }
}
