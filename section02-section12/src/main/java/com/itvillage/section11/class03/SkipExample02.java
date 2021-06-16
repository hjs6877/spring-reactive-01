package com.itvillage.section11.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * skip 기본 개념 예제
 *  - 파라미터로 입력한 시간만큼 emit 될 데이터를 건너뛴 후, 건너뛴 다음 데이터부터 emit 한다.
 */
public class SkipExample02 {
    public static void main(String[] args) {
        Flux
            .interval(Duration.ofSeconds(1))
            .skip(Duration.ofSeconds(2))
            .subscribe(Logger::onNext);

        TimeUtils.sleep(5000L);
    }
}
