package section10.class03;

import com.itvillage.section10.class03.PublisherProbeExample;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;
import reactor.test.publisher.PublisherProbe;

public class PublisherProbeExample02 {
    @Test
    public void publisherProbeTest() {
        PublisherProbe<String> probe = PublisherProbe.of(Mono.just("# Post Task Done"));

        PublisherProbeExample.processTaskWithPost(Mono.just("task01"), probe.mono())
                .subscribe();

        probe.assertWasSubscribed();
        probe.assertWasRequested();
        probe.assertWasNotCancelled();

    }
}
