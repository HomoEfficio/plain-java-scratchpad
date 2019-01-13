package homo.efficio.jvm.sample;

import java.lang.reflect.InvocationTargetException;

public class GreetingMain {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        KoreanGreeting koreanGreeting = new KoreanGreeting();
        System.out.println(koreanGreeting.sayHello("Homo Efficio"));

        Greeting greeting = new KoreanGreeting();
        System.out.println(greeting.sayHello("Homo Efficio"));

        sayHelloFromDynamicallyLoadedClass(args[0]);

        AbstractGreeting abstractGreeting = new EnglishGreeting();
        System.out.println(abstractGreeting.sayHello("Homo Efficio"));
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
//   Last modified 2019. 1. 13.; size 2200 bytes
//   MD5 checksum dc4020789d135592db3b25faf448c068
//   Compiled from "GreetingMain.java"
// public class homo.efficio.jvm.sample.GreetingMain
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #13                         // homo/efficio/jvm/sample/GreetingMain
//   super_class: #20                        // java/lang/Object
//   interfaces: 0, fields: 0, methods: 3, attributes: 1
// Constant pool:
//     #1 = Methodref          #20.#60       // java/lang/Object."<init>":()V
//     #2 = Class              #61           // homo/efficio/jvm/sample/KoreanGreeting
//     #3 = Methodref          #2.#60        // homo/efficio/jvm/sample/KoreanGreeting."<init>":()V
//     #4 = Fieldref           #62.#63       // java/lang/System.out:Ljava/io/PrintStream;
//     #5 = String             #64           // Homo Efficio
//     #6 = Methodref          #2.#65        // homo/efficio/jvm/sample/KoreanGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//     #7 = Methodref          #66.#67       // java/io/PrintStream.println:(Ljava/lang/String;)V
//     #8 = InterfaceMethodref #16.#65       // homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//     #9 = Methodref          #13.#68       // homo/efficio/jvm/sample/GreetingMain.sayHelloFromDynamicallyLoadedClass:(Ljava/lang/String;)V
//    #10 = Class              #69           // homo/efficio/jvm/sample/EnglishGreeting
//    #11 = Methodref          #10.#60       // homo/efficio/jvm/sample/EnglishGreeting."<init>":()V
//    #12 = Methodref          #70.#65       // homo/efficio/jvm/sample/AbstractGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #13 = Class              #71           // homo/efficio/jvm/sample/GreetingMain
//    #14 = Methodref          #18.#72       // java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//    #15 = Methodref          #57.#73       // java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//    #16 = Class              #74           // homo/efficio/jvm/sample/Greeting
//    #17 = Methodref          #18.#75       // java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//    #18 = Class              #76           // java/lang/Class
//    #19 = Methodref          #18.#77       // java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//    #20 = Class              #78           // java/lang/Object
//    #21 = Methodref          #79.#80       // java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//    #22 = Utf8               <init>
//    #23 = Utf8               ()V
//    #24 = Utf8               Code
//    #25 = Utf8               LineNumberTable
//    #26 = Utf8               LocalVariableTable
//    #27 = Utf8               this
//    #28 = Utf8               Lhomo/efficio/jvm/sample/GreetingMain;
//    #29 = Utf8               main
//    #30 = Utf8               ([Ljava/lang/String;)V
//    #31 = Utf8               args
//    #32 = Utf8               [Ljava/lang/String;
//    #33 = Utf8               koreanGreeting
//    #34 = Utf8               Lhomo/efficio/jvm/sample/KoreanGreeting;
//    #35 = Utf8               greeting
//    #36 = Utf8               Lhomo/efficio/jvm/sample/Greeting;
//    #37 = Utf8               abstractGreeting
//    #38 = Utf8               Lhomo/efficio/jvm/sample/AbstractGreeting;
//    #39 = Utf8               Exceptions
//    #40 = Class              #81           // java/lang/ClassNotFoundException
//    #41 = Class              #82           // java/lang/NoSuchMethodException
//    #42 = Class              #83           // java/lang/IllegalAccessException
//    #43 = Class              #84           // java/lang/reflect/InvocationTargetException
//    #44 = Class              #85           // java/lang/InstantiationException
//    #45 = Utf8               sayHelloFromDynamicallyLoadedClass
//    #46 = Utf8               (Ljava/lang/String;)V
//    #47 = Utf8               aGreeting
//    #48 = Utf8               arg
//    #49 = Utf8               Ljava/lang/String;
//    #50 = Utf8               classLoader
//    #51 = Utf8               Ljava/lang/ClassLoader;
//    #52 = Utf8               aClass
//    #53 = Utf8               Ljava/lang/Class;
//    #54 = Utf8               LocalVariableTypeTable
//    #55 = Utf8               Ljava/lang/Class<*>;
//    #56 = Utf8               StackMapTable
//    #57 = Class              #86           // java/lang/ClassLoader
//    #58 = Utf8               SourceFile
//    #59 = Utf8               GreetingMain.java
//    #60 = NameAndType        #22:#23       // "<init>":()V
//    #61 = Utf8               homo/efficio/jvm/sample/KoreanGreeting
//    #62 = Class              #87           // java/lang/System
//    #63 = NameAndType        #88:#89       // out:Ljava/io/PrintStream;
//    #64 = Utf8               Homo Efficio
//    #65 = NameAndType        #90:#91       // sayHello:(Ljava/lang/String;)Ljava/lang/String;
//    #66 = Class              #92           // java/io/PrintStream
//    #67 = NameAndType        #93:#46       // println:(Ljava/lang/String;)V
//    #68 = NameAndType        #45:#46       // sayHelloFromDynamicallyLoadedClass:(Ljava/lang/String;)V
//    #69 = Utf8               homo/efficio/jvm/sample/EnglishGreeting
//    #70 = Class              #94           // homo/efficio/jvm/sample/AbstractGreeting
//    #71 = Utf8               homo/efficio/jvm/sample/GreetingMain
//    #72 = NameAndType        #95:#96       // getClassLoader:()Ljava/lang/ClassLoader;
//    #73 = NameAndType        #97:#98       // loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//    #74 = Utf8               homo/efficio/jvm/sample/Greeting
//    #75 = NameAndType        #99:#100      // isAssignableFrom:(Ljava/lang/Class;)Z
//    #76 = Utf8               java/lang/Class
//    #77 = NameAndType        #101:#102     // getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//    #78 = Utf8               java/lang/Object
//    #79 = Class              #103          // java/lang/reflect/Constructor
//    #80 = NameAndType        #104:#105     // newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//    #81 = Utf8               java/lang/ClassNotFoundException
//    #82 = Utf8               java/lang/NoSuchMethodException
//    #83 = Utf8               java/lang/IllegalAccessException
//    #84 = Utf8               java/lang/reflect/InvocationTargetException
//    #85 = Utf8               java/lang/InstantiationException
//    #86 = Utf8               java/lang/ClassLoader
//    #87 = Utf8               java/lang/System
//    #88 = Utf8               out
//    #89 = Utf8               Ljava/io/PrintStream;
//    #90 = Utf8               sayHello
//    #91 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//    #92 = Utf8               java/io/PrintStream
//    #93 = Utf8               println
//    #94 = Utf8               homo/efficio/jvm/sample/AbstractGreeting
//    #95 = Utf8               getClassLoader
//    #96 = Utf8               ()Ljava/lang/ClassLoader;
//    #97 = Utf8               loadClass
//    #98 = Utf8               (Ljava/lang/String;)Ljava/lang/Class;
//    #99 = Utf8               isAssignableFrom
//   #100 = Utf8               (Ljava/lang/Class;)Z
//   #101 = Utf8               getDeclaredConstructor
//   #102 = Utf8               ([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//   #103 = Utf8               java/lang/reflect/Constructor
//   #104 = Utf8               newInstance
//   #105 = Utf8               ([Ljava/lang/Object;)Ljava/lang/Object;
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
//       stack=3, locals=4, args_size=1
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
//         48: new           #10                 // class homo/efficio/jvm/sample/EnglishGreeting
//         51: dup
//         52: invokespecial #11                 // Method homo/efficio/jvm/sample/EnglishGreeting."<init>":()V
//         55: astore_3
//         56: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         59: aload_3
//         60: ldc           #5                  // String Homo Efficio
//         62: invokevirtual #12                 // Method homo/efficio/jvm/sample/AbstractGreeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//         65: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         68: return
//       LineNumberTable:
//         line 9: 0
//         line 10: 8
//         line 12: 20
//         line 13: 28
//         line 15: 42
//         line 17: 48
//         line 18: 56
//         line 19: 68
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0      69     0  args   [Ljava/lang/String;
//             8      61     1 koreanGreeting   Lhomo/efficio/jvm/sample/KoreanGreeting;
//            28      41     2 greeting   Lhomo/efficio/jvm/sample/Greeting;
//            56      13     3 abstractGreeting   Lhomo/efficio/jvm/sample/AbstractGreeting;
//     Exceptions:
//       throws java.lang.ClassNotFoundException, java.lang.NoSuchMethodException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.InstantiationException

//   private static void sayHelloFromDynamicallyLoadedClass(java.lang.String) throws java.lang.ClassNotFoundException, java.lang.InstantiationException, java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException, java.lang.NoSuchMethodException;
//     descriptor: (Ljava/lang/String;)V
//     flags: (0x000a) ACC_PRIVATE, ACC_STATIC
//     Code:
//       stack=3, locals=4, args_size=1
//          0: ldc           #13                 // class homo/efficio/jvm/sample/GreetingMain
//          2: invokevirtual #14                 // Method java/lang/Class.getClassLoader:()Ljava/lang/ClassLoader;
//          5: astore_1
//          6: aload_1
//          7: aload_0
//          8: invokevirtual #15                 // Method java/lang/ClassLoader.loadClass:(Ljava/lang/String;)Ljava/lang/Class;
//         11: astore_2
//         12: ldc           #16                 // class homo/efficio/jvm/sample/Greeting
//         14: aload_2
//         15: invokevirtual #17                 // Method java/lang/Class.isAssignableFrom:(Ljava/lang/Class;)Z
//         18: ifeq          54
//         21: aload_2
//         22: iconst_0
//         23: anewarray     #18                 // class java/lang/Class
//         26: invokevirtual #19                 // Method java/lang/Class.getDeclaredConstructor:([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
//         29: iconst_0
//         30: anewarray     #20                 // class java/lang/Object
//         33: invokevirtual #21                 // Method java/lang/reflect/Constructor.newInstance:([Ljava/lang/Object;)Ljava/lang/Object;
//         36: checkcast     #16                 // class homo/efficio/jvm/sample/Greeting
//         39: astore_3
//         40: getstatic     #4                  // Field java/lang/System.out:Ljava/io/PrintStream;
//         43: aload_3
//         44: ldc           #5                  // String Homo Efficio
//         46: invokeinterface #8,  2            // InterfaceMethod homo/efficio/jvm/sample/Greeting.sayHello:(Ljava/lang/String;)Ljava/lang/String;
//         51: invokevirtual #7                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
//         54: return
//       LineNumberTable:
//         line 22: 0
//         line 23: 6
//         line 24: 12
//         line 25: 21
//         line 26: 40
//         line 28: 54
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

