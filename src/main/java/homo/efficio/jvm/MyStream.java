package homo.efficio.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-09.
 */
public class MyStream {

    private List<Integer> list = new ArrayList<>();

    public void forLoop() {
        for (int i = 0, len = list.size() ; i < len ; i++) {

        }
    }

    public void forEach() {
        list.forEach(e -> {});
    }
}


//$ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -p -s -constants homo/efficio/jvm/MyStream.class
//Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/MyStream.class
//Last modified 2019. 1. 9.; size 1420 bytes
//        MD5 checksum c9e6577948eeea237cc6333478492640
//        Compiled from "MyStream.java"
//public class homo.efficio.jvm.MyStream
//        minor version: 0
//        major version: 53
//        flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//        this_class: #8                          // homo/efficio/jvm/MyStream
//        super_class: #9                         // java/lang/Object
//        interfaces: 0, fields: 1, methods: 4, attributes: 3
//        Constant pool:
//        #1 = Methodref          #9.#33         // java/lang/Object."<init>":()V
//        #2 = Class              #34            // java/util/ArrayList
//        #3 = Methodref          #2.#33         // java/util/ArrayList."<init>":()V
//        #4 = Fieldref           #8.#35         // homo/efficio/jvm/MyStream.list:Ljava/util/List;
//        #5 = InterfaceMethodref #36.#37        // java/util/List.size:()I
//        #6 = InvokeDynamic      #0:#43         // #0:accept:()Ljava/util/function/Consumer;
//        #7 = InterfaceMethodref #36.#44        // java/util/List.forEach:(Ljava/util/function/Consumer;)V
//        #8 = Class              #45            // homo/efficio/jvm/MyStream
//        #9 = Class              #46            // java/lang/Object
//        #10 = Utf8               list
//        #11 = Utf8               Ljava/util/List;
//        #12 = Utf8               Signature
//        #13 = Utf8               Ljava/util/List<Ljava/lang/Integer;>;
//        #14 = Utf8               <init>
//  #15 = Utf8               ()V
//          #16 = Utf8               Code
//          #17 = Utf8               LineNumberTable
//          #18 = Utf8               LocalVariableTable
//          #19 = Utf8               this
//          #20 = Utf8               Lhomo/efficio/jvm/MyStream;
//          #21 = Utf8               forLoop
//          #22 = Utf8               i
//          #23 = Utf8               I
//          #24 = Utf8               len
//          #25 = Utf8               StackMapTable
//          #26 = Utf8               forEach
//          #27 = Utf8               lambda$forEach$0
//          #28 = Utf8               (Ljava/lang/Integer;)V
//          #29 = Utf8               e
//          #30 = Utf8               Ljava/lang/Integer;
//          #31 = Utf8               SourceFile
//          #32 = Utf8               MyStream.java
//          #33 = NameAndType        #14:#15        // "<init>":()V
//          #34 = Utf8               java/util/ArrayList
//          #35 = NameAndType        #10:#11        // list:Ljava/util/List;
//          #36 = Class              #47            // java/util/List
//          #37 = NameAndType        #48:#49        // size:()I
//          #38 = Utf8               BootstrapMethods
//          #39 = MethodHandle       6:#50          // REF_invokeStatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//          #40 = MethodType         #51            //  (Ljava/lang/Object;)V
//          #41 = MethodHandle       6:#52          // REF_invokeStatic homo/efficio/jvm/MyStream.lambda$forEach$0:(Ljava/lang/Integer;)V
//          #42 = MethodType         #28            //  (Ljava/lang/Integer;)V
//          #43 = NameAndType        #53:#54        // accept:()Ljava/util/function/Consumer;
//          #44 = NameAndType        #26:#55        // forEach:(Ljava/util/function/Consumer;)V
//          #45 = Utf8               homo/efficio/jvm/MyStream
//          #46 = Utf8               java/lang/Object
//          #47 = Utf8               java/util/List
//          #48 = Utf8               size
//          #49 = Utf8               ()I
//          #50 = Methodref          #56.#57        // java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//          #51 = Utf8               (Ljava/lang/Object;)V
//          #52 = Methodref          #8.#58         // homo/efficio/jvm/MyStream.lambda$forEach$0:(Ljava/lang/Integer;)V
//          #53 = Utf8               accept
//          #54 = Utf8               ()Ljava/util/function/Consumer;
//          #55 = Utf8               (Ljava/util/function/Consumer;)V
//          #56 = Class              #59            // java/lang/invoke/LambdaMetafactory
//          #57 = NameAndType        #60:#64        // metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//          #58 = NameAndType        #27:#28        // lambda$forEach$0:(Ljava/lang/Integer;)V
//          #59 = Utf8               java/lang/invoke/LambdaMetafactory
//          #60 = Utf8               metafactory
//          #61 = Class              #66            // java/lang/invoke/MethodHandles$Lookup
//          #62 = Utf8               Lookup
//          #63 = Utf8               InnerClasses
//          #64 = Utf8               (Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//          #65 = Class              #67            // java/lang/invoke/MethodHandles
//          #66 = Utf8               java/lang/invoke/MethodHandles$Lookup
//          #67 = Utf8               java/lang/invoke/MethodHandles
//          {
//private java.util.List<java.lang.Integer> list;
//        descriptor: Ljava/util/List;
//        flags: (0x0002) ACC_PRIVATE
//        Signature: #13                          // Ljava/util/List<Ljava/lang/Integer;>;
//
//public homo.efficio.jvm.MyStream();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=3, locals=1, args_size=1
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: aload_0
//        5: new           #2                  // class java/util/ArrayList
//        8: dup
//        9: invokespecial #3                  // Method java/util/ArrayList."<init>":()V
//        12: putfield      #4                  // Field list:Ljava/util/List;
//        15: return
//        LineNumberTable:
//        line 10: 0
//        line 12: 4
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0      16     0  this   Lhomo/efficio/jvm/MyStream;
//
//public void forLoop();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=3, args_size=1
//        0: iconst_0
//        1: istore_1
//        2: aload_0
//        3: getfield      #4                  // Field list:Ljava/util/List;
//        6: invokeinterface #5,  1            // InterfaceMethod java/util/List.size:()I
//        11: istore_2
//        12: iload_1
//        13: iload_2
//        14: if_icmpge     23
//        17: iinc          1, 1
//        20: goto          12
//        23: return
//        LineNumberTable:
//        line 15: 0
//        line 18: 23
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        2      21     1     i   I
//        12      11     2   len   I
//        0      24     0  this   Lhomo/efficio/jvm/MyStream;
//        StackMapTable: number_of_entries = 2
//        frame_type = 253 /* append */
//        offset_delta = 12
//        locals = [ int, int ]
//        frame_type = 249 /* chop */
//        offset_delta = 10
//
//public void forEach();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=1, args_size=1
//        0: aload_0
//        1: getfield      #4                  // Field list:Ljava/util/List;
//        4: invokedynamic #6,  0              // InvokeDynamic #0:accept:()Ljava/util/function/Consumer;
//        9: invokeinterface #7,  2            // InterfaceMethod java/util/List.forEach:(Ljava/util/function/Consumer;)V
//        14: return
//        LineNumberTable:
//        line 21: 0
//        line 22: 14
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0      15     0  this   Lhomo/efficio/jvm/MyStream;
//
//private static void lambda$forEach$0(java.lang.Integer);
//        descriptor: (Ljava/lang/Integer;)V
//        flags: (0x100a) ACC_PRIVATE, ACC_STATIC, ACC_SYNTHETIC
//        Code:
//        stack=0, locals=1, args_size=1
//        0: return
//        LineNumberTable:
//        line 21: 0
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0       1     0     e   Ljava/lang/Integer;
//        }
//        SourceFile: "MyStream.java"
//        InnerClasses:
//public static final #62= #61 of #65;    // Lookup=class java/lang/invoke/MethodHandles$Lookup of class java/lang/invoke/MethodHandles
//        BootstrapMethods:
//        0: #39 REF_invokeStatic java/lang/invoke/LambdaMetafactory.metafactory:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//        Method arguments:
//        #40 (Ljava/lang/Object;)V
//        #41 REF_invokeStatic homo/efficio/jvm/MyStream.lambda$forEach$0:(Ljava/lang/Integer;)V
//        #42 (Ljava/lang/Integer;)V
