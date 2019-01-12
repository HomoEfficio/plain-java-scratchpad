package homo.efficio.jvm.sample;

import java.lang.reflect.InvocationTargetException;

public class GreetingMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        KoreanGreeting koreanGreeting = new KoreanGreeting();
        System.out.println(koreanGreeting.sayHello("Homo Efficio"));

        Greeting greeting = new KoreanGreeting();
        System.out.println(greeting.sayHello("Homo Efficio"));

        sayHelloFromDynamicallyLoadedClass(args[0]);
    }

    private static void sayHelloFromDynamicallyLoadedClass(String arg) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        ClassLoader classLoader = GreetingMain.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass(arg);
        if (Greeting.class.isAssignableFrom(aClass)) {
            Greeting aGreeting = (Greeting) aClass.getDeclaredConstructor().newInstance();
            System.out.println(aGreeting.sayHello("Homo Efficio"));
        }
    }
}


// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l -p homo/efficio/jvm/sample/GreetingMain.class
// Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/GreetingMain.class
//   Last modified 2019. 1. 13.; size 1997 bytes
//   MD5 checksum 1bd4fbc181d6642a3b64c22f00baa54b
//   Compiled from "GreetingMain.java"
// public class homo.efficio.jvm.sample.GreetingMain
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #10                         // homo/efficio/jvm/sample/GreetingMain
//   super_class: #17                        // java/lang/Object
//   interfaces: 0, fields: 0, methods: 3, attributes: 1
// Constant pool:
//    #1 = Methodref          #17.#55        // java/lang/Object."<init>":()V
//    #2 = Class              #56            // homo/efficio/jvm/sample/KoreanGreeting
//    #3 = Methodref          #2.#55         // homo/efficio/jvm/sample/KoreanGreeting."<init>":()V
//    #4 = Fieldref           #57.#58        // java/lang/System.out:Ljava/io/PrintStream;
//    #5 = String             #59            // Homo Efficio
//    #6 = Methodref          #2.#60         // homo/efficio/jvm/sample/KoreanGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #7 = Methodref          #61.#62        // java/io/PrintStream.println:(Ljava/lang/String;)V
//    #8 = InterfaceMethodref #13.#60        // homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #9 = Methodref          #10.#63        // homo/efficio/jvm/sample/GreetingMain.sayHelloFromDynamicallyLoadedClass:(Ljava/lang/String;)V
//   #10 = Class              #64            // homo/efficio/jvm/sample/GreetingMain
//   #11 = Methodref          #15.#65        // java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//   #12 = Methodref          #52.#66        // java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//   #13 = Class              #67            // homo/efficio/jvm/sample/Greeting
//   #14 = Methodref          #15.#68        // java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//   #15 = Class              #69            // java/lang/Class
//   #16 = Methodref          #15.#70        // java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #17 = Class              #71            // java/lang/Object
//   #18 = Methodref          #72.#73        // java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//   #19 = Utf8               <init>
//   #20 = Utf8               ()V
//   #21 = Utf8               Code
//   #22 = Utf8               LineNumberTable
//   #23 = Utf8               LocalVariableTable
//   #24 = Utf8               this
//   #25 = Utf8               Lhomo/efficio/jvm/sample/GreetingMain;
//   #26 = Utf8               main
//   #27 = Utf8               ([Ljava/lang/String;)V
//   #28 = Utf8               args
//   #29 = Utf8               [Ljava/lang/String;
//   #30 = Utf8               koreanGreeting
//   #31 = Utf8               Lhomo/efficio/jvm/sample/KoreanGreeting;
//   #32 = Utf8               greeting
//   #33 = Utf8               Lhomo/efficio/jvm/sample/Greeting;
//   #34 = Utf8               Exceptions
//   #35 = Class              #74            // java/lang/ClassNotFoundException
//   #36 = Class              #75            // java/lang/NoSuchMethodException
//   #37 = Class              #76            // java/lang/IllegalAccessException
//   #38 = Class              #77            // java/lang/reflect/InvocationTargetException
//   #39 = Class              #78            // java/lang/InstantiationException
//   #40 = Utf8               sayHelloFromDynamicallyLoadedClass
//   #41 = Utf8               (Ljava/lang/String;)V
//   #42 = Utf8               aGreeting
//   #43 = Utf8               arg
//   #44 = Utf8               Ljava/lang/String;
//   #45 = Utf8               classLoader
//   #46 = Utf8               Ljava/lang/ClassLoader;
//   #47 = Utf8               aClass
//   #48 = Utf8               Ljava/lang/Class;
//   #49 = Utf8               LocalVariableTypeTable
//   #50 = Utf8               Ljava/lang/Class<*>;
//   #51 = Utf8               StackMapTable
//   #52 = Class              #79            // java/lang/ClassLoader
//   #53 = Utf8               SourceFile
//   #54 = Utf8               GreetingMain.java
//   #55 = NameAndType        #19:#20        // "<init>":()V
//   #56 = Utf8               homo/efficio/jvm/sample/KoreanGreeting
//   #57 = Class              #80            // java/lang/System
//   #58 = NameAndType        #81:#82        // out:Ljava/io/PrintStream;
//   #59 = Utf8               Homo Efficio
//   #60 = NameAndType        #83:#84        // sayHello:(Ljava/lang/String;)Ljava/lang/String;
//   #61 = Class              #85            // java/io/PrintStream
//   #62 = NameAndType        #86:#41        // println:(Ljava/lang/String;)V
//   #63 = NameAndType        #40:#41        // sayHelloFromDynamicallyLoadedClass:(Ljava/lang/String;)V
//   #64 = Utf8               homo/efficio/jvm/sample/GreetingMain
//   #65 = NameAndType        #87:#88        // getClassLoader:()Ljava/lang/ClassLoader;
//   #66 = NameAndType        #89:#90        // loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//   #67 = Utf8               homo/efficio/jvm/sample/Greeting
//   #68 = NameAndType        #91:#92        // isAssignableFrom:(Ljava/lang/Class;)Z
//   #69 = Utf8               java/lang/Class
//   #70 = NameAndType        #93:#94        // getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #71 = Utf8               java/lang/Object
//   #72 = Class              #95            // java/lang/reflect/Constructor
//   #73 = NameAndType        #96:#97        // newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//   #74 = Utf8               java/lang/ClassNotFoundException
//   #75 = Utf8               java/lang/NoSuchMethodException
//   #76 = Utf8               java/lang/IllegalAccessException
//   #77 = Utf8               java/lang/reflect/InvocationTargetException
//   #78 = Utf8               java/lang/InstantiationException
//   #79 = Utf8               java/lang/ClassLoader
//   #80 = Utf8               java/lang/System
//   #81 = Utf8               out
//   #82 = Utf8               Ljava/io/PrintStream;
//   #83 = Utf8               sayHello
//   #84 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #85 = Utf8               java/io/PrintStream
//   #86 = Utf8               println
//   #87 = Utf8               getClassLoader
//   #88 = Utf8               ()Ljava/lang/ClassLoader;
//   #89 = Utf8               loadClass
//   #90 = Utf8               (Ljava/lang/String;)Ljava/lang/Class;
//   #91 = Utf8               isAssignableFrom
//   #92 = Utf8               (Ljava/lang/Class;)Z
//   #93 = Utf8               getDeclaredConstructor
//   #94 = Utf8               ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #95 = Utf8               java/lang/reflect/Constructor
//   #96 = Utf8               newInstance
//   #97 = Utf8               ([Ljava/lang/Object;)Ljava/lang/Object;
// {
//   public homo.efficio.jvm.sample.GreetingMain();
//     descriptor: ()V
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=1, locals=1, args_size=1
//          0: aload_0
//          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//          4: return
//       LineNumberTable:
//         line 5: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       5     0  this   Lhomo/efficio/jvm/sample/GreetingMain;

