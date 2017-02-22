package homo.efficio.java8.urlsafe_base64;

import java.util.Base64;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author homo.efficio@gmail.com
 *         created on 2017. 2. 21.
 */
public class UrlSafeBase64Test {

    public static void main(String[] args) {

        String rawCookieValue = "(DMPD)b80f9ed8-4e66-41a4-ac60-b46ea5586cf0";
        byte[] urlSafeBase64Encoded = Base64.getUrlEncoder().encode(rawCookieValue.getBytes(UTF_8));
        String encodedCookieValue = new String(urlSafeBase64Encoded, UTF_8);
        System.out.println(encodedCookieValue);

        String encodedFromNodeJs = "KERNUEQpYjgwZjllZDgtNGU2Ni00MWE0LWFjNjAtYjQ2ZWE1NTg2Y2Yw";
        System.out.println(encodedFromNodeJs);
        System.out.println("nodejs의 urlsafe-base64 인코딩값 == java8의 urlsafe-base64 인코딩값 : " +
                encodedCookieValue.equals(encodedFromNodeJs));


//        byte[] decoded = Base64.getUrlDecoder().decode("KERNUEQpYjgwZjllZDgtNGU2Ni00MWE0LWFjNjAtYjQ2ZWE1NTg2Y2Yw".getBytes(UTF_8));
        // 아래와 같이 해주시면 됩니다
        byte[] decoded = Base64.getUrlDecoder().decode(encodedCookieValue.getBytes(UTF_8));
        String urlSafeBase64Decoded = new String(decoded, UTF_8);

        System.out.println("++++++++++++");
        System.out.println(rawCookieValue);
        System.out.println(urlSafeBase64Decoded);
        System.out.println("인코딩 전 쿠키값 == 디코딩 후 쿠키값 : " + rawCookieValue.equals(urlSafeBase64Decoded));
    }
}
