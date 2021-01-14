package com.itvillage.section04.class02;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import com.itvillage.utils.TimeUtils;

import java.time.Duration;
import java.util.stream.Stream;

@Slf4j
public class HotSequenceExample {
    public static void main(String[] args) {
        Flux<String> concertFlux =
                Flux.fromStream(Stream.of("Singer 1", "Singer 2", "Singer 3", "Singer 4", "Singer 5"))
                        .delayElements(Duration.ofSeconds(1)).share();

        concertFlux.subscribe(singer -> log.info("# Subscriber1 is watching {}'s song.", singer));

        TimeUtils.sleep(2500);

        concertFlux.subscribe(singer -> log.info("# Subscriber2 is watching {}'s song.", singer));

        TimeUtils.sleep(3000);
    }
}
