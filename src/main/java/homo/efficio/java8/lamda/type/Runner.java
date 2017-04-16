package homo.efficio.java8.lamda.type;

import java.io.EOFException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;

/**
 * @author homo.efficio@gmail.com
 *         created on 2016. 11. 16.
 */
public class Runner {

    public static void main(String[] args) {
        showResult1(3, (a) -> (a % 2 != 0));

        Puppet puppet = new Puppet();

        puppet.showResult(3, (a) -> (a % 2 != 0));



        // Integer가 Object를 상속하고 있으므로
        // Object obj = new Integer(3); 은 가능하지만,
        // 아래와 같이 람다식의 인자 파라미터가 명시된 경우
        // 함수 타입의 인자 파라미터와 람다식의 인자 파라미터 타입은 할당 가능이 아니라 일치 해야만 한다.
//        Consumer<Object> consumer1 = (Integer i) -> System.out.println(i);  // 컴파일 에러(Incompatible parameter type)

        // 람다식의 인자 파라미터가 명시되지 않으면 추론에 의해 아래와 같은 람다 사용이 가능하다.
        Consumer<Object> consumer2 = (i) -> System.out.println(i);  // 이건 가능(cf가 Object로 추론됨)

        // 람다식의 반환 타입 Integer은 Object에 할당가능하므로 아래와 같은 람다 사용이 가능하다.
        Callable<Object> callable1 = () -> new Integer(1);

        // 함수 타입의 반환 타입이 void인 Runnable에 statement expression이 아닌 단순한 값 3은 사용 불가
//        Runnable runnable1 = () -> 3;  // 컴파일 에러(Bad return type)

        // Runnable의 함수 타입의 반환 타입은 void지만, statement expression이 해당하는 인스턴스 생성식은 사용 가능
        Runnable runnable2 = () -> new Integer(3);

//        Lister lister = () -> ...어쩌라고... // 람다식은 언어 차원에서 타입 파라미터가 지원되지 않는다.

        // 예외 관련
        // 함수 타입에 throws IOException 이 있으므로
        // 아래와 같이 body에서 IOException을 던지는 람다 사용 가능
        WithThrows withThrows1 = () -> {
            if (1 == 1)
                throw new IOException();
            return new Integer(3);
        };
        // 함수 타입의 throws IOException을 상속한 EOFException을 던지는 람다도 사용 가능
        WithThrows withThrows2 = () -> {
            if (1 == 1)
                throw new EOFException();
            return new Integer(1);
        };
        // 함수 타입의 throws IOException을 상속하지 않은 예외를 던지는 람다는 사용 불가
//        WithThrows withThrows3 = () -> {
//            if (1 == 1)
//                throw new InterruptedException();
//            return new Integer(1);
//        };
        // body에서 Unchecked Exception을 던지는 람다는 함수 타입의 예외 타입과 관계 없이 사용 가능
        WithThrows withThrows4 = () -> {
            if (1 == 1)
                throw new RuntimeException();
            return new Integer(1);
        };

        Runnable runnable3 = () -> {
            if (1 != 1)
                throw new RuntimeException();
            System.out.println("Unchecked Exception in a lambda body is OK");
        };



        // 함수 타입의 반환 타입이 void이고, 메서드 레퍼런스의 반환 타입도 void
        Runnable runnable4 = System.out::println;

        // 함수 타입의 반환 타입이 void이면, 반환 타입은 void가 아닌 메서드 레퍼런스는 사용 가능
        Integer integer2 = new Integer(2);
        Runnable runnable6 = integer2::doubleValue;

        // 함수 타입에 타입 파라미터가 있는 경우에도 메서드 레퍼런스 사용 가능
//        interface Lister {
//            <T> List<T> makeList();
//        }
//        Lister lister1 = ArrayList::new;

        // 함수 타입의 반환 타입이 void가 아니고, 반환 타입이 함수 타입의 반환 타입과 다른 메서드 레퍼런스는 사용 불가
        Integer integer1 = new Integer(1);
//        Callable<Integer> callable2 = integer1::doubleValue;  // 컴파일 에러(Bad return type)
        // double도 Object에 할당 가능하므로 아래의 메서드 레퍼런스는 가능
        Callable<Object> callable3 = integer1::doubleValue;


        IntLister intLister= ArrayList::new;
    }

    interface Lister {
        <T> List<T> makeList();
    }

    interface IntLister {
        List<Integer> makeList();
    }

    interface WithThrows {
        Integer makeTrouble() throws IOException;
    }

    static void showResult1(Integer a, FunInterface1 fi1) {
        System.out.println(a + " is odd: " + fi1.isOdd(a));
    }
}
