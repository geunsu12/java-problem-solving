package BJ;

import java.util.*;
import java.io.*;

public class bj1918 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (int i=0;i<str.length();i++) {
            char nowStr = str.charAt(i);

            switch (nowStr) {
                case '+':
                case '-':
                case '*':
                case '/':
                    while (!stack.isEmpty() && priority(stack.peek()) >= priority(nowStr)) {
                        sb.append(stack.pop());
                    }
                    stack.add(nowStr);
                    break;
                case '(':
                    stack.add(nowStr);
                    break;
                case ')':
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    sb.append(nowStr);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb.toString());
    }

    public static int priority(char operator) {
        if(operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return -1;
    }
}

