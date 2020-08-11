package week5;

import java.io.*;

public class p14501 {
    static int[] times;
    static int[] price;
    static boolean[] visited;
    static int sum = 0;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int days = Integer.parseInt(br.readLine());
        times = new int[days];
        price = new int[days];
        visited = new boolean[days];

        for (int i = 0; i < days; i++) {
            String s = br.readLine();
            String[] str = s.split(" ");
            times[i] = Integer.parseInt(str[0]);
            price[i] = Integer.parseInt(str[1]);
        }

        for (int i = 0; i < times.length; i++) {
            if (i + times[i] > times.length) {
                continue;
            }
            visited[i] = true;
            sum += price[i];
            sumPrice(i + times[i]);
            visited[i] = false;
            sum -= price[i];
        }
        bw.write(max + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static void sumPrice(int index) {
        for (int i = index; i < times.length; i++) {
            if (visited[i] || i + times[i] > times.length) {
                continue;
            }
            visited[i] = true;
            sum += price[i];
            sumPrice(i + times[i]);
            visited[i] = false;
            sum -= price[i];
        }

        if (sum > max) {
            max = sum;
        }
    }
}
