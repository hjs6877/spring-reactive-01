package com.itvillage.section08.class03;

import com.itvillage.utils.Logger;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;

/**
 * Context 활용 예제
 *  - 직교성을 가지는 정보를 표현할 때 주로 사용된다.
 */
public class ContextRealExample01 {
    public static final String HEADER_NAME_AUTH_TOKEN = "authToken";
    public static void main(String[] args) {
        Mono<String> mono = postBook(Mono.just(
                                                new Book("abcd-1111-3533-2809",
                                                        "Reactor의 정석",
                                                        "Kevin")
                                                )
                            )
                            .contextWrite(Context.of(HEADER_NAME_AUTH_TOKEN, "eyJhbGciOiJIUzUxMiJ9.eyJzdWI"));

        mono.subscribe(Logger::onNext);

    }

    private static Mono<String> postBook(Mono<Book> book) {
        return Mono.zip(book, Mono.deferContextual(ctx -> Mono.just(ctx.get(HEADER_NAME_AUTH_TOKEN))))
                .map(tuple -> {
                    // HTTP POST 전송을 했다고 가정.

                    String response = "POST the book(" + tuple.getT1().getBookName() + ","
                            + tuple.getT1().getAuthor() + ") with token: " + tuple.getT2();
                    return response;
                });
    }
}
