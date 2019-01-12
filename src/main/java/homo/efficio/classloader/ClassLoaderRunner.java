package homo.efficio.classloader;

import com.sun.nio.zipfs.ZipInfo;
import homo.efficio.classloader.internal.Internal;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-10-11.
 */
public class ClassLoaderRunner {

    public static void main(String[] args) throws IOException {
        System.out.println("-----------------------------------");
        System.out.println("3 Default ClassLoader\n");
        // Bootstrap ClassLoader 확인
        final ClassLoader bootStrapClassLoader = String.class.getClassLoader();
        System.out.println("Bootstrap Classloader - ClassLoader of String.class: " + bootStrapClassLoader);

        // Extension ClassLoader 확인
        final ClassLoader extensionClassLoader = ZipInfo.class.getClassLoader();
        System.out.println("Extension Classloader - ClassLoader of ZipInfo.class: " + extensionClassLoader);

        // Application ClassLoader 확인
        final ClassLoader applicationClassLoader = Internal.class.getClassLoader();
        System.out.println("Application Classloader - ClassLoader of Internal.class: " + applicationClassLoader);

        System.out.println("-----------------------------------");
        System.out.println("ClassLoader Hierarchy\n");

        System.out.println("BootStrap ClassLoader           : " + bootStrapClassLoader);
        System.out.println("extensionClassLoader.getParent(): " + extensionClassLoader.getParent());

        System.out.println("Extension ClassLoader             : " + extensionClassLoader);
        System.out.println("applicationClassLoader.getParent(): " + applicationClassLoader.getParent());


        // 외부 폴더에 있는 파일 존재 확인
//        final File classRepo = new File("C:/Temp/class-repo/");
        final File classRepo = new File("/Users/1003604/temp/class-repo/");
        System.out.println("classRepo.exists(): " + classRepo.exists());
//        final File abcClassFile = new File("C:/Temp/class-repo", "homo/efficio/classloader/external/External.class");
        final File abcClassFile = new File("/Users/1003604/temp/class-repo", "homo/efficio/classloader/external/External.class");
        System.out.println("abcClassFile.exists(): " + abcClassFile.exists());
        System.out.println("abcClassFile.getCanonicalPath(): " + abcClassFile.getCanonicalPath());

        try {

            System.out.println("-----------------------------------");
            System.out.println("ClassLoader for External and Internal\n");
            final URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{ classRepo.toURI().toURL() });
            final Class<?> externalFromUrl = urlClassLoader.loadClass("homo.efficio.classloader.external.External");
            final Class<?> externalExtendsInternalFromUrl = urlClassLoader.loadClass("homo.efficio.classloader.external.ExternalExtendsInternal");
            final Class<?> externalImplementsInternalInterfaceFromUrl = urlClassLoader.loadClass("homo.efficio.classloader.external.ExternalImplementsInternalInterface");
            final Class<?> externalExtendsExternalLib = urlClassLoader.loadClass("homo.efficio.classloader.external.ExternalExtendsExternalLib");
            System.out.println("ClassLoader of externalExtendsExternalLib:          " + externalExtendsExternalLib.getClassLoader());
            System.out.println("ClassLoader of ExternalImplementsInternalInterface: " + externalImplementsInternalInterfaceFromUrl.getClassLoader());
            System.out.println("ClassLoader of ExternalExtendsInternal:             " + externalExtendsInternalFromUrl.getClassLoader());
            System.out.println("ClassLoader of External:                            " + externalFromUrl.getClassLoader());
            System.out.println("ClassLoader of Internal:                            " + Internal.class.getClassLoader());
            System.out.println("-----------------------------------");

        } catch (MalformedURLException e) {
            throw new RuntimeException("URL 형식이 잘못되었습니다.", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("클래스가 없습니다.", e);
        }


    }
}
