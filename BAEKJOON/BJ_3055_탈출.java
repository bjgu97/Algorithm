import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_3055_탈출 {
	
	static int R;
	static int C;
	static char[][] graph;
	static int[][] visited;
	static boolean[][] visitedWater;
	static int cnt;
	static Queue<Point> queue = new LinkedList<Point>();
	static boolean success;
	static int answ;
	static int[][] deltas = {{1, 0}, {0, -1}, {0, 1}, {-1, 0}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); //행
		C = Integer.parseInt(st.nextToken()); //열
		
		graph = new char[R][C];
		visited = new int[R][C];
		visitedWater = new boolean[R][C];
		/*
		D : 굴
		S : 고슴도치 위치 <- 큐
		* : 물이 차있는 지역 <- 큐
		X : 돌
		. : 비어있는 곳
		*/
		
		for(int r = 0; r < R; r++) {
			String s = br.readLine();
			for(int c = 0; c < C; c++) {
				graph[r][c] = s.charAt(c);
				if(graph[r][c] == '*') {
					queue.offer(new Point(r, c));
					visitedWater[r][c] = true;
				}
			}
		}
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				if(graph[r][c] == 'S') {
					queue.offer(new Point(r, c));
					visited[r][c] = 1;
				}
			}
		}
		
//		for(char[] a : graph)
//			System.out.println(Arrays.toString(a));
//		
//		System.out.println(queue);
		
		int check = bfs();
		
		if(check == -1)
			System.out.println("KAKTUS");
		else	
			System.out.println(answ);

	}
	
	
	static int bfs() {		
		while(!queue.isEmpty()) {
			Point p = queue.poll();

				if(graph[p.r][p.c] == '*') { //물이면
					for(int d = 0; d < 4; d++) {
						int nr = p.r + deltas[d][0];
						int nc = p.c + deltas[d][1];
						
						if(nr < 0 || nc < 0 || nr >= R || nc >= C) // 범위 벗어나면
							continue;
						
						if(graph[nr][nc] == '.') { // if(graph[nr][nc] == '.' || graph[nr][nc] == 'S')
							graph[nr][nc] = '*';
							queue.offer(new Point(nr, nc));
						}
					}
				}
				
				else if(graph[p.r][p.c] == 'S') { //고슴도치면
					for(int d = 0; d < 4; d++) {
						int nr = p.r + deltas[d][0];
						int nc = p.c + deltas[d][1];
						
						if(nr < 0 || nc < 0 || nr >= R || nc >= C) // 범위 벗어나면
							continue;
						
					if(graph[nr][nc] == 'D') {// 고슴도치가 굴 발견하면
//						System.out.println("굴 발견!!!");
						answ =  visited[p.r][p.c];
						return answ;
					}
					
					if(graph[nr][nc]  == '.') { //이동 가능하면
						graph[nr][nc] = 'S';
						queue.offer(new Point(nr, nc));
						visited[nr][nc] = visited[p.r][p.c]+ 1; 
					}
				}
			
			
			}
//			for(char[] a : graph)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
//			for(int[] a : visited)
//				System.out.println(Arrays.toString(a));
//			System.out.println();
		
		}
		return -1;
	}
			
			
			
			
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
	
	}

