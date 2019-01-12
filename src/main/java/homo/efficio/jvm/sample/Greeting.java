package homo.efficio.jvm.sample;

public interface Greeting {

    String sayHello(String name);
}


// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l homo/efficio/jvm/sample/Greeting.class
// Classfile /C:/gitRepo/study/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/Greeting.class
//   Last modified 2019. 1. 12.; size 181 bytes
//   MD5 checksum 8f7ae541e0a64f511d820930f739d4ac
//   Compiled from "Greeting.java"
// public interface homo.efficio.jvm.sample.Greeting
//   minor version: 0
//   major version: 53
//   flags: (0x0601) ACC_PUBLIC, ACC_INTERFACE, ACC_ABSTRACT
//   this_class: #1                          // homo/efficio/jvm/sample/Greeting
//   super_class: #2                         // java/lang/Object
//   interfaces: 0, fields: 0, methods: 1, attributes: 1
// Constant pool:
//   #1 = Class              #7              // homo/efficio/jvm/sample/Greeting
//   #2 = Class              #8              // java/lang/Object
//   #3 = Utf8               sayHello
//   #4 = Utf8               (Ljava/lang/String;)Ljava/lang/String;
//   #5 = Utf8               SourceFile
//   #6 = Utf8               Greeting.java
//   #7 = Utf8               homo/efficio/jvm/sample/Greeting
//   #8 = Utf8               java/lang/Object
// {
//   public abstract java.lang.String sayHello(java.lang.String);
//     descriptor: (Ljava/lang/String;)Ljava/lang/String;
//     flags: (0x0401) ACC_PUBLIC, ACC_ABSTRACT
// }
// SourceFile: "Greeting.java"
