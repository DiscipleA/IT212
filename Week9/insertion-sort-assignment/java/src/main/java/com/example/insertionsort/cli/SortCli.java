package com.example.insertionsort.cli;

import com.example.insertionsort.core.SortRunner;
import com.example.insertionsort.core.SortResult;
import com.example.insertionsort.core.StabilityDemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

public final class SortCli {

    private SortCli() {}

    public static void run(String[] args) {
        try {
            String json = readAllStdin();
            Request req = Request.parse(json);

            if ("stabilityDemo".equals(req.mode)) {
                List<String> order = StabilityDemo.stableOrderAfterSort();
                System.out.println("{\"mode\":\"stabilityDemo\",\"key2Order\":" + toJsonArray(order) + "}");
                return;
            }

            SortResult result = SortRunner.run(req.algorithm, req.data);
            boolean sortedOk = SortRunner.isSortedAscending(result.sorted());

            System.out.println(toJson(result, sortedOk));
        } catch (Exception e) {
            String msg = e.getMessage() == null ? "Unknown error" : e.getMessage().replace("\"", "\\\"");
            System.out.println("{\"error\":true,\"message\":\"" + msg + "\"}");
            System.exit(1);
        }
    }

    // ---- Minimal JSON handling (kept simple for an assignment) ----
    // Expected request JSON:
    // {"mode":"sort","algorithm":"regular","data":[3,1,2]}
    private static final class Request {
        final String mode;
        final String algorithm;
        final int[] data;

        Request(String mode, String algorithm, int[] data) {
            this.mode = mode;
            this.algorithm = algorithm;
            this.data = data;
        }

        static Request parse(String json) {
            String mode = extractString(json, "mode");
            String algorithm = extractString(json, "algorithm");
            int[] data = extractIntArray(json, "data");
            return new Request(mode, algorithm, data);
        }
    }

    private static String extractString(String json, String key) {
        String needle = "\"" + key + "\":";
        int idx = json.indexOf(needle);
        if (idx < 0) return null;
        int start = json.indexOf('"', idx + needle.length());
        int end = json.indexOf('"', start + 1);
        return json.substring(start + 1, end);
    }

    private static int[] extractIntArray(String json, String key) {
        String needle = "\"" + key + "\":";
        int idx = json.indexOf(needle);
        if (idx < 0) return new int[0];
        int lb = json.indexOf('[', idx);
        int rb = json.indexOf(']', lb);
        String inside = json.substring(lb + 1, rb).trim();
        if (inside.isEmpty()) return new int[0];

        String[] parts = inside.split(",");
        int[] arr = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }

    private static String toJson(SortResult r, boolean sortedOk) {
        return "{"
                + "\"error\":false,"
                + "\"mode\":\"sort\","
                + "\"algorithm\":\"" + r.algorithm() + "\","
                + "\"n\":" + r.n() + ","
                + "\"elapsedNanos\":" + r.elapsedNanos() + ","
                + "\"comparisons\":" + r.comparisons() + ","
                + "\"writes\":" + r.writes() + ","
                + "\"sortedOk\":" + sortedOk + ","
                + "\"sorted\":" + toJsonArray(r.sorted())
                + "}";
    }

    private static String toJsonArray(int[] a) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.length; i++) {
            if (i > 0) sb.append(',');
            sb.append(a[i]);
        }
        sb.append(']');
        return sb.toString();
    }

    private static String toJsonArray(List<String> a) {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < a.size(); i++) {
            if (i > 0) sb.append(',');
            sb.append('"').append(a.get(i).replace("\"", "\\\"")).append('"');
        }
        sb.append(']');
        return sb.toString();
    }

    private static String readAllStdin() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) sb.append(line);
        return sb.toString().trim();
    }
}