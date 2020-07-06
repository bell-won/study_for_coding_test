package week3;

import java.io.*;
import java.util.Arrays;

public class p2110 {
    private static long searchDistance(long[] arr, int start, int end, int wifiCount) {
        long mid = 0;
        long low = 1;
        long high = arr[end] - arr[start];
        long result = 0;

        /**
         * isFinished = -1, 공유기 개수가 부족한 상태
         * isFinished = 1, 공유기 개수가 초과한 상태
         * isFinished = 0, 공규기 개수
         */
        while (low <= high) {
            mid = (high + low) / 2;
            int isFinished = setWifi(arr, mid, wifiCount);
            if (isFinished < 0) {
                high = mid - 1;
            }
            else if (isFinished >= 0) {
                low = mid + 1;
                result = mid;
            }
        }
        return result;
    }
    private static int setWifi(long[] arr, long distance, int wifiCount) {
        int count = 1;
        long base = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - base >= distance) {
                base = arr[i];
                count++;
            }
        }
        if (count > wifiCount) {
            return 1;
        }
        else if (count < wifiCount) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        long[] homes = new long[Integer.parseInt(str[0])];
        int wifies = Integer.parseInt(str[1]);
        for (int i = 0; i < homes.length; i++) {
            homes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(homes);
        long result = searchDistance(homes, 0, homes.length-1, wifies);
        bw.write(result + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
