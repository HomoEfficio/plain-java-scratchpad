package homo.efficio.java8.lamda.type;

/**
 * @author homo.efficio@gmail.com
 *         created on 2016. 11. 16.
 */
public class Runner {

    public static void main(String[] args) {
        showResult1(3, (a) -> (a % 2 != 0));

        Puppet puppet = new Puppet();

        puppet.showResult(3, (a) -> (a % 2 != 0));
    }

    static void showResult1(Integer a, FunInterface1 fi1) {
        System.out.println(a + " is odd: " + fi1.isOdd(a));
    }
}
