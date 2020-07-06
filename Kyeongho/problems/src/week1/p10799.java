package week1;

import java.io.*;
import java.util.Stack;

public class p10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        boolean lastIsRight = false;
        int totalLazor = 0;
        int barCount = 0;
        int resultCount = 0;

        String input = br.readLine();
        String[] str = input.split("");
        for (int i = 0; i < str.length; i++) {
            stack.push(str[i]);
        }
        while (!stack.isEmpty()) {
            if (stack.peek().equals(")")) {
                rightStack.push(stack.pop());
                lastIsRight = true;
            }
            else {
                if (lastIsRight) {
                    if (!rightStack.isEmpty()) {
                        totalLazor += 1 * (rightStack.size() - 1);
                    }
                    stack.pop();
                    rightStack.pop();
                    lastIsRight = false;
                }
                else {
                    barCount++;
                    stack.pop();
                    rightStack.pop();
                }
            }
        }
        resultCount = totalLazor + barCount;
        bw.write(resultCount + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}

