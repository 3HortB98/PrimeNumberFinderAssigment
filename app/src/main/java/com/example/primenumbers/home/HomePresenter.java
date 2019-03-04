package com.example.primenumbers.home;

import com.example.primenumbers.model.DataSource;
import com.example.primenumbers.model.FindPrimeSource;

import java.util.List;

public class HomePresenter implements HomeContract.Presenter, DataSource.DataListener {
    private final HomeContract.View view;
    private final DataSource dataSource;

    public HomePresenter(HomeContract.View view){
        this.view = view;
        dataSource = new FindPrimeSource(this);
    }
    @Override
    public void getUpperRangeLimit(Integer number) {
        dataSource.getUpperRangeLimit(number);
    }

    @Override
    public void onPrimesFound(List<Integer> result) {
        view.showPrimes(result);
    }

    @Override
    public void onError(String message) {

    }
}
