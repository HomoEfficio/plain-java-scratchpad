package homo.efficio.java8.lamda.type;

/**
 * @author homo.efficio@gmail.com
 *         created on 2016. 11. 16.
 */
public class Puppet {

    public void showResult(int a, FunInterface1 fi1) {
        System.out.println(a + " is odd: " + fi1.isOdd(a));
    }

    // 아래 메서드 주석처리하지 않으면 Ambiguous... 컴파일 에러 발생
//    public void showResult(int a, FunInterface2 fi2) {
//        System.out.println(a + " is odd: " + fi2.isEven(a));
//    }

    interface FunInterface1 {

        boolean isOdd(int a);
    }

    interface FunInterface2 {

        boolean isEven(int a);
    }
}
