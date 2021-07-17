import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_14500_테트로미노 {
	public static void main(String[] args) throws IOException {
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
		
		int max = 0;
		
		// 첫번쨰 테트로미노
		for(int n = 0; n < N; n++) {
			int sum = 0;
			for(int m = 0; m < M-3; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n][m+2] + map[n][m+3]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-3; n++) {
			int sum = 0;
			for(int m = 0; m < M; m++) {
				sum = (map[n][m] + map[n+1][m] + map[n+2][m] + map[n+3][m]);
				max = Math.max(max, sum);
			}
		}
		

		// 두번쨰 테트로미노
		for(int n = 0; n < N-1; n++) {
			int sum2 = 0;
			for(int m = 0; m < M-1; m++) {
				sum2 = (map[n][m] + map[n][m+1] + map[n+1][m] + map[n+1][m+1]);

				max = Math.max(max, sum2);
			}
		}

		
		// 세번째 테트로미노
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m] + map[n+1][m] + map[n+2][m] + map[n+2][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m] +map[n][m+1] + map[n+1][m+1] + map[n+2][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m+1] + map[n+1][m+1] + map[n+2][m] + map[n+2][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n+1][m] + map[n+2][m]);
				max = Math.max(sum, max);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n+1][m] + map[n+1][m+1] + map[n+1][m+2] + map[n][m+2]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n][m+2] + map[n+1][m]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m] + map[n+1][m] + map[n+1][m+1] + map[n+1][m+2]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n][m+2] + map[n+1][m+2]);
				max = Math.max(max, sum);
			}
		}

		// 네번째 테트로미노
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m] + map[n+1][m] + map[n+1][m+1] + map[n+2][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m+1] + map[n+1][m+1] + map[n+1][m] + map[n+2][m]);
				max = Math.max(max, sum);
			}
		}

		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m+1] + map[n][m+2] + map[n+1][m] + map[n+1][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n+1][m+1] + map[n+1][m+2]);
				max = Math.max(max, sum);
			}
		}
		
		
		// 다섯번째 테트로미노
		for(int  n= 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m] + map[n][m+1] + map[n][m+2] + map[n+1][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-1; n++) {
			int sum = 0;
			for(int m = 0; m < M-2; m++) {
				sum = (map[n][m+1] + map[n+1][m] + map[n+1][m+1] + map[n+1][m+2]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n][m] + map[n+1][m] + map[n+1][m+1] + map[n+2][m]);
				max = Math.max(max, sum);
			}
		}
		
		for(int n = 0; n < N-2; n++) {
			int sum = 0;
			for(int m = 0; m < M-1; m++) {
				sum = (map[n+1][m] + map[n][m+1] + map[n+1][m+1] + map[n+2][m+1]);
				max = Math.max(max, sum);
			}
		}
		
		System.out.println(max);

	}
}
