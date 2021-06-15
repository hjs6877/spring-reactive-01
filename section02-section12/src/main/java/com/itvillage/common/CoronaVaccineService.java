package com.itvillage.common;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;

import java.util.Map;

import static com.itvillage.common.CoronaVaccineMockDAO.getCoronaVaccinesMap;

public class CoronaVaccineService {
    public static Mono<Boolean> isGreaterThan(SampleData.CoronaVaccine coronaVaccine, int amount) {
        Map<SampleData.CoronaVaccine, Tuple2<SampleData.CoronaVaccine, Integer>> vaccineMap = getCoronaVaccinesMap();

        return Mono.just(vaccineMap.get(coronaVaccine).getT2() > amount).publishOn(Schedulers.parallel());
    }
}
