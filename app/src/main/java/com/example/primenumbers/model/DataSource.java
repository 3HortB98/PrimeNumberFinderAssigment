package com.example.primenumbers.model;

import java.util.List;

public interface DataSource {
    void getUpperRangeLimit(Integer number);

    interface DataListener{
        void onPrimesFound(List<Integer> result);
        void onError(String message);

    }
}
