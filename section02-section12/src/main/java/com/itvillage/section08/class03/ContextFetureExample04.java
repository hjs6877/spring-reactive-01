package com.itvillage.section08.class03;

import com.itvillage.utils.Logger;
import com.itvillage.utils.TimeUtils;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

/**
 * Context의 특징
 *  - 동일한 키에 대해서 write 할 경우, 해당 Operator 아래에서 가장 가까운 값을 읽는다.
 */
public class ContextFetureExample04 {
    public static void main(String[] args) {
        String key1 = "id";
        Mono.just("Name: Kevin")
//            .transformDeferredContextual((stringMono, contextView) -> contextView.get("job")) // TODO 주석 해제 후, inner Context에 접급할 수 없다는것을 설명.
            .flatMap(name -> Mono.deferContextual(ctx ->
                    Mono.just("ID: " + " " + ctx.get(key1) + ", " + name)
                        .transformDeferredContextual((mono, innerCtx) ->
                                mono.map(data -> data + ", " + "Job: " + innerCtx.get("job"))
                        )
                        .contextWrite(context -> context.put("job", "Software Engineer"))
                )
            )
            .publishOn(Schedulers.parallel())
            .contextWrite(context -> context.put(key1, "itVillage"))
            .subscribe(Logger::onNext);

        TimeUtils.sleep(100L);
    }
}
