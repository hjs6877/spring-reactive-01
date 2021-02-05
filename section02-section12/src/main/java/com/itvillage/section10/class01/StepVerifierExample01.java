package com.itvillage.section10.class01;

import reactor.core.publisher.Mono;

public class StepVerifierExample01 {
    public static Mono<String> sayHelloReactor() {
        return Mono.just("Hello Reactor");
    }
}
