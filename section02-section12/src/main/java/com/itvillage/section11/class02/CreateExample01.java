package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

/**
 * create 개념 이해 예제
 *  - generate operator 와 달리 한번에 여러 건의 next signal 이벤트를 발생 시킬 수 있다.
 */
public class CreateExample01 {
    public static int size = 0;
    public static int count = 0;
    public static void main(String[] args) {
        Logger.info("# start");
        Flux.create((FluxSink<Integer> emitter) -> {
            emitter.onRequest(n -> {
                TimeUtils.sleep(2000L);
                for (int i = 1; i <= n; i++) {
                    if (count >= 10) {
                        emitter.complete();
                    } else {
                        count++;
                        emitter.next(i);
                    }
                }
            });
        }).subscribe(new BaseSubscriber<Integer>() {
            @Override
            protected void hookOnSubscribe(Subscription subscription) {
                request(2);
            }

            @Override
            protected void hookOnNext(Integer value) {
                size++;
                Logger.onNext(value);
                if (size == 2) {
                    request(2);
                    size = 0;
                }
            }
        });
    }
}
