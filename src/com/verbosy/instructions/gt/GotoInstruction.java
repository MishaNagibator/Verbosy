package com.verbosy.instructions.gt;

import com.verbosy.compiler.VerbosyRuntime;
import com.verbosy.instructions.primitive.Instruction;
import com.verbosy.instructions.primitive.Label;

import java.util.function.Predicate;

public class GotoInstruction implements Instruction {
    private Label goToLabel;

    public Label getGoToLabel() {
        return goToLabel;
    }

    public Predicate<VerbosyRuntime> getGoToCondition() {
        return x -> true;
    }

    @Override
    public void execute(VerbosyRuntime runtime) {

    }

    public GotoInstruction(Label goToLabel) {
        this.goToLabel = goToLabel;
    }
}
