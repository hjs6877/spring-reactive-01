package com.itvillage.section07.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Schedulers.single()을 적용 후,
 * 첫번째 Schedulers.single()에서 할당 된 쓰레드를 재사용 한다.
 */
public class SchedulersSingleExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .subscribeOn(Schedulers.single())
                .publishOn(Schedulers.single())
                .filter(data -> {
                    Logger.filter(data);
                    return data > 3;
                })
                .publishOn(Schedulers.parallel())
                .map(data -> {
                    Logger.map(data);
                    return data * 10;
                })
                .subscribe(Logger::onNext);

        TimeUtils.sleep(200L);
    }
}
