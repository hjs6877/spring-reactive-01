package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Operator 체인의 어떤 위치에서든 가장 먼저 호출되는 subscribeOn( )이 있다면
 * subscribe( )가 호출되는 scope에 있는 쓰레드는 subscribeOn( )에서 지정한 쓰레드로 전환된다.
 */
public class SchedulerOperatorExample05 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .filter(data -> {
                    Logger.filter(data);
                    return data > 3;
                })
                .subscribeOn(Schedulers.boundedElastic())
                .map(data -> {
                    Logger.map(data);
                    return data * 10;
                })
                .subscribeOn(Schedulers.parallel()) // 비교를 위해서 parallel()을 적용
                .subscribe(Logger::onNext);

        TimeUtils.sleep(500L);
    }
}
