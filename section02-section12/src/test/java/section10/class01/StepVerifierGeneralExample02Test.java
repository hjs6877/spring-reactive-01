package section10.class01;

import com.itvillage.section10.class01.StepVerifierGeneralExample;
import org.junit.jupiter.api.Test;
import reactor.test.StepVerifier;

public class StepVerifierGeneralExample02Test {
    @Test
    public void sayHelloReactorTest() {
        StepVerifier
                .create(StepVerifierGeneralExample.sayHelloReactor())
                .expectSubscription()
                .expectNext("Hello")
                .expectNext("Reactor")
                .expectComplete()
                .verify();
    }
}
