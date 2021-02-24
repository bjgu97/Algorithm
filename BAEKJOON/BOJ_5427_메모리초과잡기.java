// 5427, 불

import java.io.*;
import java.util.*;

public class BOJ_5427_메모리초과잡기 {

	static int T, W, H;
	static char[][] map;
	static int[][][] visitedAndFired;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static Queue<Integer[]> fire;
	static Queue<Integer[]> sg;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		for (int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map = new char[H][W]; // 건물 배열
			// [H][W][0]: 상근, [H][W][1]: 불
			visitedAndFired = new int[H][W][2];	
			
			fire = new LinkedList<Integer[]>(); // 불 위치
			sg = new LinkedList<Integer[]>(); // 상근 위치
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					if (map[i][j] == '*')
						fire.offer(new Integer[] { i, j });
					if (map[i][j] == '@')
						sg.offer(new Integer[] { i, j });
				}
			}

//			for (char[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			// 입력 끝
			fireBFS();

//			for (int[] row : fired) {
//				System.out.println(Arrays.toString(row));
//			}
			
			int res = sgBFS();
			// 탈출 못 했으면 IMPOSSIBLE
			if (res==-1) {
				sb.append("IMPOSSIBLE\n");
			}else {
				sb.append(res+"\n");
			}
		}
		System.out.println(sb);
	}

	static void fireBFS() {
		while (!fire.isEmpty()) {
			Integer[] now = fire.poll();
			int x = now[0];
			int y = now[1];
			//System.out.println("x: " + x + " y: " + y);

			if (visitedAndFired[x][y][1] == 0) visitedAndFired[x][y][1] = 1;
//			if (fired[x][y] == 0) {
//				fired[x][y] = 1;
//			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 범위
				if (0 > nx || nx >= H || 0 > ny || ny >= W)
					continue;
				// 다음 좌표가 벽이 아니고, 불길이 퍼지지 않았다면
				if (map[nx][ny] != '#' && visitedAndFired[nx][ny][1] == 0) {
					// 불 붙는다
					visitedAndFired[nx][ny][1] = visitedAndFired[x][y][1] + 1;
					fire.offer(new Integer[] { nx, ny });
					map[nx][ny] = '*';
				}
				
			}
	}
	}
	
	// 상근이 움직임
	static int sgBFS() {
		while (!sg.isEmpty()) {
			Integer[] now = sg.poll();
			//System.out.println(Arrays.toString(now));
			int x = now[0];
			int y = now[1];
			if (visitedAndFired[x][y][0] == 0) visitedAndFired[x][y][0] = 1;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				// 다음 좌표가 범위 바깥 --> 탈출 가능 --> 1초 더해서 리턴
				if (0 > nx || nx >= H || 0 > ny || ny >= W) {
					return visitedAndFired[x][y][0];	// 처음에 방문 처리하면서 visited[x][y] = 1 한 게 사실 상근이가 이동한 건 아니니까 -1..해줘야하는데..? 나가는 데에도 1초가 필요.. -1 +1 = 0 그냥 리턴
				}
					
				// 빈 공간이고, 불길이 없으면 이동 가능
				if (map[nx][ny] == '.' && map[nx][ny] != '*') {
					visitedAndFired[nx][ny][0] = visitedAndFired[x][y][0] + 1;
					sg.offer(new Integer[] { nx, ny });
				}
			}
//			for (int[] row : visited) {
//				System.out.println(Arrays.toString(row));
//			}
//			System.out.println();
		}
		// 탈출 못 하고, 상근이 남지 않았으면 -1 리턴
//		System.out.println("탈출 불가넝");
		return -1;
	}
}
