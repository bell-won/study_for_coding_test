package week5;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p10819 {
    static ArrayList<Integer> resultList = new ArrayList<>();
    static boolean[] visited;
    static int[] numbers;
    static int[] sorting;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());
        numbers = new int[size];
        visited = new boolean[size];
        sorting = new int[size];
        String s = br.readLine();
        String[] str = s.split(" ");

        for (int i = 0; i < str.length; i++) {
            numbers[i] = Integer.parseInt(str[i]);
        }
        for (int i = 0; i < numbers.length; i++) {
            visited[i] = true;
            searchSum(i, 0);
            visited[i] = false;
        }
        Collections.sort(resultList);
        bw.write(resultList.get(resultList.size()-1) + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void searchSum(int index, int count) {
        sorting[count] = numbers[index];
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            searchSum(i, count+1);
            visited[i] = false;
        }
        if (count == numbers.length - 1) {
            resultList.add(arraySum(sorting));
        }
    }

    private static int arraySum(int[] arr) {
        int sum = 0;

        for (int i = 1; i < arr.length; i++) {
            sum += Math.abs(arr[i-1] - arr[i]);
        }
        return sum;
    }
}
