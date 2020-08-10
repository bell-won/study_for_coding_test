package week9;

import java.io.*;
import java.util.*;

public class p4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<String, Double> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        List<String> keyList = new ArrayList<>();

        String s = br.readLine();

        while (s != null) {
            list.add(s);
            s = br.readLine();
        }
        Collections.sort(list);
        String base = list.get(0);
        int count = 1;
        for (int i = 1; i < list.size(); i++) {
            if (base.equals(list.get(i))) {
                count++;
            }
            else {
                double num = (100.0 / (double) list.size()) * (double) count;
                map.put(base, num);
                keyList.add(base);
                count = 1;
            }
            base = list.get(i);
            if (i == list.size() - 1) {
                double num = (100.0 / (double) list.size()) * (double) count;
                map.put(base, num);
                keyList.add(base);
                count = 1;
            }
        }

        for (int i = 0; i < map.size(); i++) {
            bw.write(keyList.get(i) + " " + String.format("%.4f", map.get(keyList.get(i))) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
