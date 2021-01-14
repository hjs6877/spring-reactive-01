package com.itvillage.section08.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Context의 특징
 *  - Context는 각각의 구독을 통해 Reactor Sequence에 연결 되며 체인의 각 연산자가 연결된 Context에 접근할 수 있어야 한다.
 *
 */
public class ContextFetureExample01 {
    public static void main(String[] args) {
        String key1 = "id";

        Mono<String> mono = Mono.deferContextual(ctx ->
                Mono.just("ID: " + " " + ctx.get(key1))
        )
        .publishOn(Schedulers.parallel());


        mono.contextWrite(context -> context.put(key1, "itVillage"))
            .subscribe(Logger::onNext);

        mono.contextWrite(context -> context.put(key1, "itWorld"))
            .subscribe(Logger::onNext);


        TimeUtils.sleep(100L);
    }
}
