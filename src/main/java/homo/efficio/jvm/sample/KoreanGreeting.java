package homo.efficio.jvm.sample;

public class KoreanGreeting implements Greeting {

    private String hello = "안녕 ";

    @Override
    public String sayHello(String name) {
        return getHello() + name;
    }

    private String getHello() {
        return this.hello;
    }
}


// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l homo/efficio/jvm/sample/KoreanGreeting.class
// Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/KoreanGreeting.class
//   Last modified 2019. 1. 12.; size 1132 bytes
//   MD5 checksum d7ac2a6fd38c67407480720ca730d987
//   Compiled from "KoreanGreeting.java"
// public class homo.efficio.jvm.sample.KoreanGreeting implements homo.efficio.jvm.sample.Greeting
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #6                          // homo/efficio/jvm/sample/KoreanGreeting
//   super_class: #7                         // java/lang/Object
//   interfaces: 1, fields: 1, methods: 3, attributes: 3
// Constant pool:
//    #1 = Methodref          #7.#25         // java/lang/Object."<init>":()V
//    #2 = String             #26            // ▒?▒
//    #3 = Fieldref           #6.#27         // homo/efficio/jvm/sample/KoreanGreeting.hello:Ljava/lang/String;
//    #4 = Methodref          #6.#28         // homo/efficio/jvm/sample/KoreanGreeting.getHello:()Ljava/lang/String;
//    #5 = InvokeDynamic      #0:#32         // #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
//    #6 = Class              #33            // homo/efficio/jvm/sample/KoreanGreeting
//    #7 = Class              #34            // java/lang/Object
//    #8 = Class              #35            // homo/efficio/jvm/sample/Greeting
//    #9 = Utf8               hello
//   #10 = Utf8               Ljava/lang/String;
//   #11 = Utf8               <init>
//   #12 = Utf8               ()V
//   #13 = Utf8               Code
//   #14 = Utf8               LineNumberTable
//   #15 = Utf8               LocalVariableTable
//   #16 = Utf8               this
//   #17 = Utf8               Lhomo/efficio/jvm/sample/KoreanGreeting;
//   #18 = Utf8               sayHello
//   #19 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #20 = Utf8               name
//   #21 = Utf8               getHello
//   #22 = Utf8               ()Ljava/lang/String;
//   #23 = Utf8               SourceFile
//   #24 = Utf8               KoreanGreeting.java
//   #25 = NameAndType        #11:#12        // "<init>":()V
//   #26 = Utf8               ▒?▒
//   #27 = NameAndType        #9:#10         // hello:Ljava/lang/String;
//   #28 = NameAndType        #21:#22        // getHello:()Ljava/lang/String;
//   #29 = Utf8               BootstrapMethods
//   #30 = MethodHandle       6:#36          // REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #31 = String             #37            // \u0001\u0001
//   #32 = NameAndType        #38:#39        // makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
//   #33 = Utf8               homo/efficio/jvm/sample/KoreanGreeting
//   #34 = Utf8               java/lang/Object
//   #35 = Utf8               homo/efficio/jvm/sample/Greeting
//   #36 = Methodref          #40.#41        // java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #37 = Utf8               \u0001\u0001
//   #38 = Utf8               makeConcatWithConstants
//   #39 = Utf8               (Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
//   #40 = Class              #42            // java/lang/invoke/StringConcatFactory
//   #41 = NameAndType        #38:#46        // makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #42 = Utf8               java/lang/invoke/StringConcatFactory
//   #43 = Class              #48            // java/lang/invoke/MethodHandles$Lookup
//   #44 = Utf8               Lookup
//   #45 = Utf8               InnerClasses
//   #46 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #47 = Class              #49            // java/lang/invoke/MethodHandles
//   #48 = Utf8               java/lang/invoke/MethodHandles$Lookup
//   #49 = Utf8               java/lang/invoke/MethodHandles
// {
//   public homo.efficio.jvm.sample.KoreanGreeting();
//     descriptor: ()V
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=2, locals=1, args_size=1
//          0: aload_0
//          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//          4: aload_0
//          5: ldc           #2                  // String ▒?▒
//          7: putfield      #3                  // Field hello:Ljava/lang/String;
//         10: return
//       LineNumberTable:
//         line 3: 0
//         line 5: 4
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0      11     0  this   Lhomo/efficio/jvm/sample/KoreanGreeting;

//   public java.lang.String sayHello(java.lang.String);
//     descriptor: (Ljava/lang/String;)Ljava/lang/String;
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=2, locals=2, args_size=2
//          0: aload_0
//          1: invokespecial #4                  // Method getHello:()Ljava/lang/String;
//          4: aload_1
//          5: invokedynamic #5,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
//         10: areturn
//       LineNumberTable:
//         line 9: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0      11     0  this   Lhomo/efficio/jvm/sample/KoreanGreeting;
//             0      11     1  name   Ljava/lang/String;
// }
// SourceFile: "KoreanGreeting.java"
// InnerClasses:
//   public static final #44= #43 of #47;    // Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
// BootstrapMethods:
//   0: #30 REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//     Method arguments:
//       #31 \u0001\u0001
