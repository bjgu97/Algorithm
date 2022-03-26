import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2665_미로만들기 {
	static int N;
	static int[][] map;
	static int[][] distance;
	
	static class Point {
		int r;
		int c;
		
		Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//  n * n 방
		// 시작방에서 끝방으로 
		// 적은 수의 방 색 바꿔서.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		distance = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < N; m++) {
				map[n][m] = s.charAt(m) - '0';
				distance[n][m] = Integer.MAX_VALUE;
			}
		}
		
		bfs();
		
		System.out.println(distance[N-1][N-1]);
	}
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		
		distance[0][0] = 0;
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			
			for(int d = 0; d < deltas.length; d++) {
				int nr = r + deltas[d][0];
				int nc = c + deltas[d][1];
				
				if(nr < 0 || nc < 0 || nr >= N || nc >= N)
					continue;

				if(map[nr][nc] == 0 && distance[nr][nc] > distance[r][c]) { // 벽
					distance[nr][nc] = distance[r][c] + 1;
					queue.add(new Point(nr, nc));
				}
				else if(map[nr][nc] == 1 && distance[nr][nc] > distance[r][c]) { // 이동 가능
					distance[nr][nc] = distance[r][c];
					queue.add(new Point(nr, nc));
				}

			}
			
//			System.out.println(queue);
//			for(int[] a : distance)
//				System.out.println(Arrays.toString(a));
		}
		

	}
}
