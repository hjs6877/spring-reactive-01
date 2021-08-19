package com.itvillage.section03.class02;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Mono 기본 개념 예제
 *  - 1개의 데이터를 생성해서 emit한다.
 */
public class MonoExample01 {
    public static void main(String[] args) {
        Mono.just("Hello Reactor!")
                .subscribe(data -> Logger.info("# emitted data: {}", data));
    }
}
