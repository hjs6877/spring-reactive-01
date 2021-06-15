package com.itvillage.common;

import reactor.util.function.Tuple2;

import java.util.List;
import java.util.Map;

public class CoronaVaccineMockDAO {
    public static Map<SampleData.CoronaVaccine, Tuple2<SampleData.CoronaVaccine, Integer>> getCoronaVaccinesMap() {
        return SampleData.getCoronaVaccinesMap();
    }
}
