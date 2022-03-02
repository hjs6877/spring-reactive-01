package com.itvillage.section06.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import static reactor.core.publisher.Sinks.EmitFailureHandler.FAIL_FAST;

/**
 * Sinks.Many 예제
 *  - unicast()통해 단 하나의 Subscriber만 허용하는 예제
 */
public class SinkManyExample01 {
    public static void main(String[] args) {
        // 단 하나의 Subscriber만 데이터를 전달 받을 수 있다.
        Sinks.Many<Integer> unicastSink = Sinks.many().unicast().onBackpressureBuffer();
        Flux<Integer> fluxView = unicastSink.asFlux();

        unicastSink.emitNext(1, FAIL_FAST);
        unicastSink.emitNext(2, FAIL_FAST);


        fluxView.subscribe(data -> Logger.onNext("Subscriber1", data));

        unicastSink.emitNext(3, FAIL_FAST);

        // TODO 주석 전, 후 비교해서 보여 줄 것.
//        fluxView.subscribe(data -> Logger.onNext("Subscriber2", data));
    }
}
