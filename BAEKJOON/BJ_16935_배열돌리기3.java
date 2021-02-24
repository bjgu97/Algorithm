

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class BJ_16935_배열돌리기3 {
	static int[][] map;
	static int[][] tmpMap;
	
	static int NM;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 배열의 크기 N - 행
		int M = Integer.parseInt(st.nextToken()); // 배열의 크기 M - 열
		int R = Integer.parseInt(st.nextToken()); // 연산 수
				
		
		// map 입력받기
		NM = Math.max(N,  M);
		map = new int[NM][NM];
		
		for(int i = 0; i < N; i++) { // 열
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 연산번호 입력받기
		int[] cmdArr = new int[R];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < R; i++) {
			cmdArr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 각 연산 수행
		for(int kk = 0; kk < cmdArr.length; kk++) {
			int cmd  = cmdArr[kk];
			switch(cmd) {
			
			case 1:

				tmpMap = new int[NM][NM];

				// 값 저장하고
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						tmpMap[N-n-1][m] = map[n][m];
					}
				}
				
				//값 복사
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						map[n][m] = tmpMap[n][m];
					}
				}
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				break;
				
				
			case 2:		
				tmpMap = new int[NM][NM];

				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						tmpMap[n][M-m-1] = map[n][m];
					}
				}
				
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						map[n][m] = tmpMap[n][m];
					}
				}
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				break;
				
				
			case 3:
				int[][] tmpMap = new int[NM][NM];
				
				for(int k = 0;k<N; ++k) {
					tmpMap[k] = map[k].clone();
				}

				int t = N;
				N = M;
				M = t;
				
				for(int n = 0; n < N; n++) { //8
					for(int m = 0; m < M; m++) {
						 map[n][m] = tmpMap[M-1-m][n];
					}
				}
				
				for(int i = 0; i < N; i++) {
					for(int j = 0; j < M; j++) {
						System.out.print(map[i][j] + " ");
					}
					System.out.println();
				}
				System.out.println();
				break;


				
				
			case 4:
				int[][] tmpMap2 = new int[NM][NM]; // map과 반대 크기
				
				 for(int k = 0; k<N; ++k)
					 tmpMap2[k] = map[k].clone();
				 
				int tt = N;
				N = M;
				M = tt;
				
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						map[n][m] = tmpMap2[m][N-1-n];
					}
				}

				break;

			
				
			case 5:				
				tmpMap = new int[NM][NM];
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(n >= 0 && n < N/2  && m >= 0 && m < M/2) { //좌상
							tmpMap[n][m + M/2] = map[n][m];
						}
						else if(n >= N/2 && n < N && m >= 0 && m < M/2) { //좌하
							tmpMap[n - N/2][m] = map[n][m];
						}
						else if(n >= N/2 && n < N && m >= M/2 && m < M) { //우하
							tmpMap[n][m-M/2] = map[n][m];
						}
						else if(n < N/2 && n >= 0 && m < M && m>= M/2) { // 우상
							tmpMap[n+N/2][m] = map[n][m]; //(4, 5)
						
						}
					}
				}
				//map = tmpMap.clone();
				for(int a = 0; a < NM; a++) 
					map[a] = tmpMap[a].clone();
				
				break;
			
				
			case 6:
				tmpMap = new int[NM][NM];
				for(int n = 0; n < N; n++) {
					for(int m = 0; m < M; m++) {
						if(n >= 0 && n < N/2  && m >= 0 && m < M/2) { //좌상
							tmpMap[n + N/2][m] = map[n][m];
						}
						else if(n >= N/2 && n < N && m >= 0 && m < M/2) { //좌하
							tmpMap[n][m + M/2] = map[n][m];
						}
						else if(n >= N/2 && n < N && m >= M/2 && m < M) { //우하
							tmpMap[n-N/2][m] = map[n][m];
						}
						else if(n < N/2 && n >= 0 && m < M && m>= M/2) { // 우상
							tmpMap[n][m-M/2] = map[n][m]; //(4, 5)
						
						}
					}
				}
				//map = tmpMap.clone();
				for(int a = 0; a < NM; a++) 
					map[a] = tmpMap[a].clone();
				
				break;
	}

}
		for(int i= 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}