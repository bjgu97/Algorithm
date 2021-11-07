import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16509_장군 {
	static int R1, C1, R2, C2;
	static int[][] map = new int[10][9];
	static boolean[][] visited = new boolean[10][9];
	static int answer;
	
	public static void main(String[] args) throws IOException {
		// 상이 왕에게 도달할 수 있는 최소 이동 횟수
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R1 = Integer.parseInt(st.nextToken()); // 상
		C1 = Integer.parseInt(st.nextToken()); 
		
		st = new StringTokenizer(br.readLine());
		
		R2 = Integer.parseInt(st.nextToken()); // 왕
		C2 = Integer.parseInt(st.nextToken());
		
		// bfs
//		bfs();
		
		System.out.println(bfs());
		
	}
	
	static class Point {
		int r;
		int c;
		int cnt;
		
		Point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Point [r=" + r + ", c=" + c + "]";
		}
	}
	
//	static int[][] deltas1 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
//	static int[][] deltas2 = {{1, -1}, {1, 1}, {-1, -1}, {-1, 1}, {1, 1}, {-1, 1}, {1, -1}, {-1, 1}};
	static int[] fx = { 0, 1, 0, -1 };
	static int[] fy = { 1, 0, -1, 0 };

	static int[] sx = { -1, 1, 1, -1 };
	static int[] sy = { 1, 1, -1, -1 };


	static int bfs() {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(R1, C1, 0));
		visited[R1][C1] = true;
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			
//			System.out.println("!! r, c: "+ r + "," + c);
			if(r == R2 && c == C2) {
				return cnt;
			}
			
			for(int d1 = 0; d1 < 4; d1++) {
//				int nr = r + deltas1[d1][0];
//				int nc = c + deltas1[d1][1];
				int nr = r + fx[d1];
				int nc = c + fy[d1];
//				System.out.println("nr, nc: " + nr + ","+ nc);
				if(check(nr, nc))
					continue;
				
				for(int d2 = 0; d2 < 2; d2++) {
					int s = (d1 + d2) % 4;
					
//					int d = d1*2 + d2;
					// d1 0 -> 0, 1
					// d1 1 -> 2, 3
					// d1 2 -> 4, 5
					// d2 3 -> 6, 7
					int nnr = nr + sx[s];
					int nnc = nc + sy[s];

					if(check(nnr, nnc))
						continue;
					
//					nnr = nnr + deltas2[d][0];
//					nnc = nnc + deltas2[d][1];
					nnr += sx[s];
					nnc += sy[s];
					
//					System.out.println("nnr, nnc: " + nnr + "," + nnc);
//					System.out.println();
					if(nnr < 0 || nnc < 0 || nnr >= 10 || nnc >= 9)
						continue;
					
					if(visited[nnr][nnc])
						continue;
					
					visited[nnr][nnc] = true;
					queue.add(new Point(nnr, nnc, cnt+1));
				}
			}
		}
		return -1;
	}
	
	static boolean check(int nr, int nc) {
		// 가는길에 왕이나 다른 상 있음
		if(nr == R2 && nc == C2)
			return true;
		
 		if(nr < 0 || nc < 0 || nr >= 10 || nc >= 9)
 			return true;
 		
 		return false;
	}
}
