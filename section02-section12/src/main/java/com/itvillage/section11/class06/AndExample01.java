package com.itvillage.section11.class06;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * and 기본 개념 예제
 */
public class AndExample01 {
    public static void main(String[] args) {
        Mono
            .just("Okay")
            .delayElement(Duration.ofSeconds(1))
            .doOnNext(Logger::doOnNext)
            .and(
                Flux
                .just("Hi", "Tom")
                .delayElements(Duration.ofSeconds(2))
                .doOnNext(Logger::doOnNext)
            )
            .subscribe(
                Logger::onNext,
                Logger::onError,
                () -> Logger.info("Complete!")
            );

        TimeUtils.sleep(4000);
    }
}
