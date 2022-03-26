import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2573_빙산 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited, visited2;
	static int time;
	
	public static void main(String[] args) throws IOException {
		// 높이는 양수로, 바다는 0
		// 빙산은 주변 0 개수만큼 줄어든다.
		// 빙산 두 덩어리 이상으로 분리되는 최초 시간?
		// 전부 녹을때까지 분리 안되면 0 출력.
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int time = 0;
		
		while(true) {
			time++;
//			System.out.println("1111111111111111111111");
//			print();
	
			visited = new boolean[N][M];
			
			if(isAllMelt()) {
				System.out.println(0);
				break;
			}
			else { 
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(map[n][m] != 0)
							visited[n][m] = true;
							melt(n, m);
					}
				}
				
				if(checkSplit()) {
					System.out.println(time);
					break;
				}
			}
			
		}
	}
	
	static boolean checkSplit() {
		boolean flag = false;
		visited2 = new boolean[N][M];
		outer:for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] != 0 && !visited2[n][m]) {
					bfs(n, m);
					break outer;
				}				
			}
		}
		
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m]!= 0 && !visited2[n][m]) {
//					System.out.println("~~~~~~~~~~~~~~~~");
					flag = true;
				}
			}
		}

//		System.out.println("flag : " + flag);
		return flag;
	}
	
	static void bfs(int n, int m) {
		visited2[n][m] = true;
		Queue<Point> queue = new LinkedList<>();
		
		queue.add(new Point(n, m));
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.n;
			int c = p.m;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				if(visited2[nr][nc])
					continue;
				
				if(map[nr][nc] != 0) {
					visited2[nr][nc] = true;
					queue.add(new Point(nr, nc));
				}
			}
		}
		
//		System.out.println("2222222222222222222222222222");
//		for(boolean[] a : visited2)
//			System.out.println(Arrays.toString(a));
		
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static void melt(int n, int m) {
		int ocean = 0;
		for(int d = 0; d < deltas.length; d++) {
			int nn = n + deltas[d][0];
			int nm = m + deltas[d][1];
			
			if(nn < 0 || nm < 0 || nn >= N || nm >= M)
				continue;
			
			if(map[nn][nm] == 0 && !visited[nn][nm])
				ocean++;
		}
		map[n][m] -= ocean;
		if(map[n][m] < 0)
			map[n][m] = 0;
	}
	
	static boolean isAllMelt() {
		boolean flag = true;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				if(map[n][m] != 0) {
					flag = false;
					break;
				}
			}
		}
		return flag;
	}
	
	static void print() {
		for(int[] a : map)
			System.out.println(Arrays.toString(a));
		System.out.println();
	}
	
	static class Point {
		int n;
		int m;
		
		Point(int n, int m) {
			this.n = n;
			this.m = m;
		}

		@Override
		public String toString() {
			return "Point [n=" + n + ", m=" + m + "]";
		}
		
		
	}
}
