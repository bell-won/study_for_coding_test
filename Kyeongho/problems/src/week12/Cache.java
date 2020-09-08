package week12;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Cache {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int cacheSize = Integer.parseInt(br.readLine());
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        int resultTime = solution(cacheSize, cities);
        bw.write(resultTime + "\n");

        br.close();
        bw.flush();
        bw.close();
    }

    private static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> cache = new LinkedList<>();
        if (cacheSize <= 0) {
            answer = cities.length * 5;
        }
        else {
            for (int i = 0; i < cities.length; i++) {
                String s = cities[i].toLowerCase();
                if (cache.contains(s)) {
                    cache.remove(s);
                    cache.offer(s);
                    answer++;
                } else {
                    if (cache.size() < cacheSize) {
                        cache.offer(s);
                    } else {
                        cache.poll();
                        cache.offer(s);
                    }
                    answer += 5;
                }
            }
        }
        return answer;
    }
}
