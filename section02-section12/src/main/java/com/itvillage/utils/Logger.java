package com.itvillage.utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Logger {
    public static void info(Object data) {
        log.info("{}",data);
    }

    public static void info(String msg, Object data) {
        log.info(msg, data);
    }

    public static void doOnNext(Object data) {
        log.info("# doOnNext(): {}", data);
    }

    public static void doOnRequest(Object data) {
        log.info("# doOnRequest(): {}", data);
    }

    public static void onNext(Object data) {
        log.info("# onNext(): {}", data);
    }

    public static void onNext(Object data1, Object data2) {
        log.info("# onNext(): {} : {}", data1, data2);
    }

    public static void onError(Throwable error) {
        log.error("error happened: ", error);
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
