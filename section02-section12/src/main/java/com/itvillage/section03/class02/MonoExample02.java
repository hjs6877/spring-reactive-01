package com.itvillage.section03.class02;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

public class MonoExample02 {
    public static void main(String[] args) {
        Mono.empty()
                .subscribe(
                        data -> Logger.info("# emitted data: {}", data),
                        error -> {},
                        () -> Logger.info("# emitted onComplete signal")
                );
    }
}
