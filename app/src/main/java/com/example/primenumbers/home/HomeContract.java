package com.example.primenumbers.home;

import java.util.List;

public interface HomeContract {
    interface View{
        void showPrimes(List<Integer> result);
        void showError(String Message);
    }
    interface Presenter{
        void getUpperRangeLimit(Integer number);

    }
}
