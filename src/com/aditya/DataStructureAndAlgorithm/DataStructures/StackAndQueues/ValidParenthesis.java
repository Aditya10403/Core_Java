package com.aditya.DataStructureAndAlgorithm.DataStructures.StackAndQueues;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (ch == ')') {
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                }
                if (ch == '}') {
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                }
                if (ch == ']') {
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                }
            }
        }
        return stack.isEmpty();
    }
    // Min add
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.size();
    }
}
