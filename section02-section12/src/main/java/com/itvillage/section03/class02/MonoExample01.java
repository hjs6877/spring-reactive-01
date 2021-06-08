package com.itvillage.section03.class02;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

public class MonoExample01 {
    public static void main(String[] args) {
        Mono.just("Hello Reactor!")
                .subscribe(data -> Logger.info("# emitted data: {}", data));
    }
}
