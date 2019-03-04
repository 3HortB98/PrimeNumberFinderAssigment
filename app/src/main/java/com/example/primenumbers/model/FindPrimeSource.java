package com.example.primenumbers.model;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FindPrimeSource  implements DataSource {

    private final DataSource.DataListener listener;

    public  FindPrimeSource(DataSource.DataListener listener){
        this.listener = listener;

    }
    @Override
    public void getUpperRangeLimit(Integer number) {
        listener.onPrimesFound(sieveOfEratosthenes(number));
    }

    private static List<Integer> sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }

}
