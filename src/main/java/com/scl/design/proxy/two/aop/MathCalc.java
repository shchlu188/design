package com.scl.design.proxy.two.aop;

/***********************************
 * @QQ 1578380573
 * @author scl
 * @Date 2020/7/5
 * @Description
 **********************************/
public class MathCalc implements Calc {
    /**
     * @param n
     * @param m
     * @param execInstruction
     * @return
     */
    public int calc(int n, int m, int execInstruction) {
        switch (execInstruction) {
            case Instruction.ADD:
                return n + m;
            case Instruction.DIV:
                return n / m;
            case Instruction.MUL:
                return n * m;
            case Instruction.SUB:
                return n - m;
            default:
                throw new IllegalArgumentException("execInstruction is not valid");
        }
    }

    public static final class Instruction {
        public static final int ADD = 1;
        public static final int SUB = 2;
        public static final int DIV = 3;
        public static final int MUL = 4;
    }

}
