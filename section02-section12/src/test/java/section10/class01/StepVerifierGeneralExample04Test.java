package section10.class01;

import com.itvillage.section10.class01.StepVerifierGeneralExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

/**
 * onError signal 발생 여부를 검증
 */
public class StepVerifierGeneralExample04Test {
    @Test
    public void occurErrorTest() {
        Flux<Integer> source = Flux.just(2, 4, 6, 8, 10);
        StepVerifier
                .create(StepVerifierGeneralExample.occurError(source))
                .expectSubscription()
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectError()
                .verify();
    }
}
