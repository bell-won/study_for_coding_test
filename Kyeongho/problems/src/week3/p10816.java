package week3;

import java.io.*;
import java.util.Arrays;

public class p10816 {
    private static int searchLower (int[] arr, int n, int start, int end) {
        int mid = 0;
        while (start < end) {
            mid = (end + start) / 2;
            if (arr[mid] < n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (arr[end] != n) {
            return -1;
        }
        else {
            return end;
        }
    }

    private static int searchUpper (int[] arr, int n, int start, int end) {
        int mid = 0;
        while (start < end) {
            mid = (end + start) / 2;
            if (arr[mid] <= n) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (arr[end] == n) {
            return end + 1;
        }
        else {
            return end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int cardCount = Integer.parseInt(br.readLine());
        int[] cards = new int[cardCount];
        String s = br.readLine();
        String[] str = s.split(" ");
        for (int i = 0; i < cards.length; i++) {
            cards[i] = Integer.parseInt(str[i]);
        }

        Arrays.sort(cards);

        int selectCount = Integer.parseInt(br.readLine());

        int[] counts = new int[selectCount];
        s = br.readLine();
        str = s.split(" ");
        for (int i = 0; i < selectCount; i++) {
            int num = Integer.parseInt(str[i]);
            int lower = searchLower(cards, num, 0, cards.length-1);
            if (lower >= 0) {
                int upper = searchUpper(cards, num, 0, cards.length-1);
                counts[i] = upper - lower;
            }
        }
        for (int i = 0; i < counts.length; i++) {
            bw.write(counts[i] + " ");
        }
        bw.write("\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
