package homo.efficio.jvm.sample;

public class KoreanGreeting implements Greeting {
    @Override
    public String greeting(String name) {
        return "안녕 " + name;
    }
}


//$ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v homo/efficio/jvm/sample/KoreanGreeting.class
// Classfile /C:/gitRepo/study/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/KoreanGreeting.class
//   Last modified 2019. 1. 12.; size 921 bytes
//   MD5 checksum cfcda538a103bd228fbd431c22bf82c5
//   Compiled from "KoreanGreeting.java"
// public class homo.efficio.jvm.sample.KoreanGreeting implements homo.efficio.jvm.sample.Greeting
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #3                          // homo/efficio/jvm/sample/KoreanGreeting
//   super_class: #4                         // java/lang/Object
//   interfaces: 1, fields: 0, methods: 2, attributes: 3
// Constant pool:
//    #1 = Methodref          #4.#19         // java/lang/Object."<init>":()V
//    #2 = InvokeDynamic      #0:#23         // #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//    #3 = Class              #24            // homo/efficio/jvm/sample/KoreanGreeting
//    #4 = Class              #25            // java/lang/Object
//    #5 = Class              #26            // homo/efficio/jvm/sample/Greeting
//    #6 = Utf8               <init>
//    #7 = Utf8               ()V
//    #8 = Utf8               Code
//    #9 = Utf8               LineNumberTable
//   #10 = Utf8               LocalVariableTable
//   #11 = Utf8               this
//   #12 = Utf8               Lhomo/efficio/jvm/sample/KoreanGreeting;
//   #13 = Utf8               greeting
//   #14 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #15 = Utf8               name
//   #16 = Utf8               Ljava/lang/String;
//   #17 = Utf8               SourceFile
//   #18 = Utf8               KoreanGreeting.java
//   #19 = NameAndType        #6:#7          // "<init>":()V
//   #20 = Utf8               BootstrapMethods
//   #21 = MethodHandle       6:#27          // REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #22 = String             #28            // ▒ȳ▒ \u0001
//   #23 = NameAndType        #29:#14        // makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//   #24 = Utf8               homo/efficio/jvm/sample/KoreanGreeting
//   #25 = Utf8               java/lang/Object
//   #26 = Utf8               homo/efficio/jvm/sample/Greeting
//   #27 = Methodref          #30.#31        // java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #28 = Utf8               ▒ȳ▒ \u0001
//   #29 = Utf8               makeConcatWithConstants
//   #30 = Class              #32            // java/lang/invoke/StringConcatFactory
//   #31 = NameAndType        #29:#36        // makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #32 = Utf8               java/lang/invoke/StringConcatFactory
//   #33 = Class              #38            // java/lang/invoke/MethodHandles$Lookup
//   #34 = Utf8               Lookup
//   #35 = Utf8               InnerClasses
//   #36 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #37 = Class              #39            // java/lang/invoke/MethodHandles
//   #38 = Utf8               java/lang/invoke/MethodHandles$Lookup
//   #39 = Utf8               java/lang/invoke/MethodHandles
// {
//   public homo.efficio.jvm.sample.KoreanGreeting();
//     descriptor: ()V
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=1, locals=1, args_size=1
//          0: aload_0
//          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//          4: return
//       LineNumberTable:
//         line 3: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       5     0  this   Lhomo/efficio/jvm/sample/KoreanGreeting;

//   public java.lang.String greeting(java.lang.String);
//     descriptor: (Ljava/lang/String;)Ljava/lang/String;
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=1, locals=2, args_size=2
//          0: aload_1
//          1: invokedynamic #2,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//          6: areturn
//       LineNumberTable:
//         line 6: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       7     0  this   Lhomo/efficio/jvm/sample/KoreanGreeting;
//             0       7     1  name   Ljava/lang/String;
// }
// SourceFile: "KoreanGreeting.java"
// InnerClasses:
//   public static final #34= #33 of #37;    // Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
// BootstrapMethods:
//   0: #21 REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//     Method arguments:
//       #22 ▒ȳ▒ \u0001