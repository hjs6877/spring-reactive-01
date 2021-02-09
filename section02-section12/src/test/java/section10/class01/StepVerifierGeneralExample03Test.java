package section10.class01;

import com.itvillage.section10.class01.StepVerifierGeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class StepVerifierGeneralExample03Test {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(StepVerifierGeneralExample.sayHelloReactor())
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .verifyComplete();  // 검증 실행 및 기대값으로 onComplete signal 을 검증한다.
    }
}
