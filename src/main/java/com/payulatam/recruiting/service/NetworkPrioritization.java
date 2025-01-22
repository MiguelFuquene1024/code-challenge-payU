package com.payulatam.recruiting.service;


import com.payulatam.recruiting.domain.NetworkComparator;
import com.payulatam.recruiting.domain.model.Network;
import com.payulatam.recruiting.domain.factory.NetworkComparatorFactory;


public class NetworkPrioritization {

    public enum Criteria {
        RESPONSE_TIME, COST
    }

    public int[] prioritizeNetwork(int[] responseTimes, int[] cost, Criteria priority) {
        Network[] networks = BuildNetworks(responseTimes, cost);
        if (networks == null || networks.length == 0) {
            throw new IllegalArgumentException("La lista de redes no puede ser nula o vacía.");
        }

        int n = networks.length;
        int[] indices = new int[n];

        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        NetworkComparator comparator = NetworkComparatorFactory.getComparator(priority);

        quickSort(indices, networks, comparator, 0, n - 1);
        return indices;
    }

    private void quickSort(int[] indices, Network[] networks, NetworkComparator comparator, int start, int end) {
        if (start < end) {
            int pivoteIndex = partition(indices, networks, comparator, start, end);
            quickSort(indices, networks, comparator, start, pivoteIndex - 1);
            quickSort(indices, networks, comparator, pivoteIndex + 1, end);
        }
    }

    private int partition(int[] indices, Network[] networks, NetworkComparator comparator, int start, int end) {
        int pivote = indices[end];
        int i = start - 1;

        for (int j = start; j < end; j++) {
            if (comparator.compare(networks[indices[j]], networks[pivote]) <= 0) {
                i++;
                swap(indices, i, j);
            }
        }

        swap(indices, i + 1, end);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private Network[] BuildNetworks(int[] responseTimes, int[] cost) {
        Network[] networks = new Network[responseTimes.length];
        for (int i = 0; i < responseTimes.length; i++) {
            networks[i] =new Network(responseTimes[i], cost[i]);
        }
        return networks;
    }
}
