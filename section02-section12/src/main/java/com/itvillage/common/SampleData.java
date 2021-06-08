package com.itvillage.common;

import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SampleData {
    public static final List<String> coinNames = Arrays.asList("BTC", "ETH", "XRP", "ICX", "EOS", "BCH");
    public static final List<Tuple2<String, Integer>> coins =
            Arrays.asList(
                    Tuples.of("BTC", 52_000_000),
                    Tuples.of("ETH", 1_720_000),
                    Tuples.of("XRP", 533),
                    Tuples.of("ICX", 2_080),
                    Tuples.of("EOS", 4_020),
                    Tuples.of("BCH", 558_000));

    public static final List<Tuple2<Integer, Integer>> btcTopPricesPerYear =
            Arrays.asList(
                    Tuples.of(2010, 565),
                    Tuples.of(2011, 36_094),
                    Tuples.of(2012, 17_425),
                    Tuples.of(2013, 1_405_209),
                    Tuples.of(2014, 1_237_182),
                    Tuples.of(2015, 557_603),
                    Tuples.of(2016, 1_111_811),
                    Tuples.of(2017, 22_483_583),
                    Tuples.of(2018, 19_521_543),
                    Tuples.of(2019, 15_761_568),
                    Tuples.of(2020, 22_439_002),
                    Tuples.of(2021, 63_364_000)
            );

    public static final Map<Integer, Integer> btcTopPricesPerYearMap = new HashMap<>();

    public static Map<Integer, Tuple2<Integer, Integer>> getBtcTopPricesPerYearMap() {
        return btcTopPricesPerYear.stream().collect(Collectors.toMap(t1 -> t1.getT1(), t2 -> t2));
    }
    private static class DataGenerator {

    }
}
