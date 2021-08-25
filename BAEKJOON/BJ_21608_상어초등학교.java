

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_21608_상어초등학교 {
	static int N;
	static int[][] seat;
	static int[][] student;
	static int[][] satis;
	
	static int[][] deltas = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		// 입력.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		student = new int[N*N][5];
		satis = new int[N*N+1][4];
		for(int n = 0; n < N*N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			student[n][0] = Integer.parseInt(st.nextToken());
			student[n][1] = Integer.parseInt(st.nextToken());
			student[n][2] = Integer.parseInt(st.nextToken());
			student[n][3] = Integer.parseInt(st.nextToken());
			student[n][4] = Integer.parseInt(st.nextToken());
			
			satis[student[n][0]][0] = student[n][1];
			satis[student[n][0]][1] = student[n][2];
			satis[student[n][0]][2] = student[n][3];
			satis[student[n][0]][3] = student[n][4];
		}
		
		for(int[] a : satis)
			System.out.println(Arrays.toString(a));

		// 자리 채워 나가기 시작.
		seat = new int[N][N];
	
		
		
		// 만족도 출력.
		int answ = 0;
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				for(int d = 0; d < deltas.length; d++) {
//					int nr = r + deltas[d][0];
//					int nc = c + deltas[d][1];
//					
//					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
//						continue;
//					
//					int cnt = 0;
//					for(int i = 0; i < 4; i++) {
//						if(seat[nr][nc] == satis[seat[r][c]][i])
//							cnt++;
//					}
//					
//					if(cnt == 0)
//						answ += 0;
//					else if(cnt == 1)
//						answ += 1;
//					else if(cnt == 2)
//						answ += 10;
//					else if(cnt == 3)
//						answ += 100;
//					else if(cnt == 4)
//						answ += 1000;
//				}
//			}
//		}
		
		System.out.println(answ);
	}
	
//	static void func(int n) {
//		// 비어 있는 칸 중 좋아하는 학생이 인접한 칸에 가장 많은 칸
//		int[][] temp = new int[N][N];
//		int cnt = 0;
//		int max = 0;
//		for(int r = 0 ; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				for(int d =0; d < deltas.length; d++) {
//					int nr = r + deltas[d][0];
//					int nc = c + deltas[d][1];
//					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
//						continue;
//					
//					for(int i =0; i < 4; i++) {
//						if(seat[nr][nc] == satis[n][i])
//							cnt++;
//					}
//				}
//				temp[r][c] = cnt;
//				max = Math.max(max, cnt);
//			}
//		}
//		int cntcnt = 0;
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				if(temp[r][c] == max) {
//					cntcnt++;
//				}
//			}
//		}
//		// 인접한 칸 중 비어있는 칸이 가장 많은 칸
//		temp = new int[N][N];
//		int max = 0;
//		cnt=0;
//		for(int r = 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				cnt = 0;
//				for(int d= 0; d < deltas.length; d++) {
//					int nr = r + deltas[d][0];
//					int nc = c + deltas[d][1];
//					if(nr < 0 || nc < 0 || nr >= N || nc >= N)
//						continue;
//					if(seat[nr][nc] == 0)
//						cnt++;
//				}
//				temp[r][c] = cnt;
//				max = Math.max(max, cnt);
//			}
//		}
//		
//		outer:for(int r= 0; r < N; r++) {
//			for(int c = 0; c < N; c++) {
//				if(temp[r][c] == max) {
//					seat[r][c] = student[n][0];
//					break outer;
//				}
//					
//			}
//		}	
//	}
}
