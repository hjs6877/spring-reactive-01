package com.itvillage.section11.class01;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.util.function.Tuple2;

import java.util.List;

/**
 * range()의 사용 예제
 *  - range()를 사용해서 list의 특정 index에 해당하는 데이터를 조회하는 예제
 */
public class RangeExample03 {
    public static void main(String[] args) {
        Flux
            .range(7, 5)
            .subscribe(idx -> {
                int year = SampleData.btcTopPricesPerYear.get(idx).getT1();
                int price = SampleData.btcTopPricesPerYear.get(idx).getT2();
                Logger.onNext(year + "'s: " + price);
            });
    }
}
