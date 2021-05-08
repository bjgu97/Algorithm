import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_17144_미세먼지안녕 {
	static class Point {
		int r;
		int c;
		int time;
		
		Point(int r, int c, int time) {
			this.r = r;
			this.c = c;
			this.time = time;
		}
		
		public String toString(int r, int c, int time) {
			return "[r: " + r + "c: " + c + "time: " + time + "]";
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
		R = Integer.parseInt(st.nextToken()); // 행
		C = Integer.parseInt(st.nextToken()); // 열
		
		T = Integer.parseInt(st.nextToken()); // 지난 시간(초)
		
		map = new int[R][C];
		tmpMap = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r =0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] != 0 && map[r][c] != -1) { // 미세먼지이면
					queue.add(new Point(r, c, 0)); //큐에 추가
				}
				if(map[r][c] == -1) { // 공기청정기 위치 기억
					airQueue.add(new Point(r, c, 0));
				}
			}
		}
		
		bfs();		
			
	}
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	
	static void bfs() {
		airP = airQueue.poll();
		pos1 = airP.r;
		airP = airQueue.poll();
		pos2 = airP.r;
		int tempTime = 0;
		
		while(!queue.isEmpty()) {
			// 미세먼지 확산
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int time = p.time;
			
			System.out.println("time: " + time);
			if(time == T) // t초 지나면 종료!
				break; 
			
			/// 미세먼지 확산 ///
			int numDir = 0;
			for(int d= 0; d < deltas.length; d++) { // 인접한 네 방향으로 확산
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];

				if(nr < 0 || nc < 0 || nr >= R || nc >= C)
					continue;

				if(map[nr][nc] != -1) {
					numDir++;
					tmpMap[nr][nc] += map[r][c] / 5;
					queue.add(new Point(nr, nc, time+1));
				}
			} 
			tmpMap[r][c] += (map[r][c] - (map[r][c] / 5) * numDir);
			
			
			/// 바람 돌리기 /// 
			//System.out.println("pos1, pos2: " + pos1 + "," + pos2);
			if(tempTime == time) {
				System.out.println("!!!!!!!! time: " + time);
				for(int[] a : tmpMap)
					System.out.println(Arrays.toString(a));
				System.out.println();
				rotate(pos1, pos2);
				tempTime++;
				for(int[] a : tmpMap)
					System.out.println(Arrays.toString(a));
				System.out.println();
				System.out.println("---------------------");
			}
		}
		Integer.tos
		
	}
	
	static void rotate(int pos1, int pos2) { // 2, 3
		int tmp1 = tmpMap[pos1][0]; // 시작값 저장 하고
		
		// 회전
		for(int i = 0; i < pos1; i++) {
			tmpMap[i+1][0] = tmpMap[i][0];
		}
		
		for(int i = 0; i < C-1; i++) {
			tmpMap[0][i] = tmpMap[0][i+1];
		}
		
		for(int i = 0; i < pos1-1; i++) {
			tmpMap[i][C-1] = tmpMap[i+1][C-1];
		}
		
		for(int i= 0; i < C-1; i++) {
			tmpMap[pos1][i+1] = tmpMap[pos1][i];
		}
		
	}
}
