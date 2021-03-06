package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * subscribeOn( )과 publishOn( )이 같이 있다면, publishOn( )을 만나기 전 까지의 Upstream Operator 체인은
 * subscribeOn( )에서 지정한 쓰레드에서 실행되고, publishOn( )을 만날때마다
 * publishOn( ) 아래의 Operator 체인 downstream은 publishOn( )에서 지정한 쓰레드에서 실행된다.
 */
public class SchedulerOperatorExample07 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .publishOn(Schedulers.parallel())
                .filter(data -> {
                    Logger.filter(data);
                    return data > 3;
                })
                .subscribeOn(Schedulers.boundedElastic())
                .map(data -> {
                    Logger.map(data);
                    return data * 10;
                })
                .subscribe(Logger::onNext);

        TimeUtils.sleep(500L);
    }
}
