package section10.class01;

import com.itvillage.section10.class01.StepVerifierTimeBasedExample;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.scheduler.VirtualTimeScheduler;
import reactor.util.function.Tuple2;

import java.time.Duration;

/**
 * 실제 시간을 가상 시간으로 대체하는 테스트 예제
 *  - 특정 시간만큼 시간을 앞당긴다.
 */
public class StepVerifierTimeBasedExample01Test {
    @Test
    public void getCOVID19CountTest() {
        StepVerifier
                .withVirtualTime(() -> StepVerifierTimeBasedExample.getCOVID19Count(
                        Flux.interval(Duration.ofHours(12)).take(1)
                    )
                )
                .expectSubscription()
                .then(() -> VirtualTimeScheduler.get().advanceTimeBy(Duration.ofHours(12)))
                .expectNextCount(11)
                .expectComplete()
                .verify();

    }
}
