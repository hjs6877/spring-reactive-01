package com.itvillage;

import reactor.core.publisher.Mono;

public class HelloWorld {
    public static void main(String[] args) {
        Mono<String> mono = Mono.just("Hello world!");
        mono.subscribe(hello -> System.out.println(hello));
    }
}
