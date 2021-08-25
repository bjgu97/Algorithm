import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1600_말이되고픈원숭이 {
	static int K;
	static int W;
	static int H;
	
	static int[][] board;
	static boolean[][][] visited;

	static class Point {
		int r;
		int c;
		int k;
		int cnt;
		
		Point(int r, int c, int k, int cnt) {
			this.r = r;
			this.c = c;
			this.k = k;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		board = new int[H][W];
		visited = new boolean[H][W][K+1]; // k번 이동 한 경우에 대한 방문처리. 
		
		for(int h = 0; h < H; h++) {
			st = new StringTokenizer(br.readLine());
			for(int w = 0; w < W; w++) {
				board[h][w] = Integer.parseInt(st.nextToken());
			}
		}
	
		visited[0][0][K] =  true;
		queue.add(new Point(0, 0, K, 0));
		
		bfs(); // (0, 0) -> (H-1, W-1)
	}
	
	static int[][] deltas1 = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {1, -2}, {2, -1}, {-1, -2}, {-2, -1}};
	static int[][] deltas2 = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};
	
	static Queue<Point> queue = new LinkedList<>();
	
	static void bfs() {
		while(!queue.isEmpty()) {
			
			// 단계별로 반복
			int size = queue.size();
			while(size-->0) {
				
				Point p = queue.poll();
				
				int r = p.r;
				int c = p.c;
				int k = p.k;
				int cnt = p.cnt;
				
				// 도착점 도달하면
				if(r == H-1 && c == W-1) {
					System.out.println(cnt);
					return;
				}
				
				// K 이동 횟수가 남아 있다면
				if(k > 0) {
					for(int d = 0; d < deltas1.length; d++) {
						int nr = r + deltas1[d][0];
						int nc = c + deltas1[d][1];
						
//						System.out.println("nr, nc, k: " + nr + "," + nc + "," + k);
						if(!isIn(nr, nc) || board[nr][nc] == 1 || visited[nr][nc][k-1])
							continue;
						
						
						//방문처리
						visited[nr][nc][k-1] = true;
						queue.add(new Point(nr, nc, k-1, cnt+1));
					}
				}
				
				// K 이동 횟수 남아있지 않다면
					for(int d = 0; d < deltas2.length; d++) {
				
						int nr = r + deltas2[d][0];
						int nc = c + deltas2[d][1];
						
//						System.out.println(nr + "," + nc + "," + k);
						if(!isIn(nr, nc) || board[nr][nc] == 1 || visited[nr][nc][k])
							continue;
						
						visited[nr][nc][k] = true;
						queue.add(new Point(nr, nc, k, cnt+1));
					}
				
			}
		}
		System.out.println(-1);
	}
	
	static boolean isIn(int x, int y) {
        if( x < 0 || x >= H || y < 0 || y >= W) 
        	return false;
        return true;
    }
}
