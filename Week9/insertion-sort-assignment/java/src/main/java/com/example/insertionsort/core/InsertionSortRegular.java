package com.example.insertionsort.core;

public final class InsertionSortRegular implements SortAlgorithm {

    @Override
    public String name() {
        return "regular";
    }

    @Override
    public SortResult sort(int[] input) {
        int[] a = input.clone();
        long comparisons = 0;
        long writes = 0;

        long start = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            int key = a[i];
            int j = i - 1;

            // Stable: move only elements strictly greater than key (not >=)
            while (j >= 0) {
                comparisons++;
                if (a[j] > key) {
                    a[j + 1] = a[j];
                    writes++;
                    j--;
                } else {
                    break;
                }
            }
            a[j + 1] = key;
            writes++;
        }

        long end = System.nanoTime();
        return new SortResult(name(), a.length, end - start, comparisons, writes, a);
    }
}