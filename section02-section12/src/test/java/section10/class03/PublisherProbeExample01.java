package section10.class03;

import com.itvillage.section10.class03.PublisherProbeExample;
import com.itvillage.utils.Logger;
import org.junit.jupiter.api.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.PublisherProbe;

public class PublisherProbeExample01 {
    @Test
    public void publisherProbeTest01() {
        PublisherProbe<Void> probe = PublisherProbe.empty();

        StepVerifier
                .create(PublisherProbeExample.processTask(Mono.just("task01"), probe.mono()))
                .verifyComplete();

        probe.assertWasSubscribed();
        probe.assertWasRequested();
        probe.assertWasNotCancelled();

    }
}
