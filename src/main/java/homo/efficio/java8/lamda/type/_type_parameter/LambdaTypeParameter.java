package homo.efficio.java8.lamda.type._type_parameter;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * @author homo.efficio@gmail.com
 *         create on 2016-12-04.
 */
public class LambdaTypeParameter {

    public static void main(String[] args) {

        // 타입 파라미터 역시 결국은 파라미터 타입의 불합치로 인한 에러가 발생하므로
        // 타입 파라미터가 맞지 않아서 람다 식을 쓸 수 없는 케이스를 못 만들겠다 ㅠㅜ

        System.out.println(concat("1", "2", (a, b) -> a + "---" + b));


        checkMethodReferenceForTypeParameter();
    }

//    private static <T, U> String concat(String s1, String s2, BiFunction<T, U, String> biFunction) {
//        return biFunction.apply(s1, s2);
//    }
    private static String concat(String s1, String s2, BiFunction<String, String, String> biFunction) {
        return biFunction.apply(s1, s2);
    }


    interface ListFactory {
        <T> List<T> make();
    }
    private static void checkMethodReferenceForTypeParameter() {

        // 람다는 이게 안된다
//        ListFactory lfl = () -> new ArrayList();

        // 메서드 레퍼런스는 이게 가능하다.
        ListFactory lf = ArrayList::new;

//        List<String> ls = lf.make();
//        System.out.println("Type of ls: " + ls.getClass());
//        List<Number> ln = lf.make();
//        System.out.println("Type of ln: " + ln.getClass());

//        List<String> ls = lf.make();
//        System.out.println("Type of ls: " + ls.getClass().getGenericSuperclass());
//        List<Number> ln = lf.make();
//        System.out.println("Type of ln: " + ln.getClass().getGenericSuperclass());

        List<String> ls = lf.make();
        System.out.println("Type of ls: " + ((ParameterizedType)ls.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
        List<Number> ln = lf.make();
        System.out.println("Type of ln: " + ((ParameterizedType)ln.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);

        Consumer c = (n) -> ln.add(3);
        Consumer c1 = Objects::nonNull;
        Consumer c2 = (n) -> Objects.nonNull(n);
        Consumer c3 = (n) -> { int a = 0; ln.add(3);};
    }
}
