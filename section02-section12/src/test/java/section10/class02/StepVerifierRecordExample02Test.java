package section10.class02;

import com.itvillage.section10.class02.StepVerifierRecordExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.Every.everyItem;

/**
 * emit 되는 모든 데이터들을 캡쳐하여 컬렉션에 기록한 후, 기록된 데이터들을 검증하는 예제
 *  - recordWith()를 사용하여 emit 된 데이터를 기록하는 세션을 시작한다.
 *  - thenConsumeWhile()을 사용하여 조건에 맞는 데이터만 소비한다. 여기서 조건에 맞는 데이터들이 ArrayList 에 추가(기록)된다.
 *  - expectRecordedMatches()를 사용하여 기록된 데이터의 컬렉션을 검증한다.
 */
public class StepVerifierRecordExample02Test {
    @Test
    public void getCityTest() {
        StepVerifier
                .create(StepVerifierRecordExample.getCountry(Flux.just("france", "russia", "greece", "poland")))
                .expectSubscription()
                .recordWith(ArrayList::new)
                .thenConsumeWhile(country -> !country.isEmpty())
                .expectRecordedMatches(countries -> countries.size() == 4)
                .expectComplete()
                .verify();
    }
}
