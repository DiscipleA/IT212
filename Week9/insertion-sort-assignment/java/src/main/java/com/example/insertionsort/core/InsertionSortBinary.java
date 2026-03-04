package com.example.insertionsort.core;

public final class InsertionSortBinary implements SortAlgorithm {

    @Override
    public String name() {
        return "binary";
    }

    @Override
    public SortResult sort(int[] input) {
        int[] a = input.clone();
        long comparisons = 0;
        long writes = 0;

        long start = System.nanoTime();

        for (int i = 1; i < a.length; i++) {
            int key = a[i];

            // Find insertion point in a[0..i-1] using "upper bound"
            // upper bound => insert AFTER equal keys => stability preserved
            int lo = 0;
            int hi = i; // exclusive

            while (lo < hi) {
                int mid = lo + (hi - lo) / 2;
                comparisons++;
                if (a[mid] <= key) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            int pos = lo;

            // Shift right to make room
            for (int j = i; j > pos; j--) {
                a[j] = a[j - 1];
                writes++;
            }
            a[pos] = key;
            writes++;
        }

        long end = System.nanoTime();
        return new SortResult(name(), a.length, end - start, comparisons, writes, a);
    }
}