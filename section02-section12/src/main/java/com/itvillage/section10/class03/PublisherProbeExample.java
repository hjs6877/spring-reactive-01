package com.itvillage.section10.class03;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Slf4j
public class PublisherProbeExample {
    public static Mono<Void> processTask(Mono<String> taskName, Mono<Void> doNothing) {
        return taskName
                .flatMap(task -> executeTask(task))
                .switchIfEmpty(doNothing);
    }

    private static Mono<Void> executeTask(String taskName) {
        log.info("# process task...");
        return Mono.empty();
    }
}
