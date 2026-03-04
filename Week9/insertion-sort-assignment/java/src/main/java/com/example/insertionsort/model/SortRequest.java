package com.example.insertionsort.model;

public final class SortRequest {
    public final String mode;       // "sort" or "benchmark"
    public final String algorithm;  // "regular" or "binary"
    public final int[] data;

    public SortRequest(String mode, String algorithm, int[] data) {
        this.mode = mode;
        this.algorithm = algorithm;
        this.data = data;
    }
}