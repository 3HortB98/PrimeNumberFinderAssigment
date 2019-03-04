package com.example.primenumbers.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.primenumbers.ItemDetailFragment;
import com.example.primenumbers.R;
import com.example.primenumbers.model.PrimeAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements HomeContract.View{
    EditText etPrime;
    Button btnFind;
    List<Integer> primes = new ArrayList<>();
   // PrimeAdapter primeAdapter = new PrimeAdapter();
    private HomeContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPrime = findViewById(R.id.etNumber);
        btnFind = findViewById(R.id.btnFind);

        /*RecyclerView recyclerView = findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        DividerItemDecoration divider = new DividerItemDecoration(this,linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(divider);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(primeAdapter);*/


       /* ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArrayList(ItemDetailFragment.PRIMES_LIST, (ArrayList) primes);

        itemDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.RecycleViewFrame, itemDetailFragment)
                .commit();*/
        presenter = new HomePresenter(this);
        btnFind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String num = etPrime.getText().toString();
                if(num.isEmpty()){

                    Toast.makeText(getApplicationContext(),"Please enter a number",Toast.LENGTH_LONG).show();
                }else {
                    presenter.getUpperRangeLimit(Integer.parseInt(etPrime.getText().toString()));
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList(ItemDetailFragment.PRIMES_LIST, (ArrayList) primes);

                    ItemDetailFragment itemDetailFragment = new ItemDetailFragment();
                    itemDetailFragment.setArguments(bundle);
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.RecycleViewFrame, itemDetailFragment)
                            .commit();
                }
            }
        });
    }

    @Override
    public void showPrimes(List<Integer> result) {
        primes = result;
        //primeAdapter.setData(result);
    }

    @Override
    public void showError(String Message) {

    }
}
