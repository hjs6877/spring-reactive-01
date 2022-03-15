package com.itvillage.section07.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

/**
 * Schedulers.newBoundedElastic()을 적용
 */
public class SchedulersNewBoundedElasticExample01 {
    public static void main(String[] args) {
        Scheduler scheduler = Schedulers.newBoundedElastic(2, 10, "I/O-Thread");
        Mono<Integer> mono = Mono.just(1)
                .subscribeOn(scheduler);


        mono.subscribe(data -> {
            TimeUtils.sleep(2000L);
            Logger.onNext("subscribe 1", data);
        });

        mono.subscribe(data -> {
            TimeUtils.sleep(2000L);
            Logger.onNext("subscribe 2", data);
        });

        mono.subscribe(data -> {
            TimeUtils.sleep(1000L);
            Logger.onNext("subscribe 3", data);
        });

        mono.subscribe(data -> {
            TimeUtils.sleep(1000L);
            Logger.onNext("subscribe 4", data);
        });


        TimeUtils.sleep(4000L);

        scheduler.dispose();
    }
}
