package com.payulatam.recruiting.domain.factory;

import com.payulatam.recruiting.domain.NetworkComparator;
import com.payulatam.recruiting.service.NetworkPrioritization;
import com.payulatam.recruiting.service.impl.CostComparator;
import com.payulatam.recruiting.service.impl.ResponseTimeComparator;

public class NetworkComparatorFactory {

    public static NetworkComparator getComparator(NetworkPrioritization.Criteria criteria) {
        switch (criteria) {
            case RESPONSE_TIME:
                return new ResponseTimeComparator();
            case COST:
                return new CostComparator();
            default:
                throw new IllegalArgumentException("Criterio desconocido: " + criteria);
        }
    }
}
