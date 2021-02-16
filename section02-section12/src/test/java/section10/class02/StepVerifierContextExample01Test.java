package section10.class02;

import com.itvillage.section10.class02.StepVerifierContextExample;
import com.itvillage.utils.Logger;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

/**
 * Reactor Sequence 에서 사용되는 Context 를 검증하는 예제
 *  - expectAccessibleContext()을 사용하여 접근 가능한 Context가 있는지를 검증한다.
 *  - hasKey()를 사용하여 Context의 key가 존재하는지 검증한다.
 *  - then()을 사용하여 검증을 위한 후속 작업을 진행할 수 있다.
 */
public class StepVerifierContextExample01Test {
    @Test
    public void helloMessageTest() {
        Mono<String> source = StepVerifierContextExample.helloMessage("Reactor");

        StepVerifier
                .create(source)
                .expectSubscription()
                .expectAccessibleContext()
                .hasKey("helloTarget")
                .then()
                .expectNext("Hello Reactor")
                .expectComplete()
                .verify();
    }
}
