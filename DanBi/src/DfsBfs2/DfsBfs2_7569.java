package DfsBfs2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfs2_7569 {
	static int[][][] box;
	static boolean[][][] visit;
	static int row, col, height;
	static Queue<int[]> qu = new LinkedList<int[]>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		height = Integer.parseInt(st.nextToken());
		box = new int[row][col][height];
		visit = new boolean[row][col][height];
		for (int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < col; j++) {
					box[i][j][k] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for (int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (box[i][j][k] == 1) {
						qu.offer(new int[] { i, j, k });
						visit[i][j][k] = true;
					}
				}
			}
		}

		bfs();
		int answer = 0;
		loop: for (int k = 0; k < height; k++) {
			for (int i = 0; i < row; i++) {

				for (int j = 0; j < col; j++) {
					if (box[i][j][k] == 0) {
						answer = -1;
						break loop;
					}
					if (box[i][j][k] > answer) {
						answer = box[i][j][k] - 1;

					}
				}
			}
		}
		System.out.println(answer);

	}

	private static void bfs() {
		int[] dr = { -1, 0, 1, 0, 0, 0 };
		int[] dc = { 0, 1, 0, -1, 0, 0 };
		int[] dh = { 0, 0, 0, 0, 1, -1 };
		while (!qu.isEmpty()) {
			int[] cur = qu.poll();
			for (int k = 0; k < dc.length; k++) {
				int r = cur[0] + dr[k];
				int c = cur[1] + dc[k];
				int h = cur[2] + dh[k];
				if (0 <= c && c < col && 0 <= r && r < row&& 0 <= h && h < height && visit[r][c][h] == false && box[r][c][h] == 0) {
					visit[r][c][h] = true;
					box[r][c][h] = box[cur[0]][cur[1]][cur[2]] + 1;
					qu.add(new int[] { r, c, h });
				}
			}
		}
	}
}
