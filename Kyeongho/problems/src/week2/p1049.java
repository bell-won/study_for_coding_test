package week2;

import java.io.*;
import java.util.Arrays;

public class p1049 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] str = s.split(" ");
        int brokenLine = Integer.parseInt(str[0]);
        int buyLine = Integer.parseInt(str[1]);
        int[] packagePrice = new int[buyLine];
        int[] onePrice = new int[buyLine];


        for (int i = 0; i < buyLine; i++) {
            s = br.readLine();
            str = s.split(" ");
            packagePrice[i] = Integer.parseInt(str[0]);
            onePrice[i] = Integer.parseInt(str[1]);
        }
        Arrays.sort(packagePrice);
        int packages = packagePrice[0];
        Arrays.sort(onePrice);
        int one = onePrice[0];
        int onlyOne = one * brokenLine;
        int shake = (packages * (brokenLine / 6)) + (one * (brokenLine % 6));
        int onlyPack = 0;
        if (brokenLine % 6 != 0) {
            onlyPack = packages * ((brokenLine / 6) + 1);
        }
        else {
            onlyPack = packages * (brokenLine / 6);
        }
        int[] totalPrice = {onlyOne, onlyPack, shake};
        Arrays.sort(totalPrice);

        bw.write(totalPrice[0] + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
