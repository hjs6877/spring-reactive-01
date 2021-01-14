package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * subscribeOn( ) 은 Top Upstream(Publisher)의 실행 쓰레드를
 * subscribe( ) 호출 scope의 쓰레드에서 subscribeOn( )에서 지정한 쓰레드로 바꾼다.
 */
public class SchedulerOperatorExample04 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .subscribeOn(Schedulers.boundedElastic())
                .filter(data -> {
                    Logger.filter(data);
                    return data > 3;
                })
                .map(data -> {
                    Logger.map(data);
                    return data * 10;
                })
                .subscribe(Logger::onNext);

        TimeUtils.sleep(500L);
    }
}
