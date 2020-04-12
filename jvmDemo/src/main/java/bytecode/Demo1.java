/*
 * @(#) Demo1.java 2020-04-11
 *
 * Copyright 2020 NetEase.com, Inc. All rights reserved.
 */

package bytecode;

/**
 * @author xyw55
 * @version 2020-04-11
 */
public class Demo1 {

    /**
     *  javap -v Demo1.class
     * Classfile /Users/xyw55/code/java/study/jvmDemo/target/classes/bytecode/Demo1.class
     *   Last modified Apr 11, 2020; size 673 bytes
     *   MD5 checksum 3971c5f8bf1961bba5225bb7a2e03a84
     *   Compiled from "Demo1.java"
     * public class bytecode.Demo1
     *   minor version: 0
     *   major version: 52
     *   flags: ACC_PUBLIC, ACC_SUPER
     * Constant pool:
     *    #1 = Methodref          #6.#27         // java/lang/Object."<init>":()V
     *    #2 = String             #28            // ab1
     *    #3 = Fieldref           #29.#30        // java/lang/System.out:Ljava/io/PrintStream;
     *    #4 = Methodref          #31.#32        // java/io/PrintStream.println:(Z)V
     *    #5 = Class              #33            // bytecode/Demo1
     *    #6 = Class              #34            // java/lang/Object
     *    #7 = Utf8               <init>
     *    #8 = Utf8               ()V
     *    #9 = Utf8               Code
     *   #10 = Utf8               LineNumberTable
     *   #11 = Utf8               LocalVariableTable
     *   #12 = Utf8               this
     *   #13 = Utf8               Lbytecode/Demo1;
     *   #14 = Utf8               main
     *   #15 = Utf8               ([Ljava/lang/String;)V
     *   #16 = Utf8               args
     *   #17 = Utf8               [Ljava/lang/String;
     *   #18 = Utf8               a
     *   #19 = Utf8               Ljava/lang/String;
     *   #20 = Utf8               b
     *   #21 = Utf8               StackMapTable
     *   #22 = Class              #17            // "[Ljava/lang/String;"
     *   #23 = Class              #35            // java/lang/String
     *   #24 = Class              #36            // java/io/PrintStream
     *   #25 = Utf8               SourceFile
     *   #26 = Utf8               Demo1.java
     *   #27 = NameAndType        #7:#8          // "<init>":()V
     *   #28 = Utf8               ab1
     *   #29 = Class              #37            // java/lang/System
     *   #30 = NameAndType        #38:#39        // out:Ljava/io/PrintStream;
     *   #31 = Class              #36            // java/io/PrintStream
     *   #32 = NameAndType        #40:#41        // println:(Z)V
     *   #33 = Utf8               bytecode/Demo1
     *   #34 = Utf8               java/lang/Object
     *   #35 = Utf8               java/lang/String
     *   #36 = Utf8               java/io/PrintStream
     *   #37 = Utf8               java/lang/System
     *   #38 = Utf8               out
     *   #39 = Utf8               Ljava/io/PrintStream;
     *   #40 = Utf8               println
     *   #41 = Utf8               (Z)V
     * {
     *   public bytecode.Demo1();
     *     descriptor: ()V
     *     flags: ACC_PUBLIC
     *     Code:
     *       stack=1, locals=1, args_size=1
     *          0: aload_0
     *          1: invokespecial #1                  // Method java/lang/Object."<init>":()V
     *          4: return
     *       LineNumberTable:
     *         line 13: 0
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0       5     0  this   Lbytecode/Demo1;
     *
     *   public static void main(java.lang.String[]);
     *     descriptor: ([Ljava/lang/String;)V
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=3, locals=3, args_size=1
     *          0: ldc           #2                  // String ab1
     *          2: astore_1
     *          3: ldc           #2                  // String ab1
     *          5: astore_2
     *          6: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *          9: aload_1
     *         10: aload_2
     *         11: if_acmpne     18
     *         14: iconst_1
     *         15: goto          19
     *         18: iconst_0
     *         19: invokevirtual #4                  // Method java/io/PrintStream.println:(Z)V
     *         22: return
     *       LineNumberTable:
     *         line 15: 0
     *         line 16: 3
     *         line 17: 6
     *         line 18: 22
     *       LocalVariableTable:
     *         Start  Length  Slot  Name   Signature
     *             0      23     0  args   [Ljava/lang/String;
     *             3      20     1     a   Ljava/lang/String;
     *             6      17     2     b   Ljava/lang/String;
     *       StackMapTable: number_of_entries = 2
     *         frame_type = 255 // full_frame
     *          offset_delta =18
     *          locals =[class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
     *          stack =[class java/io/PrintStream ]
     *      frame_type =255 // full_frame
     *          offset_delta =0
     *          locals =[class "[Ljava/lang/String;", class java/lang/String, class java/lang/String ]
     *          stack =[class java/io/PrintStream,int ]
     }
     *SourceFile:"Demo1.java"
     * @param args
     */
    public static void main(String[] args) {
        String a = "a" + "b1";
        String b = "ab1";
        System.out.println(a == b);
    }
}
