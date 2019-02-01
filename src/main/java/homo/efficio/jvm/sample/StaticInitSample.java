package homo.efficio.jvm.sample;

public class StaticInitSample {

    public final static int i;

    static {
        i = 123;
    }
}


// $ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -l -p homo/efficio/jvm/sample/StaticInitSample
// Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/sample/StaticInitSample.class
//   Last modified 2019. 1. 20.; size 406 bytes
//   MD5 checksum d6a19e6e0c0302842fd281f71fc579a4
//   Compiled from "StaticInitSample.java"
// public class homo.efficio.jvm.sample.StaticInitSample
//   minor version: 0
//   major version: 53
//   flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//   this_class: #3                          // homo/efficio/jvm/sample/StaticInitSample
//   super_class: #4                         // java/lang/Object
//   interfaces: 0, fields: 1, methods: 2, attributes: 1
// Constant pool:
//    #1 = Methodref          #4.#17         // java/lang/Object."<init>":()V
//    #2 = Fieldref           #3.#18         // homo/efficio/jvm/sample/StaticInitSample.i:I
//    #3 = Class              #19            // homo/efficio/jvm/sample/StaticInitSample
//    #4 = Class              #20            // java/lang/Object
//    #5 = Utf8               i
//    #6 = Utf8               I
//    #7 = Utf8               <init>
//    #8 = Utf8               ()V
//    #9 = Utf8               Code
//   #10 = Utf8               LineNumberTable
//   #11 = Utf8               LocalVariableTable
//   #12 = Utf8               this
//   #13 = Utf8               Lhomo/efficio/jvm/sample/StaticInitSample;
//   #14 = Utf8               <clinit>
//   #15 = Utf8               SourceFile
//   #16 = Utf8               StaticInitSample.java
//   #17 = NameAndType        #7:#8          // "<init>":()V
//   #18 = NameAndType        #5:#6          // i:I
//   #19 = Utf8               homo/efficio/jvm/sample/StaticInitSample
//   #20 = Utf8               java/lang/Object
// {
//   public static final int i;
//     descriptor: I
//     flags: (0x0019) ACC_PUBLIC, ACC_STATIC, ACC_FINAL

//   public homo.efficio.jvm.sample.StaticInitSample();
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
//             0       5     0  this   Lhomo/efficio/jvm/sample/StaticInitSample;

//   static {};
//     descriptor: ()V
//     flags: (0x0008) ACC_STATIC
//     Code:
//       stack=1, locals=0, args_size=0
//          0: bipush        123
//          2: putstatic     #2                  // Field i:I
//          5: return
//       LineNumberTable:
//         line 8: 0
//         line 9: 5
// }
// SourceFile: "StaticInitSample.java"
