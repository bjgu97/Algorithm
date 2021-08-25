import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {
	static class Point {
		int r; // 위치1
		int c; // 위치2
		int amount; // 미세먼지양
		
		Point(int r, int c, int amount) {
			this.r = r;
			this.c = c;
			this.amount = amount;
		}
		
		public String toString(int r, int c, int amount) {
			return "[r: " + r + "c: " + c + "amount: " + amount + "]";
		}
	}
	
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> airQueue = new LinkedList<>();
	
	static int R, C, T;
	static int[][] map;
	static int[][] tmpMap;
	static boolean[][] visited;
	
	static int pos1;
	static int pos2;
	static Point airP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); 
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken()); 
		
		map = new int[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				
				if(map[r][c] == -1) { // 공기청정기 위치
					airQueue.add(new Point(r, c, map[r][c])); // 추가
				}
			}
		}
		
		// 공기청정기 위치 저장.
		pos1 = airQueue.poll().r;
		pos2 = airQueue.poll().r;
		
		for(int t = 0; t < T; t++) {
			
			find(); // 미세먼지 위치 찾기 
			
			spread(); // 확산
			
			rotate(); // 공기청정기 작동
		}
		
		int answer = 0;
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(map[r][c]>0)
					answer += map[r][c];
			}
		}
		
		System.out.println(answer);
			
	}
	
	static void find() {
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {				
				if(map[r][c] != 0 && map[r][c] != -1) { // 미세먼지
					queue.add(new Point(r, c, map[r][c])); // 추가
				}
			}
		}
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	// 1. 확산
	static void spread() {
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			int r = p.r;
			int c = p.c;
			int amount = p.amount;
			
			int numDir = 0; // 확산 방향 개수
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= R || nc >= C) // 위치 벗어나면
					continue;
				
				if(map[nr][nc] == -1) // 공기청정기면
					continue;
				
				map[nr][nc] += amount/5; // 확산
				numDir++; // 확산 방향 개수
			}
			
			map[r][c] -= (amount / 5) * numDir;
		}
	}

	
	static void rotate() {
		// 윗 공기청정기 회전
		for(int i = pos1 -1; i > 0; i--) {
			map[i][0] = map[i-1][0];
		}
		for(int i = 0; i < C-1; i++) {
			map[0][i] = map[0][i+1];
		}
		for(int i = 0; i < pos1; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		for(int i = C-1; i > 1; i--) {
			map[pos1][i] = map[pos1][i-1];
		}
		map[pos1][1] = 0;
		
		// 아래 공기청정기 회전
		for(int i = pos2 + 1; i < R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		for(int i = 0; i < C-1; i++) {
			map[R-1][i] = map[R-1][i+1];
		}
		for(int i = R-1; i > pos2; i--) {
			map[i][C-1] = map[i-1][C-1];
		}
		for(int i = C-1; i > 1; i--) {
			map[pos2][i] = map[pos2][i-1];
		}
		map[pos2][1] = 0;
	}
}
