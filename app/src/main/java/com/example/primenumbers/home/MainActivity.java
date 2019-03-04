package com.example.primenumbers.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.primenumbers.R;
import com.example.primenumbers.model.PrimeAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View{
    EditText etPrime;
    Button btnFind;

    PrimeAdapter primeAdapter = new PrimeAdapter();
    private HomeContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPrime = findViewById(R.id.etNumber);
        btnFind = findViewById(R.id.btnFind);

        RecyclerView recyclerView = findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(primeAdapter);
        presenter = new HomePresenter(this);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.getUpperRangeLimit(Integer.parseInt(etPrime.getText().toString()));
            }
        });
    }

    @Override
    public void showPrimes(List<Integer> result) {
        primeAdapter.setData(result);
    }

    @Override
    public void showError(String Message) {

    }
}
