package 삼성SW역량;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class BJ_20056_마법사상어와파이어볼 {
	static class fireBall {
		int r;
		int c;
		int m;
		int s;
		int d;
		
		fireBall(int r, int c, int m, int s, int d) {
			this.r = r;
			this.c = c;
			this.m = m;
			this.d = d;
			this.s = s;
		}

		@Override
		public String toString() {
			return "[r=" + r + ", c=" + c + ", m=" + m + ", s=" + s + ", d=" + d + "]";
		}
		
		
	}
	
	static Queue<fireBall> queue = new LinkedList<>();
	static LinkedList<fireBall>[][] map;
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 격자 크기
		int M = Integer.parseInt(st.nextToken()); //파이어볼 개수
		int K = Integer.parseInt(st.nextToken()); //명령횟수
		 
		map = new LinkedList[N][N]; // 파이어볼 개수 기록용

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new LinkedList<>();
			}
		}
		
		for(int mm = 0; mm < M; mm++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			fireBall fb = new fireBall(r-1, c-1, m, s, d);
			
			map[r][c].add(fb);
		}
		
		
		
		for(int k = 0; k < K; k++)
			bfs();
		
//		int answ = 0;
//		for(int i = 0; i < N; i++) {
//			for(int j = 0; j < N; j++) {
//				while(map[i][j].size() != 0) {
//					fireBall fb = map[i][j].poll();
//					answ += fb.m;
//				}
//			}
//		}
//		System.out.println(answ);
	}
	
	static int[][] deltas = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
	static void bfs() {
		while(!queue.isEmpty()) {
			fireBall fb = queue.poll();
			int r = fb.r; // 좌표1
			int c = fb.c; // 좌표2
			int m = fb.m; // 질량
			int s = fb.s; // 방향
			int d = fb.d; // 속력
			System.out.println("r, c, m, s, d: " + r +"," + c + "," + m + "," + s + "," + d);
			System.out.println("1. r, c: " + r + "," + c);

			// 1번: 자신의 방향 d로 s칸만큼 이동
			r = r + s * deltas[d][0];
			c = c + s * deltas[d][1];
			
			System.out.println("2. r, c: " + r + "," + c);

			r = (Math.abs(r)) % 4;
			c = (Math.abs(c)) % 4;
			
			System.out.println("3. r, c: " + r + "," + c);
			
			map[r][c].add(new fireBall(r, c, m, s, d)); // -1 = 0, -2 = 1, -3 = 2, -4 = 3, ...-5 = 4, -6 = 5
			
			// 2번: 2개 이상 파이어볼이 있는 칸에서
			int mSum = 0;
			int sSum = 0;
			int cnt = 0; // 합쳐진 파이어볼 개수
			int even = 0;
			int odd = 0;
			
			int size = map[r][c].size();
			if(map[r][c] != null && size >= 2) {
				// 같은 칸에 있는 파이어볼 하나로
				for(int i = 0; i < size; i++) {
					fb = map[r][c].poll();
					mSum += fb.m;
					sSum += fb.s;
					cnt++;
					if(fb.d%2 == 0) {
						even++;
					}
					else {
						odd++;
					}
					System.out.println("mSum, sSum : " + mSum + "," + sSum);
					System.out.println("even, odd: " + even + "," + odd);
				}
				
				// 파이어볼은 4개의 파이어볼로 나눠진다.
				int mm = mSum / 5;
				int ss = sSum / cnt;
				
				System.out.println("mm, ss: " + mm + "," + ss);
				if(mm != 0) {
					if(even == cnt || odd == cnt) { // 파이어볼 방향이 모두 짝수이거나 홀수이면
						for(int i = 0; i < 4; i++) { // 0 1 2 3
							map[r][c].add(new fireBall(r, c, mm, ss, i*2));
							queue.add(new fireBall(r, c, mm, ss, i*2));
						}
					}
					else {
						for(int i = 0; i < 4; i++) {
							map[r][c].add(new fireBall(r, c, mm, ss, i*2+1));
							queue.add(new fireBall(r, c, mm, ss, i*2+1));
						}
					}
				}
			}
			
		}
		
		for(LinkedList<fireBall>[] a : map)
			System.out.println(Arrays.toString(a));
	}
	
	static boolean isIn(int r, int c) {
		return r >= 0 || c >= 0 || r < N || c < N;
	}
}
