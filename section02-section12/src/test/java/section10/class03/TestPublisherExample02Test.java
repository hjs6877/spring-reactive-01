package section10.class03;

import com.itvillage.section10.class01.GeneralExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import reactor.test.publisher.TestPublisher;

/**
 * TestPublisher 를 사용해서 서비스 로직의 메서드에 대한 Unit Test 를 실시하는 예제
 */
public class TestPublisherExample02Test {
    @Test
    public void divideByTwoTest() {
        TestPublisher<Integer> source = TestPublisher.create();

        StepVerifier
                .create(GeneralExample.occurError(source.flux()))
                .expectSubscription()
                .then(() -> source.next(2, 4, 6, 8, 10))
                .expectNext(1)
                .expectNext(2)
                .expectNext(3)
                .expectNext(4)
                .expectError()
                .verify();
    }
}
