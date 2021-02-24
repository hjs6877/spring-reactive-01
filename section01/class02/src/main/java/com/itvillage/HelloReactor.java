package com.itvillage;

import reactor.core.publisher.Mono;

public class HelloReactor {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello Reactor!");
        mono.subscribe(hello -> System.out.println(hello));
    }
}
