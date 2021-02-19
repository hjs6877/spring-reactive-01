package com.itvillage.section10.class02;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class StepVerifierContextExample {
    public static Mono<String> helloMessage(Mono<String> source, String key) {
        return source
                .zipWith(Mono.deferContextual(ctx -> Mono.just(ctx.get(key))))
                .map(tuple -> tuple.getT1() + ", " + tuple.getT2());

    }
}
