package week11;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class p9205 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());

        for (int i = 0; i < count; i++) {
            int storeCount = Integer.parseInt(br.readLine());
            int[][] stores = new int[storeCount][2];
            String s = br.readLine();
            String[] str = s.split(" ");
            int startX = Integer.parseInt(str[0]);
            int startY = Integer.parseInt(str[1]);
            for (int j = 0; j < stores.length; j++) {
                s = br.readLine();
                str = s.split(" ");
                stores[j][0] = Integer.parseInt(str[0]);
                stores[j][1] = Integer.parseInt(str[1]);
            }
            s = br.readLine();
            str = s.split(" ");
            int endX = Integer.parseInt(str[0]);
            int endY = Integer.parseInt(str[1]);

            if (drinkingBeer(startX, startY, stores, endX, endY)) {
                bw.write("happy\n");
            } else {
                bw.write("sad\n");
            }
        }


        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean drinkingBeer(int sx, int sy, int[][] stores, int ex, int ey) {
        boolean isSuccess = false;
        Queue<Integer> baseX = new LinkedList<>();
        Queue<Integer> baseY = new LinkedList<>();
        boolean[] isUsed = new boolean[stores.length];

        baseX.offer(sx);
        baseY.offer(sy);

        while (!baseX.isEmpty()) {
            int startX = baseX.poll();
            int startY = baseY.poll();
            int distance = Math.abs(startX - ex) + Math.abs(startY - ey);
            if (distance <= 1000) {
                isSuccess = true;
                return isSuccess;
            }
            else {
                for (int i = 0; i < stores.length; i++) {
                    int nextX = stores[i][0];
                    int nextY = stores[i][1];
                    if (!isUsed[i]) {
                        distance = Math.abs(startX - nextX) + Math.abs(startY - nextY);
                        if (distance <= 1000) {
                            baseX.offer(nextX);
                            baseY.offer(nextY);
                            isUsed[i] = true;
                        }
                    }
                }
            }
        }
        return isSuccess;
    }
}
