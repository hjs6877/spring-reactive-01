package com.itvillage.section11.class04;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;

public class MapExample02 {
    public static void main(String[] args) {
        Flux
                .just(1, 2, 3, 4)
                .map(n -> {
                    if (n == 2) {
                        throw new RuntimeException("");
                    }
                    return n;
                })
                .onErrorContinue((throwable, o) -> Logger.info("# error happened: " + o))
                .subscribe(Logger::onNext);

    }
}
