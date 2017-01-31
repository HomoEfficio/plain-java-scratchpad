package homo.efficio.xss.response;

/**
 * @author homo.efficio@gmail.com
 *         created on 2016. 11. 16.
 */
public class XssResponseRunner {

    public static void main(String[] args) {

        HTMLCharacterEscapes htmlCharacterEscapes = new HTMLCharacterEscapes();

        System.out.println(htmlCharacterEscapes.getEscapeSequence('('));
        System.out.println(htmlCharacterEscapes.getEscapeSequence(')'));
        System.out.println(htmlCharacterEscapes.getEscapeSequence('#'));
        System.out.println(htmlCharacterEscapes.getEscapeSequence('\''));

        System.out.println(htmlCharacterEscapes.getEscapeSequence('\"'));
        System.out.println(htmlCharacterEscapes.getEscapeSequence('<'));
        System.out.println(htmlCharacterEscapes.getEscapeSequence('>'));
        System.out.println(htmlCharacterEscapes.getEscapeSequence('&'));
    }
}
