package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.Duration;

/**
 * Defer 사용 예제
 *  - 원본 데이터 소스에서 emit 되는 데이터가 없을 경우에만 Mono.defer(this::sayDefault)가 실행된다.
 */
public class DeferExample04 {
    public static void main(String[] args) {
        Logger.info("# Start");
        Mono
                .empty()
                .delayElement(Duration.ofSeconds(3))
                .switchIfEmpty(Mono.defer(DeferExample04::sayDefault))
                .subscribe(Logger::onNext);
    }

    private static Mono<String> sayDefault() {
        Logger.info("# Say Hi");
        return Mono.just("Hi");
    }
}
