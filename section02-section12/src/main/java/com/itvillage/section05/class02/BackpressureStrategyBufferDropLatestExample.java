package com.itvillage.section05.class02;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.BufferOverflowStrategy;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

/**
 * Unbounded request 일 경우, Downstream 에 Backpressure Buffer Drop Latest 전략을 적용하는 예제
 *  - Downstream 으로 전달 할 데이터가 버퍼에 가득 찰 경우,
 *    버퍼 안에 있는 데이터 중에서 가장 나중에(최근에) 버퍼로 들어온 데이터부터 Drop 시키는 전략
 *  - 버퍼 안에서 Drop 된 자리에는 버퍼 밖에서 대기하는 데이터로 채운다.
 */
public class BackpressureStrategyBufferDropLatestExample {
    public static void main(String[] args) {
        Flux
                .interval(Duration.ofMillis(1L))
                .onBackpressureBuffer(100,
                        dropped -> Logger.info(" # dropped: " + dropped),
                        BufferOverflowStrategy.DROP_LATEST)
                .publishOn(Schedulers.parallel())
                .subscribe(data -> {
                        TimeUtils.sleep(5L);
                        Logger.onNext(data);
                    },
                    error -> Logger.onError(error));

        TimeUtils.sleep(2000L);
    }
}
