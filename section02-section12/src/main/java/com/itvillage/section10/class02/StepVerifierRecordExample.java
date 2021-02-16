package com.itvillage.section10.class02;

import reactor.core.publisher.Flux;

public class StepVerifierRecordExample {
    public static Flux<String> getCountry(Flux<String> source) {
        return source
                .map(country -> country.substring(0, 1).toUpperCase() + country.substring(1));
    }
}
