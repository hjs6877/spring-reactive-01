package com.itvillage.section10.class02;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class StepVerifierContextExample {
    final private static String KEY = "helloTarget";
    public static Mono<String> helloMessage(String helloTarget) {
        return Mono
                .deferContextual(ctx -> Mono.just("Hello" + " " + ctx.get(KEY)))
                .publishOn(Schedulers.parallel())
                .contextWrite(context -> context.put(KEY, helloTarget));
    }
}
