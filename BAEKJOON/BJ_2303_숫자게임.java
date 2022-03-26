import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_2303_숫자게임 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][5];
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int m = 0; m < 5; m++) {
				arr[n][m] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] tmp = new int[N];
		for(int n = 0; n < N; n++) {
			// 최대 수 구하기
			int one = 0;
			for(int a = 0; a < 5; a++) {
				for(int b = a+1; b < 5; b++) {
					for(int c = b+1; c < 5; c++) {
						one = Math.max(one, (arr[n][a] + arr[n][b] + arr[n][c])%10);
					}
				}
			}
			tmp[n] = one;
		}
				
		int answer = N;
		int max = tmp[N-1];
		for(int i = N-1; i > 0; i--) {
			if(tmp[i-1] > max) {
				answer = i;
				max = tmp[i-1];
			}
		}
		
		System.out.println(answer);
	}
}
