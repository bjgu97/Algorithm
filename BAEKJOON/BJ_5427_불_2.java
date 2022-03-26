import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_5427_불_2 {
	static int W;
	static int H;
	static char[][] map;
	static boolean[][] visited;
	static int[][] visited2;
	static Queue<Point> queue = new LinkedList<>();
	static Queue<Point> queue2 = new LinkedList<>(); // 상근이
	static boolean success;
	static int time;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken()); // 너비
			H = Integer.parseInt(st.nextToken()); // 높이
			
			int a = 0;
			int b = 0;
			
			map = new char[H][W];
			visited = new boolean[H][W]; // 불 방문 처리
			visited2 = new int[H][W]; //상근위치 방문 처리
			
			// 불 저장 리스트
			for(int h = 0; h < H; h++) {
				String s = br.readLine();
				for(int w =0; w < W; w++) {
					map[h][w] = s.charAt(w);
					
					if(map[h][w] == '@') { // 상근이 위치
						queue2.offer(new Point(h, w)); //큐에 저장
						visited2[h][w] = 1;
					}
					
					else if(map[h][w] == '*') { // 불 위치
						queue.add(new Point(h, w)); //큐에 저장
						visited[h][w] = true;
					}
					
				}
			}

			success = false;
			bfs(); 
			queue.clear();	
			queue2.clear();
			
			
			if(!success)
				System.out.println("IMPOSSIBLE");
			else {
				System.out.println(time);
			}
		}
	}
	
	
	static int[][] deltas = {{0, 1}, {0, -1}, {1, 0}, {-1,0}}; // 동서남북 방향
	
	
	public static void bfs() {
		outer:while((queue.isEmpty() && !queue2.isEmpty()) || (!queue.isEmpty() && !queue2.isEmpty())) { // 불, 상근 동시 이동
			// 불 개수만큼 반복(각각 이동)
			int fireSize = queue.size();
			for(int i =0; i < fireSize; i++) { 
				Point p1 = queue.poll(); // (1, 1)
				visited[p1.r][p1.c]= true; // 첫 시작 좌표 방문 처리 
				
				for(int d = 0; d < deltas.length; d++) {
					Point np1 = new Point(p1.r + deltas[d][0], p1.c + deltas[d][1]);
					
					if(np1.c < 0 || np1.r < 0 || np1.r >= H || np1.c >= W) // 범위 벗어나면
						continue;
					
					if(map[np1.r][np1.c]== '#') // 벽이면
						continue;
					
					if(visited[np1.r][np1.c] == true) //방문 했던 곳이면
						continue;
					
					queue.offer(new Point(np1.r, np1.c));
					
					visited[np1.r][np1.c]= true; 
					map[np1.r][np1.c]= '*'; 
				}
			}
			
			int manSize = queue2.size();
			for(int i = 0; i < manSize; i++) {
				Point p2 = queue2.poll(); // 상근이좌표

				for(int d = 0; d < deltas.length; d++) {
					Point np2 = new Point(p2.r + deltas[d][0], p2.c + deltas[d][1]);
					
					if(np2.c < 0 || np2.r < 0 || np2.r >= H || np2.c >= W) {  // 범위 벗어나면
						success = true;
						time = visited2[p2.r][p2.c];
						break outer;
					}
					if(map[np2.r][np2.c]== '#') // 벽이면
						continue;
										
					if(map[np2.r][np2.c]== '*') // 불이면
						continue;
					
					if(visited2[np2.r][np2.c]!=0) //방문한 곳이면
						continue;
					
					queue2.offer(new Point(np2.r, np2.c));
					visited2[np2.r][np2.c]= visited2[p2.r][p2.c] + 1; 
				}
			}
		}
	}
	
	
	public static class Point {
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
}