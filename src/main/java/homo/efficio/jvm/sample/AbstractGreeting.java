package homo.efficio.jvm.sample;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-13.
 */
public abstract class AbstractGreeting {

    protected abstract String sayHello(String name);
}



// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l -p homo/efficio/jvm/sample/AbstractGreeting.class
// Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/AbstractGreeting.class
//   Last modified 2019. 1. 13.; size 381 bytes
//   MD5 checksum f24a17dd789b58e19e856007e6c83290
//   Compiled from "AbstractGreeting.java"
// public abstract class homo.efficio.jvm.sample.AbstractGreeting
//   minor version: 0
//   major version: 53
//   flags: (0x0421) ACC_PUBLIC, ACC_SUPER, ACC_ABSTRACT
//   this_class: #2                          // homo/efficio/jvm/sample/AbstractGreeting
//   super_class: #3                         // java/lang/Object
//   interfaces: 0, fields: 0, methods: 2, attributes: 1
// Constant pool:
//    #1 = Methodref          #3.#15         // java/lang/Object."<init>":()V
//    #2 = Class              #16            // homo/efficio/jvm/sample/AbstractGreeting
//    #3 = Class              #17            // java/lang/Object
//    #4 = Utf8               <init>
//    #5 = Utf8               ()V
//    #6 = Utf8               Code
//    #7 = Utf8               LineNumberTable
//    #8 = Utf8               LocalVariableTable
//    #9 = Utf8               this
//   #10 = Utf8               Lhomo/efficio/jvm/sample/AbstractGreeting;
//   #11 = Utf8               sayHello
//   #12 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #13 = Utf8               SourceFile
//   #14 = Utf8               AbstractGreeting.java
//   #15 = NameAndType        #4:#5          // "<init>":()V
//   #16 = Utf8               homo/efficio/jvm/sample/AbstractGreeting
//   #17 = Utf8               java/lang/Object
// {
//   public homo.efficio.jvm.sample.AbstractGreeting();
//     descriptor: ()V
//     flags: (0x0001) ACC_PUBLIC
//     Code:
//       stack=1, locals=1, args_size=1
//          0: aload_0
//          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//          4: return
//       LineNumberTable:
//         line 7: 0
//       LocalVariableTable:
//         Start  Length  Slot  Name   Signature
//             0       5     0  this   Lhomo/efficio/jvm/sample/AbstractGreeting;

//   protected abstract java.lang.String sayHello(java.lang.String);
//     descriptor: (Ljava/lang/String;)Ljava/lang/String;
//     flags: (0x0404) ACC_PROTECTED, ACC_ABSTRACT
// }
// SourceFile: "AbstractGreeting.java"
