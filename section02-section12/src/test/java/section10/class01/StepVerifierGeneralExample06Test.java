package section10.class01;

import com.itvillage.section10.class01.StepVerifierGeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * onNext signal을 통해 emit된 데이터의 개수를 검증
 */
public class StepVerifierGeneralExample06Test {
    @Test
    public void occurErrorTest() {
        StepVerifier
                .create(StepVerifierGeneralExample.rangeNumber())
                .expectSubscription()
                .expectNext(0)
                .expectNextCount(498)
                .expectNext(499)
                .expectComplete()
                .verify();
    }
}
