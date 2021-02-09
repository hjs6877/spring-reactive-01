package section10.class01;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class StepVerifierGeneralExample01Test {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(Mono.just("Hello Reactor")) // 테스트 대상 Sequence 생성
                .expectNext("Hello Reactor")    // emit 된 데이터 검증
                .expectComplete()   // onComplete Signal 검증
                .verify();          // 검증 실행.
    }
}
