package com.payulatam.recruiting.service.impl;

import com.payulatam.recruiting.domain.model.Network;
import com.payulatam.recruiting.domain.NetworkComparator;

public class CostComparator implements NetworkComparator {
    @Override
    public int compare(Network network1, Network network2) {
        if (network1.getCost() != network2.getCost()) {
            return Integer.compare(network1.getCost(), network2.getCost());
        }
        return Integer.compare(network1.getResponseTime(), network2.getResponseTime());
    }


}
