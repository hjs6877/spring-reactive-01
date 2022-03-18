package com.itvillage.section11.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

/**
 * Defer 사용 예제
 *  - subscriber가 operator를 실제로 구독하는 시점에 데이터를 emit 하는 예제
 */
public class DeferExample01 {
    public static void main(String[] args) {
        Mono<LocalDateTime> justMono = Mono.just(LocalDateTime.now());
        Mono<LocalDateTime> deferMono = Mono.defer(() -> Mono.just(LocalDateTime.now()));

        TimeUtils.sleep(2000);

        justMono.subscribe(data -> Logger.onNext("just1", data));
        deferMono.subscribe(data -> Logger.onNext("defer1", data));

        TimeUtils.sleep(2000);

        justMono.subscribe(data -> Logger.onNext("just2", data));
        deferMono.subscribe(data -> Logger.onNext("defer2", data));
    }
}
