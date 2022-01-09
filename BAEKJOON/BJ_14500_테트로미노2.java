import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노2 {
	static int[][][] block = {
			 {{0,1}, {0,2}, {0,3}}, // ㅡ
			 {{1,0}, {2,0}, {3,0}}, // ㅣ
			 {{1,0}, {1,1}, {1,2}}, // ㄴ
			 {{0,1}, {1,0}, {2,0}}, // ㄱ (가로뒤집)
			 {{0,1}, {0,2}, {1,2}}, // ㄱ
			 {{1,0}, {2,0}, {2,-1}}, // ㄱ
			 {{0,1}, {0,2}, {-1,2}}, // ㄱ
			 {{1,0}, {2,0}, {2,1}}, // ㄱ
			 {{0,1}, {0,2}, {1,0}},  // ㄱ
			 {{0,1}, {1,1}, {2,1}}, // 
			 {{0,1}, {1,0}, {1,1}}, //
			 {{0,1}, {-1,1}, {-1,2}},
			 {{1,0}, {1,1}, {2,1}},
			 {{0,1}, {1,1}, {1,2}},
			 {{1,0}, {1,-1}, {2,-1}},
			 {{0,1}, {0,2}, {-1,1}},
			 {{0,1}, {0,2}, {1,1}},
			 {{1,0}, {2,0}, {1,1}},
			 {{1,0}, {2,0}, {1,-1}},
			 };
	
	public static void main(String[] args) throws IOException {
		// N * M 종이 위
		// 각 칸에는 정수가
		// 테트로미노 하나 놓아서 놓인 칸에 쓰여있는 수 합 최대
		// 회전 대칭 가능
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int answ = 0;
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < M; m++) {
				int sum = 0;
				for(int k = 0; k < 19; k++) {
					boolean flag = true;
					sum = map[n][m]; // 기준값
					
					for(int l = 0; l < 3; l++) {
						int i = n + block[k][l][0];
						int j = m + block[k][l][1];
						

						if(i < 0 || j < 0 || i >= N || j >= M)
							continue;
						
//						System.out.println("2 i, j: " + i + "," + j);
						sum += map[i][j];
					}
//					System.out.println("sum: " + sum);
					answ = Math.max(answ,sum);
				}
			}
		}
		
		System.out.println(answ);
	}
}
