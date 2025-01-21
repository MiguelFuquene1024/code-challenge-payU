package com.payulatam.recruiting;

import java.util.Arrays;

public class NetworkPrioritization {

    public enum Criteria {
        RESPONSE_TIME, COST
    }

    public int[] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria priority) {

        int n = responseTimes.length;

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        sortByPriority(responseTimes,cost,priority,indices);

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = indices[i];
        }
        return result;

    }

    private void sortByPriority(int[] responseTimes, int[] cost, Criteria priority,Integer[] indices){
        Arrays.sort(indices, (a, b) -> {
            if (priority == Criteria.RESPONSE_TIME) {
                if (responseTimes[a] != responseTimes[b]) {
                    return Integer.compare(responseTimes[a], responseTimes[b]);
                }
                return Integer.compare(cost[a], cost[b]);
            } else {
                if (cost[a] != cost[b]) {
                    return Integer.compare(cost[a], cost[b]);
                }
                return Integer.compare(responseTimes[a], responseTimes[b]);
            }
        });
    }
}
