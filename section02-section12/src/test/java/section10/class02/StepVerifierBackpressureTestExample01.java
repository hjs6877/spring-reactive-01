package section10.class02;

import com.itvillage.section10.class02.BackpressureExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

/**
 * Backpressure 전략에 따라 Exception이 발생하는 예제
 *  - request 데이터 개수보다 많은 데이터가 emit 되어 OverFlowException 이 발생
 */
public class StepVerifierBackpressureTestExample01 {
    @Test
    public void generateNumberTest() {
        StepVerifier
                .create(BackpressureExample.generateNumber(), 1L)
                .thenConsumeWhile(num -> num >= 1) // emit 된 데이터들을 소비한다.
                .verifyComplete();
    }
}