//   public static void main(java.lang.String[]) throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.InstantiationException;
//     descriptor: ([Ljava/lang/String;)V
//     flags: (0x0009) ACC_PUBLIC, ACC_STATIC
//     Code:
//       stack=3, locals=3, args_size=1
//          0: new           #2                  // class homo/efficio/jvm/sample/KoreanGreeting
//          3: dup
//          4: invokespecial #3                  // Method homo/efficio/jvm/sample/KoreanGreeting."<init>":()V
//          7: astore_1
//          8: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         11: aload_1
//         12: ldc           #5                  // String Homo Efficio
//         14: invokevirtual #6                  // Method homo/efficio/jvm/sample/KoreanGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//         17: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         20: new           #2                  // class homo/efficio/jvm/sample/KoreanGreeting
//         23: dup
//         24: invokespecial #3                  // Method homo/efficio/jvm/sample/KoreanGreeting."<init>":()V
//         27: astore_2
//         28: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         31: aload_2
//         32: ldc           #5                  // String Homo Efficio
//         34: invokeinterface #8,  2            // InterfaceMethod homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//         39: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         42: aload_0
//         43: iconst_0
//         44: aaload
//         45: invokestatic  #9                  // Method sayHelloFromDynamicallyLoadedClass:(Ljava/lang/String;)V
//         48: return
//       LineNumberTable:
//         line 9: 0
//         line 10: 8
//         line 12: 20
//         line 13: 28
//         line 15: 42
//         line 16: 48
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0      49     0  args   [Ljava/lang/String;
//             8      41     1 koreanGreeting   Lhomo/efficio/jvm/sample/KoreanGreeting;
//            28      21     2 greeting   Lhomo/efficio/jvm/sample/Greeting;
//     Exceptions:
//       throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.InstantiationException

//   private static void sayHelloFromDynamicallyLoadedClass(java.lang.String) throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException;
//     descriptor: (Ljava/lang/String;)V
//     flags: (0x000a) ACC_PRIVATE, ACC_STATIC
//     Code:
//       stack=3, locals=4, args_size=1
//          0: ldc           #10                 // class homo/efficio/jvm/sample/GreetingMain
//          2: invokevirtual #11                 // Method java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//          5: astore_1
//          6: aload_1
//          7: aload_0
//          8: invokevirtual #12                 // Method java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//         11: astore_2
//         12: ldc           #13                 // class homo/efficio/jvm/sample/Greeting
//         14: aload_2
//         15: invokevirtual #14                 // Method java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//         18: ifeq          54
//         21: aload_2
//         22: iconst_0
//         23: anewarray     #15                 // class java/lang/Class
//         26: invokevirtual #16                 // Method java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//         29: iconst_0
//         30: anewarray     #17                 // class java/lang/Object
//         33: invokevirtual #18                 // Method java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//         36: checkcast     #13                 // class homo/efficio/jvm/sample/Greeting
//         39: astore_3
//         40: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         43: aload_3
//         44: ldc           #5                  // String Homo Efficio
//         46: invokeinterface #8,  2            // InterfaceMethod homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//         51: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         54: return
//       LineNumberTable:
//         line 19: 0
//         line 20: 6
//         line 21: 12
//         line 22: 21
//         line 23: 40
//         line 25: 54
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//            40      14     3 aGreeting   Lhomo/efficio/jvm/sample/Greeting;
//             0      55     0   arg   Ljava/lang/String;
//             6      49     1 classLoader   Ljava/lang/ClassLoader;
//            12      43     2 aClass   Ljava/lang/Class;
//       LocalVariableTypeTable:
//         Start  Length  Slot  Name   Signature
//            12      43     2 aClass   Ljava/lang/Class<*>;
//       StackMapTable: number_of_entries = 1
//         frame_type = 253 /* append */
//           offset_delta = 54
//           locals = [ class java/lang/ClassLoader, class java/lang/Class ]
//     Exceptions:
//       throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException
// }
// SourceFile: "GreetingMain.java"

