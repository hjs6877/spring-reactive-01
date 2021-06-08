package com.itvillage.section03.class02;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class FluxExample03 {
    public static void main(String[] args) {
        Flux<Object> flux =
                Mono.justOrEmpty(null)
                        .concatWith(Mono.justOrEmpty("Jobs"));
        flux.subscribe(data -> Logger.info("# result: {}", data));
    }
}
