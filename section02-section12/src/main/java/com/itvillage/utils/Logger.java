package com.itvillage.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
    public static void doOnNext(Object data) {
        log.info("# doOnNext(): {}", data);
    }

    public static void doOnRequest(Object data) {
        log.info("# doOnRequest(): {}", data);
    }

    public static void onNext(Object data) {
        log.info("# onNext(): {}", data);
    }

    public static void onNext(String message, Object data) {
        log.info("# {} onNext(): {}", message, data);
    }

    public static void filter(Object data) {
        log.info("# filter(): {}", data);
    }
    public static void map(Object data) {
        log.info("# map(): {}", data);
    }
}
