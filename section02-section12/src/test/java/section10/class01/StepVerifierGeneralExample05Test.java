package section10.class01;

import com.itvillage.section10.class01.StepVerifierGeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * 1개 이상의 emit된 데이터를 한꺼번에 검증
 */
public class StepVerifierGeneralExample05Test {
    @Test
    public void occurErrorTest() {
        StepVerifier
                .create(StepVerifierGeneralExample.divideByTwo())
                .expectSubscription()
                .expectNext(1, 2, 3, 4, 5)
                .expectComplete()
                .verify();
    }
}
