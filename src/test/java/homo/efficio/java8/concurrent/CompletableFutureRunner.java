package homo.efficio.java8.concurrent;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * @author homo.efficio@gmail.com
 * created on 2018-02-28
 */
@Slf4j
public class CompletableFutureRunner {

    @Test
    public void basicCF() throws Exception {
        CompletableFuture<String> cf = new CompletableFuture<>();

        cf.complete("CF completed");

        Assertions.assertThat("CF completed").isEqualTo(cf.get());
    }

    @Test
    public void supplyAsyncWhenAsyncComplete() throws Exception {
        System.out.println("Outer Thread: " + Thread.currentThread().getName());

        IntStream.range(1, 20)
                .forEach(i -> {
                    CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
                        System.out.println("Inner Thread: " + Thread.currentThread().getName());
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        return "AsyncResult" + i;
                    });
                    cf.whenCompleteAsync(
                            (result, throwable) -> System.out.println("cf Done with " + result)
                    );
                });

        System.out.println("Just for checking Async");

        Thread.sleep(1500);
    }

    @Test
    public void supplyAsyncThenApplyThenAccept() throws Exception {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            if (1==1) throw new RuntimeException();
            return 1;
        })
        .thenApply(r -> {
            System.out.println("thenApply " + r);
            return r + 1;
        })
        .thenAccept(
            r -> System.out.println("thenAccept " + r)
        );

        Thread.sleep(30);
    }

    @Test
    public void supplyAsyncThenApplyExceptionallyThenAccept() throws Exception {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            if (1==1) throw new RuntimeException();
            return 1;
        })
        .thenApply(r -> {
            System.out.println("thenApply " + r);
            return r + 1;
        })
        .exceptionally(
                e -> 10
        )
        .thenAccept(
                r -> System.out.println("thenAccept " + r)
        );

        Thread.sleep(30);
    }

    @Test
    public void supplyAsyncThenApplyAsyncThenAccept() throws Exception {

        CompletableFuture.supplyAsync(() -> {
            System.out.println("supplyAsync");
            if (1==1) throw new RuntimeException();
            return 1;
        })
                .thenApply(r -> {
                    System.out.println("thenApply " + r);
                    return r + 1;
                })
                .exceptionally(
                        e -> 10
                )
                .thenAccept(
                        r -> System.out.println("thenAccept " + r)
                );

        Thread.sleep(30);
    }
}
