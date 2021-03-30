package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_16236_아기상어 {
	
	static class Shark {
		int r;
		int c;
		int size;
		
		Shark(int r, int c, int size, int cnt) {
			this.r = r;
			this.c = c;
			this.size = size; // 아기상어 크기
		}
	}
	
	static class Fish {
		int r;
		int c;
		
		Fish(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static Queue<Shark> queue = new LinkedList<>();
	static Shark shark;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N= Integer.parseInt(br.readLine()); // 공간의 크기
		map = new int[N][N];
		
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < N; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				if(map[n][m] == 9) { // 초기 아기상어 위치
					visited[n][m] = true; // 방문처리
					shark = new Shark(n, m, 2);
				}
			}
		}
		
		// 물고기 크기 -> 위 -> 왼 순 정렬
				
		// 처음 아기 상어 크기 2
		// 자기보다 큰 물고기 칸 지나갈 수 없다
		// 자기보다 작은 물고기 먹을 수 있다
		// 크기가 같은 물고기 먹을 수 없지만 지나갈 수 있다
		
		// 더이상 먹을 수 있는 물고기가 공간에 없다면 끝
		// 물고기 1마리면 먹는다
		// 물고기 1마리 이상이면 거리가 가까운 물고기부터. 
		// 거리가 같으면 가장 위에있는, 가장 왼쪽의 물고기 먹는다.
		
		bfs();
	}
	
	static void bfs() {
		while(true) {
			
		}
	}
}
