package homo.efficio.jvm;

/**
 * @author homo.efficio@gmail.com
 * Created on 2019-01-09.
 */
public class MyLoop {

    private int len;

    public MyLoop(int len) {
        this.len = len;
    }

    public void forLoop() {
        for (int i = 0 ; i < this.len ; i++) {

        }
    }

    public void forLoop2() {
        for (int i = 0, len = this.len ; i < len ; i++) {

        }
    }
}

//$ /c/Program\ Files/Java/jdk-9.0.1/bin/javap -v -p -s -constants homo/efficio/jvm/MyLoop.class
//Classfile /C:/gitrepo/scratchpad/plain-java-scratchpad/out/production/classes/homo/efficio/jvm/MyLoop.class
//Last modified 2019. 1. 9.; size 593 bytes
//        MD5 checksum b6804381446a2cd76b009895b23e95de
//        Compiled from "MyLoop.java"
//public class homo.efficio.jvm.MyLoop
//        minor version: 0
//        major version: 53
//        flags: (0x0021) ACC_PUBLIC, ACC_SUPER
//        this_class: #3                          // homo/efficio/jvm/MyLoop
//        super_class: #4                         // java/lang/Object
//        interfaces: 0, fields: 1, methods: 3, attributes: 1
//        Constant pool:
//        #1 = Methodref          #4.#21         // java/lang/Object."<init>":()V
//        #2 = Fieldref           #3.#22         // homo/efficio/jvm/MyLoop.len:I
//        #3 = Class              #23            // homo/efficio/jvm/MyLoop
//        #4 = Class              #24            // java/lang/Object
//        #5 = Utf8               len
//        #6 = Utf8               I
//        #7 = Utf8               <init>
//   #8 = Utf8               (I)V
//           #9 = Utf8               Code
//           #10 = Utf8               LineNumberTable
//           #11 = Utf8               LocalVariableTable
//           #12 = Utf8               this
//           #13 = Utf8               Lhomo/efficio/jvm/MyLoop;
//           #14 = Utf8               forLoop
//           #15 = Utf8               ()V
//           #16 = Utf8               i
//           #17 = Utf8               StackMapTable
//           #18 = Utf8               forLoop2
//           #19 = Utf8               SourceFile
//           #20 = Utf8               MyLoop.java
//           #21 = NameAndType        #7:#15         // "<init>":()V
//           #22 = NameAndType        #5:#6          // len:I
//           #23 = Utf8               homo/efficio/jvm/MyLoop
//           #24 = Utf8               java/lang/Object
//           {
//private int len;
//        descriptor: I
//        flags: (0x0002) ACC_PRIVATE
//
//public homo.efficio.jvm.MyLoop(int);
//        descriptor: (I)V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=2, args_size=2
//        0: aload_0
//        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
//        4: aload_0
//        5: iload_1
//        6: putfield      #2                  // Field len:I
//        9: return
//        LineNumberTable:
//        line 11: 0
//        line 12: 4
//        line 13: 9
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        0      10     0  this   Lhomo/efficio/jvm/MyLoop;
//        0      10     1   len   I
//
//public void forLoop();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=2, args_size=1
//        0: iconst_0
//        1: istore_1
//        2: iload_1
//        3: aload_0
//        4: getfield      #2                  // Field len:I
//        7: if_icmpge     16
//        10: iinc          1, 1
//        13: goto          2
//        16: return
//        LineNumberTable:
//        line 16: 0
//        line 19: 16
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        2      14     1     i   I
//        0      17     0  this   Lhomo/efficio/jvm/MyLoop;
//        StackMapTable: number_of_entries = 2
//        frame_type = 252 /* append */
//        offset_delta = 2
//        locals = [ int ]
//        frame_type = 250 /* chop */
//        offset_delta = 13
//
//public void forLoop2();
//        descriptor: ()V
//        flags: (0x0001) ACC_PUBLIC
//        Code:
//        stack=2, locals=3, args_size=1
//        0: iconst_0
//        1: istore_1
//        2: aload_0
//        3: getfield      #2                  // Field len:I
//        6: istore_2
//        7: iload_1
//        8: iload_2
//        9: if_icmpge     18
//        12: iinc          1, 1
//        15: goto          7
//        18: return
//        LineNumberTable:
//        line 22: 0
//        line 25: 18
//        LocalVariableTable:
//        Start  Length  Slot  Name   Signature
//        2      16     1     i   I
//        7      11     2   len   I
//        0      19     0  this   Lhomo/efficio/jvm/MyLoop;
//        StackMapTable: number_of_entries = 2
//        frame_type = 253 /* append */
//        offset_delta = 7
//        locals = [ int, int ]
//        frame_type = 249 /* chop */
//        offset_delta = 10
//        }
//        SourceFile: "MyLoop.java"
