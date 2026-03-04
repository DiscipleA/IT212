package com.example.insertionsort.model;

public final class Pair {
    public final int key;
    public final String tag; // secondary attribute to track relative order

    public Pair(int key, String tag) {
        this.key = key;
        this.tag = tag;
    }
}