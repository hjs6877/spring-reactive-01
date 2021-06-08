package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;

/**
 * create 개념 이해 예제
 *  - Subscriber 가 request 할 경우에 next signal 이벤트를 발생하는 예제
 *  - Backpressure 전략을 적용하는 예제
 *  // TODO pull 방식으로 바꾸기
 */
public class CreateExample03 {
    public static int emitSize = 50000 ;
    public static int count = 0;
    public static void main(String[] args) {
        Logger.info("# start");
        Flux.create((FluxSink<Integer> emitter) -> {
            emitter.onRequest(n -> {
                Logger.info("# requested: " + n);
                TimeUtils.sleep(5L);
                for (int i = count; i <= emitSize; i++) {
                    count++;
                    emitter.next(i);
                }
            });

            emitter.onDispose(() -> {
                Logger.info("# clean up");
            });
        }, FluxSink.OverflowStrategy.LATEST)
                .subscribeOn(Schedulers.boundedElastic())
                .publishOn(Schedulers.parallel())
        .subscribe(data -> {
            TimeUtils.sleep(10L);
            Logger.onNext(data);
        });

        TimeUtils.sleep(5000L);
    }
}
