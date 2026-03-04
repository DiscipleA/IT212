package com.example.insertionsort.core;

import java.util.Arrays;

public final class SortResult {
    private final String algorithm;
    private final int n;
    private final long elapsedNanos;
    private final long comparisons;
    private final long writes;
    private final int[] sorted;

    public SortResult(String algorithm, int n, long elapsedNanos, long comparisons, long writes, int[] sorted) {
        this.algorithm = algorithm;
        this.n = n;
        this.elapsedNanos = elapsedNanos;
        this.comparisons = comparisons;
        this.writes = writes;
        this.sorted = sorted;
    }

    public String algorithm() { return algorithm; }
    public int n() { return n; }
    public long elapsedNanos() { return elapsedNanos; }
    public long comparisons() { return comparisons; }
    public long writes() { return writes; }
    public int[] sorted() { return sorted; }

    @Override
    public String toString() {
        return "SortResult{" +
                "algorithm='" + algorithm + '\'' +
                ", n=" + n +
                ", elapsedNanos=" + elapsedNanos +
                ", comparisons=" + comparisons +
                ", writes=" + writes +
                ", sorted=" + Arrays.toString(sorted) +
                '}';
    }
}