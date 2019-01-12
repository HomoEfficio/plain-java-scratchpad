package homo.efficio.jvm.sample;

import java.lang.reflect.InvocationTargetException;

public class GreetingMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        KoreanGreeting koreanGreeting = new KoreanGreeting();
        System.out.println(koreanGreeting.sayHello("Homo Efficio"));

        Greeting greeting = new KoreanGreeting();
        System.out.println(greeting.sayHello("Homo Efficio"));

        ClassLoader classLoader = GreetingMain.class.getClassLoader();
        Class<?> aClass = classLoader.loadClass(args[0]);
        if (Greeting.class.isAssignableFrom(aClass)) {
            Greeting aGreeting = (Greeting) aClass.getDeclaredConstructor().newInstance();
            System.out.println(aGreeting.sayHello("Homo Efficio"));
        }
    }
}


// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l homo/efficio/jvm/sample/GreetingMain.class
// Classfile /C:/gitRepo/study/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/GreetingMain.class
//   Last modified 2019. 1. 12.; size 1861 bytes
//   MD5 checksum 523cff4c3b095878364ea360911efd11
//   Compiled from "GreetingMain.java"
// public class homo.efficio.jvm.sample.GreetingMain
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #9                          // homo/efficio/jvm/sample/GreetingMain
//   super_class: #16                        // java/lang/Object
//   interfaces: 0, fields: 0, methods: 2, attributes: 1
// Constant pool:
//    #1 = Methodref          #16.#51        // java/lang/Object."<init>":()V
//    #2 = Class              #52            // homo/efficio/jvm/sample/KoreanGreeting
//    #3 = Methodref          #2.#51         // homo/efficio/jvm/sample/KoreanGreeting."<init>":()V
//    #4 = Fieldref           #53.#54        // java/lang/System.out:Ljava/io/PrintStream;
//    #5 = String             #55            // Homo Efficio
//    #6 = Methodref          #2.#56         // homo/efficio/jvm/sample/KoreanGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #7 = Methodref          #57.#58        // java/io/PrintStream.println:(Ljava/lang/String;)V
//    #8 = InterfaceMethodref #12.#56        // homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #9 = Class              #59            // homo/efficio/jvm/sample/GreetingMain
//   #10 = Methodref          #14.#60        // java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//   #11 = Methodref          #42.#61        // java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//   #12 = Class              #62            // homo/efficio/jvm/sample/Greeting
//   #13 = Methodref          #14.#63        // java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//   #14 = Class              #64            // java/lang/Class
//   #15 = Methodref          #14.#65        // java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #16 = Class              #66            // java/lang/Object
//   #17 = Methodref          #67.#68        // java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//   #18 = Utf8               <init>
//   #19 = Utf8               ()V
//   #20 = Utf8               Code
//   #21 = Utf8               LineNumberTable
//   #22 = Utf8               LocalVariableTable
//   #23 = Utf8               this
//   #24 = Utf8               Lhomo/efficio/jvm/sample/GreetingMain;
//   #25 = Utf8               main
//   #26 = Utf8               ([Ljava/lang/String;)V
//   #27 = Utf8               aGreeting
//   #28 = Utf8               Lhomo/efficio/jvm/sample/Greeting;
//   #29 = Utf8               args
//   #30 = Utf8               [Ljava/lang/String;
//   #31 = Utf8               koreanGreeting
//   #32 = Utf8               Lhomo/efficio/jvm/sample/KoreanGreeting;
//   #33 = Utf8               greeting
//   #34 = Utf8               classLoader
//   #35 = Utf8               Ljava/lang/ClassLoader;
//   #36 = Utf8               aClass
//   #37 = Utf8               Ljava/lang/Class;
//   #38 = Utf8               LocalVariableTypeTable
//   #39 = Utf8               Ljava/lang/Class<*>;
//   #40 = Utf8               StackMapTable
//   #41 = Class              #30            // "[Ljava/lang/String;"
//   #42 = Class              #69            // java/lang/ClassLoader
//   #43 = Utf8               Exceptions
//   #44 = Class              #70            // java/lang/ClassNotFoundException
//   #45 = Class              #71            // java/lang/NoSuchMethodException
//   #46 = Class              #72            // java/lang/IllegalAccessException
//   #47 = Class              #73            // java/lang/reflect/InvocationTargetException
//   #48 = Class              #74            // java/lang/InstantiationException
//   #49 = Utf8               SourceFile
//   #50 = Utf8               GreetingMain.java
//   #51 = NameAndType        #18:#19        // "<init>":()V
//   #52 = Utf8               homo/efficio/jvm/sample/KoreanGreeting
//   #53 = Class              #75            // java/lang/System
//   #54 = NameAndType        #76:#77        // out:Ljava/io/PrintStream;
//   #55 = Utf8               Homo Efficio
//   #56 = NameAndType        #78:#79        // sayHello:(Ljava/lang/String;)Ljava/lang/String;
//   #57 = Class              #80            // java/io/PrintStream
//   #58 = NameAndType        #81:#82        // println:(Ljava/lang/String;)V
//   #59 = Utf8               homo/efficio/jvm/sample/GreetingMain
//   #60 = NameAndType        #83:#84        // getClassLoader:()Ljava/lang/ClassLoader;
//   #61 = NameAndType        #85:#86        // loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//   #62 = Utf8               homo/efficio/jvm/sample/Greeting
//   #63 = NameAndType        #87:#88        // isAssignableFrom:(Ljava/lang/Class;)Z
//   #64 = Utf8               java/lang/Class
//   #65 = NameAndType        #89:#90        // getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #66 = Utf8               java/lang/Object
//   #67 = Class              #91            // java/lang/reflect/Constructor
//   #68 = NameAndType        #92:#93        // newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//   #69 = Utf8               java/lang/ClassLoader
//   #70 = Utf8               java/lang/ClassNotFoundException
//   #71 = Utf8               java/lang/NoSuchMethodException
//   #72 = Utf8               java/lang/IllegalAccessException
//   #73 = Utf8               java/lang/reflect/InvocationTargetException
//   #74 = Utf8               java/lang/InstantiationException
//   #75 = Utf8               java/lang/System
//   #76 = Utf8               out
//   #77 = Utf8               Ljava/io/PrintStream;
//   #78 = Utf8               sayHello
//   #79 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #80 = Utf8               java/io/PrintStream
//   #81 = Utf8               println
//   #82 = Utf8               (Ljava/lang/String;)V
//   #83 = Utf8               getClassLoader
//   #84 = Utf8               ()Ljava/lang/ClassLoader;
//   #85 = Utf8               loadClass
//   #86 = Utf8               (Ljava/lang/String;)Ljava/lang/Class;
//   #87 = Utf8               isAssignableFrom
//   #88 = Utf8               (Ljava/lang/Class;)Z
//   #89 = Utf8               getDeclaredConstructor
//   #90 = Utf8               ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #91 = Utf8               java/lang/reflect/Constructor
//   #92 = Utf8               newInstance
//   #93 = Utf8               ([Ljava/lang/Object;)Ljava/lang/Object;
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
//       stack=3, locals=6, args_size=1
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
//         42: ldc           #9                  // class homo/efficio/jvm/sample/GreetingMain
//         44: invokevirtual #10                 // Method java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//         47: astore_3
//         48: aload_3
//         49: aload_0
//         50: iconst_1
//         51: aaload
//         52: invokevirtual #11                 // Method java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//         55: astore        4
//         57: ldc           #12                 // class homo/efficio/jvm/sample/Greeting
//         59: aload         4
//         61: invokevirtual #13                 // Method java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//         64: ifeq          103
//         67: aload         4
//         69: iconst_0
//         70: anewarray     #14                 // class java/lang/Class
//         73: invokevirtual #15                 // Method java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//         76: iconst_0
//         77: anewarray     #16                 // class java/lang/Object
//         80: invokevirtual #17                 // Method java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//         83: checkcast     #12                 // class homo/efficio/jvm/sample/Greeting
//         86: astore        5
//         88: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         91: aload         5
//         93: ldc           #5                  // String Homo Efficio
//         95: invokeinterface #8,  2            // InterfaceMethod homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//        100: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//        103: return
//       LineNumberTable:
//         line 9: 0
//         line 10: 8
//         line 12: 20
//         line 13: 28
//         line 15: 42
//         line 16: 48
//         line 17: 57
//         line 18: 67
//         line 19: 88
//         line 21: 103
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//            88      15     5 aGreeting   Lhomo/efficio/jvm/sample/Greeting;
//             0     104     0  args   [Ljava/lang/String;
//             8      96     1 koreanGreeting   Lhomo/efficio/jvm/sample/KoreanGreeting;
//            28      76     2 greeting   Lhomo/efficio/jvm/sample/Greeting;
//            48      56     3 classLoader   Ljava/lang/ClassLoader;
//            57      47     4 aClass   Ljava/lang/Class;
//       LocalVariableTypeTable:
//         Start  Length  Slot  Name   Signature
//            57      47     4 aClass   Ljava/lang/Class<*>;
//       StackMapTable: number_of_entries = 1
//         frame_type = 255 /* full_frame */
//           offset_delta = 103
//           locals = [ class "[Ljava/lang/String;", class homo/efficio/jvm/sample/KoreanGreeting, class homo/efficio/jvm/sample/Greeting, class java/lang/ClassLoader, class java/lang/Class ]
//           stack = []
//     Exceptions:
//       throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException,java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.InstantiationException
// }
// SourceFile: "GreetingMain.java"
