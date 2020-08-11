package week6;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class p10546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int playerCount = Integer.parseInt(br.readLine());
        ArrayList<String> player = new ArrayList<>();
        ArrayList<String> successor = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            player.add(br.readLine());
        }

        for (int i = 0; i < playerCount-1; i++) {
            successor.add(br.readLine());
        }

        Collections.sort(player);
        Collections.sort(successor);
        boolean finished = false;
        for (int i = 0; i < successor.size(); i++) {
            if (!player.get(i).equals(successor.get(i))) {
                finished = true;
                bw.write(player.get(i) + "\n");
                break;
            }
        }
        if (!finished) {
            bw.write(player.get(player.size()-1) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
