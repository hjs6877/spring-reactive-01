package com.itvillage.section03.class02;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;

public class FluxExample04 {
    public static void main(String[] args) {
        Flux.concat(
                Flux.just("Venus"),
                Flux.just("Earth"),
                Flux.just("Mars"))
            .collectList()
            .subscribe(planetList -> Logger.info("# Solar System: {}", planetList));
    }
}
