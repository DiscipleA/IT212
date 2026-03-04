package com.example.insertionsort.model;

import com.example.insertionsort.core.SortResult;

public final class SortResponse {
    public final String algorithm;
    public final int n;
    public final long elapsedNanos;
    public final long comparisons;
    public final long writes;
    public final int[] sorted;

    public SortResponse(SortResult r) {
        this.algorithm = r.algorithm();
        this.n = r.n();
        this.elapsedNanos = r.elapsedNanos();
        this.comparisons = r.comparisons();
        this.writes = r.writes();
        this.sorted = r.sorted();
    }
}