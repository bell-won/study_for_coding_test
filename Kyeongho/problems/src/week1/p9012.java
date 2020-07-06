package week1;

import java.io.*;
import java.util.Stack;

public class p9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stack = new Stack<>();
        Stack<String> rightStack = new Stack<>();
        boolean isVps = true;

        int count = Integer.parseInt(reader.readLine());

        for (int i = 0; i < count; i++) {
            String s = reader.readLine();
            String[] str = s.split("");
            for (int j = 0; j < str.length; j++) {
                stack.push(str[j]);
            }

            while (!stack.isEmpty()) {
                if (stack.peek().equals(")")) {
                    rightStack.push(stack.pop());
                } else {
                    if (!rightStack.isEmpty()) {
                        stack.pop();
                        rightStack.pop();
                    } else {
                        stack.clear();
                        isVps = false;
                    }
                }
            }
            if (!rightStack.isEmpty()) {
                isVps = false;
                rightStack.clear();
            }
            if (isVps) {
                writer.write("YES\n");
            }
            else {
                writer.write("NO\n");
            }
            isVps = true;
        }
        reader.close();
        writer.flush();
        writer.close();

    }
}
