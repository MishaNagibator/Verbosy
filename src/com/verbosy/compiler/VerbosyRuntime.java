package com.verbosy.compiler;

import java.io.PrintStream;

public interface VerbosyRuntime {
    VerbosyValue getCurrent();

    void setCurrent(VerbosyValue value);

    VerbosyValue[] getMemory();

    PrintStream getOutput();

    VerbosyValue getNextInput();

    boolean isStopped();

    void setStopped(boolean value);

    void showErrorMessage(String message);
}