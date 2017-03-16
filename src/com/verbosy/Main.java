package com.verbosy;

import com.verbosy.compiler.CompilerErrorException;
import com.verbosy.compiler.VerbosyCompiler;
import com.verbosy.compiler.VerbosyProgram;
import com.verbosy.runtime.StandardRuntime;
import com.verbosy.runtime.VerbosyRuntime;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        String code = "~0 /14 :a: ^14 i >0b /14* >a :b: v14 :c: \\14* o v14 >0a >c";
//        String code = "~H o ~e o ~l o ~l o ~o o ~W o ~o o ~r o ~l o ~d o";
//        String code = "~0 /0 ~10 /1 :a: ^0 o \\0 -1 >-a";
//        String code = "~-10 o";
//        String code = "~` /3 ^3 o";
        test1();
    }

    private static void test1() {
        try {
            VerbosyProgram prog = VerbosyProgram.readFromFile("/Users/mulangsu/Desktop/", "program.vp");
            StandardRuntime runtime = new StandardRuntime("", 10);
            prog.run(runtime);
        } catch (IOException |  ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
