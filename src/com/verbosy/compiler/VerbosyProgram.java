package com.verbosy.compiler;

import com.verbosy.instructions.gt.GotoInstruction;
import com.verbosy.instructions.primitive.Instruction;
import com.verbosy.runtime.VerbosyRuntime;

import java.io.*;
import java.util.Arrays;

public final class VerbosyProgram implements Serializable {
    private Instruction[] instructions;
    private int currentInstructionIndex;
    private long serialVersionUID = 1L;

    protected VerbosyProgram(Instruction[] instructions) {
        this.instructions = instructions;
    }

    public Instruction[] getInstructions() {
        return Arrays.copyOf(instructions, instructions.length);
    }

    public void run(VerbosyRuntime runtime) {
        runtime.setStopped(false);

        while (!runtime.isStopped()) {
            stepOver(runtime);
        }
    }

    public int getCurrentInstructionIndex() {
        return currentInstructionIndex;
    }

    public Instruction getCurrentInstruction() {
        return instructions[getCurrentInstructionIndex()];
    }

    public void stepOver(VerbosyRuntime runtime) {
        if (runtime.isStopped()) {
            return;
        }

        try {
            getCurrentInstruction().execute(runtime);

            if (getCurrentInstruction() instanceof GotoInstruction) {
                GotoInstruction gotoInstruction = (GotoInstruction)getCurrentInstruction();
                if (gotoInstruction.getGoToCondition().test(runtime)) {
                    currentInstructionIndex = gotoInstruction.getGoToLabel().getInstructionIndex();
                    return;
                }
            }

            currentInstructionIndex++;
        } catch (IndexOutOfBoundsException e) {
            runtime.setStopped(true);
        }
    }

    public void saveToFile(String directory, String name) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(new File(directory, name), false));
        out.writeObject(this);
        out.close();
    }

}
