package section10.class02;

import com.itvillage.section10.class02.StepVerifierBackpressureExample;
import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

/**
 * Backpressure 전략에 따라 발생한 에러를 검증하는 예제
 *  - expectError()를 사용하여 에러가 발생되었는지 검증
 *  - verifyThenAssertThat()을 사용하여 검증 이후에 assertion method 를 사용하여 추가 검증을 할 수 있다.
 *  - hasDroppedElements()을 사용하여 drop 된 데이터가 있는지를 검증한다.
 */
public class StepVerifierBackpressureExample02Test {
    @Test
    public void generateNumberTest() {
        StepVerifier
                .create(StepVerifierBackpressureExample.generateNumber(), 1L)
                .thenConsumeWhile(num -> num >= 1)
                .expectError()
                .verifyThenAssertThat()
                .hasDroppedElements();

    }
}
