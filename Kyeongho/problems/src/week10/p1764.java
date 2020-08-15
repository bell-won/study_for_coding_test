package week10;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] str = s.split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        String[] strN = new String[n];
        ArrayList<String> strM = new ArrayList<>();
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            strN[i] = br.readLine();
        }
        for (int i = 0; i < m; i++) {
            strM.add(br.readLine());
        }

        Collections.sort(strM);

        for (int i = 0; i < strN.length; i++) {
            if (search(strN[i], 0, strM.size()-1, strM)) {
                result.add(strN[i]);
            }
        }

        Collections.sort(result);

        bw.write(result.size() + "\n");
        for (int i = 0; i < result.size(); i++) {
            bw.write(result.get(i) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    private static boolean search(String s, int start, int end, ArrayList<String> list) {
        boolean result = false;
        int mid = (end + start) / 2;
        if (start == end) {
            mid = end;
        }

        if (end < start) {
            result = false;
        }
        else {
            int tmp = s.compareTo(list.get(mid));
            if (tmp < 0) {
                result =  search(s, start, mid-1, list);
            }
            else if (tmp > 0) {
                result =  search(s, mid+1, end, list);
            }
            else {
                result = true;
            }
        }
        return result;
    }
}
