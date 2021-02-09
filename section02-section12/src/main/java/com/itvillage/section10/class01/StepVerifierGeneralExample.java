package com.itvillage.section10.class01;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class StepVerifierGeneralExample {
    public static Flux<String> sayHelloReactor() {
        return Flux
                .just("Hello", "Reactor");
    }

    public static Flux<Integer> divideByTwo() {
        return Flux
                .just(2, 4, 6, 8, 10)
                .zipWith(Flux.just(2, 2, 2, 2, 2), (x, y) -> x/y);
    }

    public static Flux<Integer> occurError() {
        return Flux
                .just(2, 4, 6, 8, 10)
                .zipWith(Flux.just(2, 2, 2, 2, 0), (x, y) -> x/y);
    }

    public static Flux<Integer> rangeNumber() {
        return Flux
                .range(0, 1000)
                .take(500);
    }
}
