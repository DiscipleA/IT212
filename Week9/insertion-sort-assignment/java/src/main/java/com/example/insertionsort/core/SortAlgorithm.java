package com.example.insertionsort.core;

public interface SortAlgorithm {
    String name();
    SortResult sort(int[] input);
}