package week9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class p14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        List<String> groupS = new ArrayList<>();
        String[] data = new String[m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            groupS.add(br.readLine());
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = br.readLine();
            if (groupS.contains(data[i])) {
                count++;
            }
        }

        bw.write(count + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
