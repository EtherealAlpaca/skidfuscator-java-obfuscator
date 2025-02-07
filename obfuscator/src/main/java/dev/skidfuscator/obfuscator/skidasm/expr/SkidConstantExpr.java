package dev.skidfuscator.obfuscator.skidasm.expr;

import org.mapleir.ir.code.expr.ConstantExpr;
import org.objectweb.asm.Type;

public class SkidConstantExpr extends ConstantExpr {
    public SkidConstantExpr(Object cst) {
        super(cst);
    }

    public SkidConstantExpr(Object cst, Type type, boolean check) {
        super(cst, type, check);
    }

    public SkidConstantExpr(Object cst, Type type) {
        super(cst, type);
    }

    @Override
    public ConstantExpr copy() {
        return new SkidConstantExpr(this.getConstant(), this.getType(), false);
    }
}
