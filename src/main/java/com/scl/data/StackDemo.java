package com.scl.data;

import java.util.IdentityHashMap;

/**
 * @author scl
 * @Date 2020/6/27
 * @Description
 */
public class StackDemo {


    private static class Data {
        String name;
        int age;
    }

    private static class StackType {
        static final int DEFAULT_SIZE = 50;
        Data[] datas = new Data[DEFAULT_SIZE + 1];
        int top;

        StackType() {
            this.top = 0;
        }

        /**
         * 栈是否为空
         */
        boolean isEmpty() {
            return top == 0;
        }

        /**
         * 栈是否已满
         */
        boolean isFull() {
            return top == datas.length;
        }

        /**
         * 清空栈
         */
        void clear() {
            top = 0;
        }

        /**
         * 释放空间
         */
        void free() {
            this.datas = null;
        }

        /**
         * 入栈
         */
        void push(Data data) {
            if (!isFull()) {
                this.datas[++top] = data;
            }
        }

        /**
         * 出栈
         */
        Data pop() {
            checkStack();
            return this.datas[top--];
        }

        /**
         * 获取栈顶元素
         */
        Data peek() {
            checkStack();
            return this.datas[top];
        }

        private void checkStack() {
            if (isEmpty()) {
                throw new RuntimeException("stack is empty");
            }

        }
    }
}

