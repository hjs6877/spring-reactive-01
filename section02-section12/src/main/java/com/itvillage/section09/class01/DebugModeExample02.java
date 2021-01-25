package com.itvillage.section09.class01;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Hooks;

/**
 * onOperatorDebug() Hook 메서드를 이용한 Debug mode
 */
public class DebugModeExample02 {
    public static void main(String[] args) {
        Hooks.onOperatorDebug();

        Flux.just(2, 4, 6, 8)
                .zipWith(Flux.just(1, 2, 3, 0), (x, y) -> x/y)
                .subscribe(Logger::onNext, Logger::onError);
    }
}
