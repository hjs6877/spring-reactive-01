package com.itvillage.section10.class03;

import com.itvillage.utils.Logger;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
public class PublisherProbeExample {
    public static Mono<Void> processTaskNoPost(Mono<String> taskName, Mono<Void> doNothing) {
        return taskName
                .flatMap(task -> executeTask(task))
                .switchIfEmpty(doNothing);
    }

    public static Mono<String> processTaskWithPost(Mono<String> taskName, Mono<String> postTask) {
        return taskName
                .flatMap(task -> executeTask(task))
                .switchIfEmpty(postTask);
    }

    private static Mono executeTask(String taskName) {
        Logger.info("# process task...");
        return Mono.empty();
    }
}
