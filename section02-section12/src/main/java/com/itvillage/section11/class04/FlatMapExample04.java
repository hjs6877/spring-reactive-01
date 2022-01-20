package com.itvillage.section11.class04;

import com.itvillage.common.SampleData;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;
import reactor.util.function.Tuple2;
import reactor.util.function.Tuples;

/**
 * flatMap 활용 예제
 *  - 특정 가격에 BTC를 구매했을 때 연도별 최고가일 경우 수익 금액 계산하기.
 *      수익 금액 = (현재 가격 * 투자 금액 / 구매시 가격 ) - 원금
 */
public class FlatMapExample04 {
    public static void main(String[] args) {
        Flux
                .just(Tuples.of(500, 1000))
                .flatMap(buyInfo -> calculateMaxProfitPerYear(buyInfo))

                .subscribe(Logger::onNext);

        TimeUtils.sleep(200L);
    }

    private static Flux<Long> calculateMaxProfitPerYear(Tuple2<Integer, Integer> buyInfo) {
        return Flux
                .fromIterable(SampleData.btcTopPricesPerYear)
                .map(btcInfo -> btcInfo.getT2() * buyInfo.getT2() / buyInfo.getT1() - buyInfo.getT2());
    }
}