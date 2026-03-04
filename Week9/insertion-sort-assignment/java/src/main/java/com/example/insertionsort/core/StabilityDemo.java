package com.example.insertionsort.core;

import com.example.insertionsort.model.Pair;
import java.util.ArrayList;
import java.util.List;

public final class StabilityDemo {

    private StabilityDemo() {}

    // Regular insertion sort for Pair[] sorting by key, stable
    public static List<String> stableOrderAfterSort() {
        Pair[] a = new Pair[] {
            new Pair(2, "A"),
            new Pair(1, "X"),
            new Pair(2, "B"),
            new Pair(2, "C"),
            new Pair(1, "Y")
        };

        for (int i = 1; i < a.length; i++) {
            Pair key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j].key > key.key) { // strictly greater => stable
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }

        // Return tags for key==2 in their final order; should be A,B,C (same as input)
        List<String> tags = new ArrayList<>();
        for (Pair p : a) {
            if (p.key == 2) tags.add(p.tag);
        }
        return tags;
    }
}