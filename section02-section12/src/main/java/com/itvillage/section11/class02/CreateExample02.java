package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * create 개념 이해 예제
 *  - Subscriber의 request와 상관없이 next signal 이벤트를 발생하는 예제
 */
public class CreateExample02 {
    public static int size = 10;
    public static int count = 0;
    public static void main(String[] args) {
        Logger.info("# start");
        Flux.create((FluxSink<Integer> emitter) -> {
            for (int i = 0; i <= size; i++) {
                TimeUtils.sleep(1000L);
                if (count == size) {
                    Logger.info("# complete signal");
                    emitter.complete();
                } else {
                    count++;
                    emitter.next(i);
                }
            }

            emitter.onRequest(n -> Logger.info("# onRequest: " + n + " : " + Long.MAX_VALUE));

            emitter.onDispose(() -> {
                Logger.info("# clean up");
            });
        }).subscribe(Logger::onNext);
    }
}
