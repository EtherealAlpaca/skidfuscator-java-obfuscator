package dev.skidfuscator.obfuscator.creator;

import dev.skidfuscator.obfuscator.skidasm.cfg.SkidBlockFactory;
import org.mapleir.asm.MethodNode;
import org.mapleir.ir.algorithms.BoissinotDestructor;
import org.mapleir.ir.algorithms.LocalsReallocator;
import org.mapleir.ir.cfg.ControlFlowGraph;
import org.mapleir.ir.cfg.SSAFactory;
import org.mapleir.ir.cfg.builder.ControlFlowGraphBuilder;

public class SkidFlowGraphBuilder extends ControlFlowGraphBuilder {

    public SkidFlowGraphBuilder(MethodNode method) {
        super(method);
    }

    public SkidFlowGraphBuilder(MethodNode method, SSAFactory SSAFactory) {
        super(method, SSAFactory);
    }

    public SkidFlowGraphBuilder(MethodNode method, SSAFactory SSAFactory, boolean optimise) {
        super(method, SSAFactory, optimise);
    }

    public static ControlFlowGraph build(MethodNode method) {
        ControlFlowGraphBuilder builder = new SkidFlowGraphBuilder(method, SkidBlockFactory.INSTANCE);
        final ControlFlowGraph cfg = builder.buildImpl();
        BoissinotDestructor.leaveSSA(cfg);
        LocalsReallocator.realloc(cfg);

        return cfg;
    }
}