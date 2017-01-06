package homo.efficio.java8.lamda.type._throws;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by hanmomhanda on 2016-12-03.
 */
public class LambdaThrows {

    public static void main(String[] args) throws IOException {

        // 람다 타입 비교는
        // 타입 파라미터, 파라미터 타입, 리턴 타입, throws 로 비교하는데
        // throws 호환성이 안 맞으면 lambda 타입 비교 전에 그냥 아래처럼
        // NoSuchMethodException이 catch 되지 않았다는 컴파일러 에러가 나서
        // throws 호환성에 따른 람다 타입 테스트는 못하겠음

        printToConsole(System.out, "Hello Lambda", (ps, msg) -> ps.println(msg));

//        printToConsole(System.out, "Hello Lambda", (ps, msg) -> {
//            try {
//                ps.getClass().getMethod("abc", String.class).invoke(ps, msg);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            } catch (NoSuchMethodException e) {
//                e.printStackTrace();
//            }
//        });

        printToConsole(System.out, "Hello Lambda",
                new FunInterfaceWithThrows() {
                    @Override
                    public void writeTo(PrintStream ps, String msg) throws IOException {

                    }
                });
    }

    private static void printToConsole(PrintStream ps, String msg, FunInterfaceWithThrows fi) throws IOException {
        fi.writeTo(ps, msg);
    }
}
