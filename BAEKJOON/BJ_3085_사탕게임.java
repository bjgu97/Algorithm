import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_3085_사탕게임 {
	static char[][] arr;
	static int max;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// N*N 크기에 사탕 채워넣는다.
		// 사탕 색이 다른 인접한 두 칸 고른다.
		// 고른 칸에 들어있는 사탕 교환
		// 같은 색으로 이루어져있는 가장 긴 연속 부분을 고른 다음 먹는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new char[N][N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			for(int m = 0; m < N; m++) {
				arr[n][m] = s.charAt(m);
			}
		}
		
		// 인접한 두 칸을 고른다. (가로)
		for(int n = 0; n < N; n++) {
			for(int m = 0; m < N-1; m++) {
				// 교환한다.]
				if(arr[n][m] != arr[n][m+1]) {
					change1(n, m);
				
				// 가장 긴 연속 부분 본다.
				check(N);
				
				change1(n, m);
				}
			}
		}
		
		//인접한 두 칸(세로)
		for(int n = 0; n < N-1; n++) {
			for(int m = 0; m < N; m++) {
				if(arr[n][m] != arr[n+1][m]) {
					change2(n, m);
				check(N);
				
				change2(n,m);
				}
			}
		}
		
		check(N);
		System.out.println(max);
	}
	
	static void change1(int n, int m) {
		char tmp = arr[n][m];
		arr[n][m] = arr[n][m+1];
		arr[n][m+1] = tmp;
	}
	
	static void change2(int n, int m) {
		char tmp = arr[n][m];
		arr[n][m] = arr[n+1][m];
		arr[n+1][m] = tmp;
	}
	
	static void check(int N) {
		// 가로 연속 부분 확인
		int cnt = 1;
		for(int n = 0; n < N; n++) {
			cnt = 1;
			for(int m = 0; m < N-1; m++) {
				if(arr[n][m] == arr[n][m+1]) {
					cnt++;
					max = Math.max(max, cnt);

				}
				else {
					cnt = 1;
				}
			}
		}
		
		// 세로 연속 부분 확인
		
		for(int n = 0; n < N; n++) {
			cnt = 1;
			for(int m = 0; m < N-1; m++) {
				if(arr[m][n] == arr[m+1][n]) {
					cnt++;
					max= Math.max(max, cnt);

				}
				else {
					cnt = 1;
				}
			}
		}
	}
}
