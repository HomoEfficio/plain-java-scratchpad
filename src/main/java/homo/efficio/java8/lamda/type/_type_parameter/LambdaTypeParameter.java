package homo.efficio.java8.lamda.type._type_parameter;

import java.util.function.BiFunction;

/**
 * @author homo.efficio@gmail.com
 *         create on 2016-12-04.
 */
public class LambdaTypeParameter {

    public static void main(String[] args) {

        // 타입 파라미터 역시 결국은 파라미터 타입의 불합치로 인한 에러가 발생하므로
        // 타입 파라미터가 맞지 않아서 람다 식을 쓸 수 없는 케이스를 못 만들겠다 ㅠㅜ

        System.out.println(concat("1", "2", (a, b) -> a + "---" + b));
    }

//    private static <T, U> String concat(String s1, String s2, BiFunction<T, U, String> biFunction) {
//        return biFunction.apply(s1, s2);
//    }
    private static String concat(String s1, String s2, BiFunction<String, String, String> biFunction) {
        return biFunction.apply(s1, s2);
    }
}
