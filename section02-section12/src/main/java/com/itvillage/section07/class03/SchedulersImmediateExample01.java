package com.itvillage.section07.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Schedulers.immediate()을 적용하기 전.
 * 2개의 parallel 쓰레드가 할당된다.
 */
public class SchedulersImmediateExample01 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .publishOn(Schedulers.parallel())
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
