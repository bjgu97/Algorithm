

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BJ_9205_맥주마시면서걸어가기 {
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
	
	static ArrayList<Point> map;
	static boolean[] visited;
	static boolean[][] dist;
	static int N;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine()); //맥주를 파는 편의점 개수
			map = new ArrayList<>();
			visited = new boolean[N+2];
			
			// 입력 받기
			for(int n = 0; n < N+2; n++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				map.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
//			System.out.println(map);
			dist = new boolean[N+2][N+2];
			
			for(int i = 0; i < N+2; i++) {
				for(int j = i+1; j < N+2; j++) {
					if(Math.abs(map.get(i).r - map.get(j).r) + Math.abs(map.get(i).c - map.get(j).c) <= 1000) {
						dist[i][j] = true;
						dist[j][i] = true;
					}
				}
			}
			dfs();
			
			if(dist[0][N+1] == true)
				System.out.println("happy");
			else
				System.out.println("sad");
		}
	}
	
	static void dfs() {
		for(int k = 0; k < N+2; k++) {
			for(int i = 0; i < N+2; i++) {
				for(int j = 0; j < N+2; j++) {
					if(dist[i][k] == true && dist[k][j] == true) {
						dist[i][j] = true;
					}
				}
			}
		}
	}
}
