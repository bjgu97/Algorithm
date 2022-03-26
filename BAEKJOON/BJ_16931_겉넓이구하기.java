import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_16931_겉넓이구하기 {
	public static void main(String[] args) throws IOException {
		// 도형 겉넓이 구하기
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int answer = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			for(int m = 0; m < M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 밑넓이
		answer += N*M;
		
		// 윗넓이
		answer += N*M;
		
		// 좌측
		for(int n = 0; n < N; n++) {
			int num = map[n][0];
			for(int m = 1; m < M; m++) {
				if(map[n][m] > map[n][m-1])
					num += (map[n][m] - map[n][m-1]);
			}
			answer += num;
		}
		
		// 우측
		for(int n = 0; n < N; n++) {
			int num = map[n][M-1];
			for(int m = M-2; m >= 0; m--) {
				if(map[n][m] > map[n][m+1])
					num += (map[n][m] - map[n][m+1]);
			}
			answer += num;
		}
		
		// 앞
		for(int m = 0; m < M; m++) {
			int num = map[0][m];
			for(int n = 1; n < N; n++) {
				if(map[n][m] > map[n-1][m]) {
					num += (map[n][m] - map[n-1][m]);
				}
			}
			answer += num;
		}
		
		// 뒤
		for(int m = 0; m < M; m++) {
			int num = map[N-1][m];
			for(int n = N-2; n >= 0; n--) {
				if(map[n][m] > map[n+1][m]) {
					num += (map[n][m] - map[n+1][m]);
				}
			}
			answer += num;
		}
		System.out.println(answer);
	}
}
