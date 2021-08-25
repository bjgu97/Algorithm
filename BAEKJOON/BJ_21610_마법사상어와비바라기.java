

import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class BJ_21610_마법사상어와비바라기 {
	static int N, M;
	static int[][] map;
	static boolean[][] tornado;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // map 크기
		M = Integer.parseInt(st.nextToken()); // 이동 횟수
		
		map = new int[N][N];
		tornado = new boolean[N][N];
		visited = new boolean[N][N];

		// 현재 물의 양 저장
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 토네이도 위치 저장
		tornado[N-2][0] = true;
		tornado[N-2][1] = true;
		tornado[N-1][0] = true;
		tornado[N-1][1] = true;
		
		// 이제 이동.
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			move(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int answ =0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				answ += map[i][j];
			}
		}
		
		System.out.println(answ);
	}
	
	static int[][] deltas = {{0, 0}, {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
	static int[][] deltas2 = {{1, 1}, {1, -1}, {-1, -1}, {-1, 1}}; // 대각선 확인용
	
	static void move(int d, int s) {
		visited = new boolean[N][N];
		boolean[][] tempTornado = new boolean[N][N];
		
		// 모든 구름이 d 방향으로 s 칸 이동
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(tornado[r][c] == true && visited[r][c] == false) {
					tornado[r][c] = false;
//					System.out.println("r, c: " + r + "," + c);
					int nr = range(r + deltas[d][0] * s);
					int nc = range(c + deltas[d][1] * s );
//					System.out.println("nr, nc: " + nr + "," + nc);
					
					tempTornado[nr][nc] = true; // 구름 이동 완료
					
					map[nr][nc]++; // 2번: 저장된 물 양 1 증가
				}
			}
		}
		
//		System.out.println("구름 이동");
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
//		
//		for(boolean[] b : tempTornado)
//			System.out.println(Arrays.toString(b));
		
		tornado = tempTornado;
		// 물복사버그 마법 시전
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(tornado[r][c] == true) { // 물이 증가한 칸에 대해서
					int cnt = 0;
					for(int dd = 0; dd < deltas2.length; dd++) {
						int nr = r + deltas2[dd][0];
						int nc = c + deltas2[dd][1];
						
						if(nr < 0 || nc < 0 || nr >= N || nc >= N)
							continue;
						
						if(map[nr][nc] > 0) { // 대각선에 물이 있다면
							cnt++;
						}
					}
//					System.out.println("cnt: " + cnt);
					map[r][c] += cnt; // 물 있는 양 만큼 증가
				}
			}
		}
		
//		System.out.println("마법 시행");
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
//		
//		for(boolean[] b : tornado)
//			System.out.println(Arrays.toString(b));
		
		// 바구니에 저장된 물이 2 이상인 모든 칸에 구름 생기고 2 줄어든다.
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] >= 2) {
					if(tornado[r][c] == true) {
						tornado[r][c] = false;
					}
					else {
						map[r][c] -= 2;
						tornado[r][c] = true;
					}
				}
				else {
					if(tornado[r][c] == true)
						tornado[r][c] = false;
				}
			}
		}
		
//		System.out.println("줄어들기");
//		
//		for(int[] a : map)
//			System.out.println(Arrays.toString(a));
//		
//		for(boolean[] b : tornado)
//			System.out.println(Arrays.toString(b));
//		System.out.println("=================================");
	}
	
	static int range(int n) {
		while(n < 0)
			n += N;
		return n % N;
	}
}
