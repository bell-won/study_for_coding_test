package week4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class p5639 {
    public static class Node {
        int data;
        Node left;
        Node right;
        public Node() {
            this.left = null;
            this.right = null;
        }
        public Node(int data) {
            super();
            this.data = data;
        }
    }
    public static Node setTree (Node node, Queue<Integer> lq, Queue<Integer> rq) {
        Queue<Integer> left = new LinkedList<>();
        Queue<Integer> right = new LinkedList<>();
        if (!lq.isEmpty()) {
            Node baseL = new Node(lq.poll());
            while (!lq.isEmpty()) {
                int tmp = lq.poll();
                if (baseL.data > tmp) {
                    left.offer(tmp);
                } else {
                    right.offer(tmp);
                }
            }
            node.left = setTree(baseL, left, right);
        }
        left.clear();
        right.clear();
        if (!rq.isEmpty()) {
            Node baseR = new Node(rq.poll());
            while (!rq.isEmpty()) {
                int tmp = rq.poll();
                if (baseR.data > tmp) {
                    left.offer(tmp);
                } else {
                    right.offer(tmp);
                }
            }
            node.right = setTree(baseR, left, right);
        }
        return node;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Node> stack = new Stack<>();
        Queue<Integer> lq = new LinkedList<>();
        Queue<Integer> rq = new LinkedList<>();

        int rootNumber = Integer.parseInt(in.nextLine());
        while (in.hasNextLine()) {
            try {
                int number = Integer.parseInt(in.nextLine());
                if (number > rootNumber) {
                    rq.offer(number);
                } else {
                    lq.offer(number);
                }
            } catch (Exception e) {
                break;
            }
        }

        Node root = new Node(rootNumber);
        Node tree = setTree(root, lq, rq);
        stack.push(tree);

        while (!stack.isEmpty()) {
            Node base = stack.peek();
            if (base.left != null) {
                stack.push(base.left);
            }
            else if (base.right != null) {
                stack.push(base.right);
            }
            else {
                System.out.println(base.data);
                stack.pop();
                if (!stack.isEmpty()) {
                    if (stack.peek().left == null) {
                        stack.peek().right = null;
                    }
                    else {
                        stack.peek().left = null;
                    }
                }
            }
        }

        in.close();
    }
}
