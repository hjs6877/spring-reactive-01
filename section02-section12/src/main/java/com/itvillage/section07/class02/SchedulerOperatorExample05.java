package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Operator 체인의 어떤 위치에 있든 간에 하나 이상의 subscribeOn()이 있다면 가장 상위에 위치한
 * subscribeOn()이 구독 직 후 실행 쓰레드를 변경한다.
 */
public class SchedulerOperatorExample05 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .filter(data -> data > 3)
                .doOnNext(data -> Logger.doOnNext("filter", data))
                .subscribeOn(Schedulers.boundedElastic())
                .map(data -> data * 10)
                .doOnNext(data -> Logger.doOnNext("map", data))
                .subscribeOn(Schedulers.parallel()) // 비교를 위해서 parallel()을 적용
                .subscribe(Logger::onNext);

        TimeUtils.sleep(500L);
    }
}
