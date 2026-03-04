package com.example.insertionsort.core;

public final class SortRunner {
    private SortRunner() {}

    public static SortAlgorithm select(String algorithm) {
        return switch (algorithm) {
            case "regular" -> new InsertionSortRegular();
            case "binary" -> new InsertionSortBinary();
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        };
    }

    public static SortResult run(String algorithm, int[] data) {
        SortAlgorithm algo = select(algorithm);
        return algo.sort(data);
    }

    public static boolean isSortedAscending(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) return false;
        }
        return true;
    }
}