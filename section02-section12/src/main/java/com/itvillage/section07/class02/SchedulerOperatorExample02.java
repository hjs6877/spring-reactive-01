package com.itvillage.section07.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * Operator 체인에서 publishOn( )이 호출되면 publishOn( ) 호출 이후의 Operator 체인은
 * 다음 publisherOn( )을 만나기전까지 publishOn( )에서 지정한 Thread에서 실행이 된다.
 */
public class SchedulerOperatorExample02 {
    public static void main(String[] args) {
        Flux.fromArray(new Integer[] {1, 3, 5, 7})
                .log()
                .publishOn(Schedulers.parallel())
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
