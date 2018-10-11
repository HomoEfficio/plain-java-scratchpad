package homo.efficio.classloader;

import com.sun.nio.zipfs.ZipInfo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author homo.efficio@gmail.com
 * Created on 2018-10-11.
 */
public class ClassLoaderRunner {

    public static void main(String[] args) {
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
        final File classRepo = new File("C:/Temp/class-repo/");
//        System.out.println(classRepo.exists());
        final File abcClassFile = new File("C:/Temp/class-repo", "homo/efficio/classloader/External.class");
//        System.out.println(abcClassFile.exists());

        try {

            System.out.println("-----------------------------------");
            System.out.println("ClassLoader for External and Internal\n");
            final URLClassLoader urlClassLoader = new URLClassLoader(new URL[]{ classRepo.toURI().toURL() });
            final Class<?> externalFromUrl = urlClassLoader.loadClass("homo.efficio.classloader.External");
            System.out.println("ClassLoader of External: " + externalFromUrl.getClassLoader());
            System.out.println("ClassLoader of Internal: " + Internal.class.getClassLoader());

            System.out.println("-----------------------------------");

        } catch (MalformedURLException e) {
            throw new RuntimeException("URL 형식이 잘못되었습니다.", e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("클래스가 없습니다.", e);
        }


    }
}
