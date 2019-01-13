package homo.efficio.jvm.sample;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-13.
 */
public class EnglishGreeting extends AbstractGreeting {
    @Override
    protected String sayHello(String name) {
        return "Hello " + name;
    }
}



// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l -p homo/efficio/jvm/sample/EnglishGreeting.class
// Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/EnglishGreeting.class
//   Last modified 2019. 1. 13.; size 907 bytes
//   MD5 checksum 49d9b3b867facc383301692ab861a8e8
//   Compiled from "EnglishGreeting.java"
// public class homo.efficio.jvm.sample.EnglishGreeting extends homo.efficio.jvm.sample.AbstractGreeting
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #3                          // homo/efficio/jvm/sample/EnglishGreeting
//   super_class: #4                         // homo/efficio/jvm/sample/AbstractGreeting
//   interfaces: 0, fields: 0, methods: 2, attributes: 3
// Constant pool:
//    #1 = Methodref          #4.#18         // homo/efficio/jvm/sample/AbstractGreeting."<init>":()V
//    #2 = InvokeDynamic      #0:#22         // #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//    #3 = Class              #23            // homo/efficio/jvm/sample/EnglishGreeting
//    #4 = Class              #24            // homo/efficio/jvm/sample/AbstractGreeting
//    #5 = Utf8               <init>
//    #6 = Utf8               ()V
//    #7 = Utf8               Code
//    #8 = Utf8               LineNumberTable
//    #9 = Utf8               LocalVariableTable
//   #10 = Utf8               this
//   #11 = Utf8               Lhomo/efficio/jvm/sample/EnglishGreeting;
//   #12 = Utf8               sayHello
//   #13 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #14 = Utf8               name
//   #15 = Utf8               Ljava/lang/String;
//   #16 = Utf8               SourceFile
//   #17 = Utf8               EnglishGreeting.java
//   #18 = NameAndType        #5:#6          // "<init>":()V
//   #19 = Utf8               BootstrapMethods
//   #20 = MethodHandle       6:#25          // REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #21 = String             #26            // Hello \u0001
//   #22 = NameAndType        #27:#13        // makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//   #23 = Utf8               homo/efficio/jvm/sample/EnglishGreeting
//   #24 = Utf8               homo/efficio/jvm/sample/AbstractGreeting
//   #25 = Methodref          #28.#29        // java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #26 = Utf8               Hello \u0001
//   #27 = Utf8               makeConcatWithConstants
//   #28 = Class              #30            // java/lang/invoke/StringConcatFactory
//   #29 = NameAndType        #27:#34        // makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #30 = Utf8               java/lang/invoke/StringConcatFactory
//   #31 = Class              #36            // java/lang/invoke/MethodHandles$Lookup
//   #32 = Utf8               Lookup
//   #33 = Utf8               InnerClasses
//   #34 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//   #35 = Class              #37            // java/lang/invoke/MethodHandles
//   #36 = Utf8               java/lang/invoke/MethodHandles$Lookup
//   #37 = Utf8               java/lang/invoke/MethodHandles
// {
//   public homo.efficio.jvm.sample.EnglishGreeting();
//     descriptor: ()V
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=1, locals=1, args_size=1
//          0: aload_0
//          1: invokespecial #1                  // Method homo/efficio/jvm/sample/AbstractGreeting."<init>":()V
//          4: return
//       LineNumberTable:
//         line 7: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       5     0  this   Lhomo/efficio/jvm/sample/EnglishGreeting;

//   protected java.lang.String sayHello(java.lang.String);
//     descriptor: (Ljava/lang/String;)Ljava/lang/String;
//     flags: (0x0004) ACC_PROTECTED
//     Code:
//       stack=1, locals=2, args_size=2
//          0: aload_1
//          1: invokedynamic #2,  0              // InvokeDynamic #0:makeConcatWithConstants:(Ljava/lang/String;)Ljava/lang/String;
//          6: areturn
//       LineNumberTable:
//         line 10: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       7     0  this   Lhomo/efficio/jvm/sample/EnglishGreeting;
//             0       7     1  name   Ljava/lang/String;
// }
// SourceFile: "EnglishGreeting.java"
// InnerClasses:
//   public static final #32= #31 of #35;    // Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
// BootstrapMethods:
//   0: #20 REF_invokeStatic java/lang/invoke/StringConcatFactory.makeConcatWithConstants:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;
//     Method arguments:
//       #21 Hello \u0001
