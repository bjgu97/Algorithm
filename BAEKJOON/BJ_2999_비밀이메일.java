import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2999_비밀이메일 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int N = s.length();
		int R = 0;
		int C = 0;
		int maxR = 0;
		// R <= C 이고 R*C = N인 R과 C를 고른다.
		// 값 여러개이면 R이 큰 값. 
		for(int n = 1; n <= N; n++) {
			if(N % n == 0) {
				R = n;
				C = N / n;
				if(C >= R) {
					maxR = Math.max(maxR, R);
				}
			}
		}
		R = maxR;
		C = N/maxR;
		
		// R*C 행렬 만든다.
		char[][] arr = new char[R][C];
		
		// 행렬에 넣는다.
		int i = 0;
		for(int c = 0; c < C; c++) {
			for(int r = 0; r < R; r++) {
				arr[r][c] = s.charAt(i++);
			}
		}
		
//		for(char[] a : arr)
//			System.out.println(Arrays.toString(a));
		
		for(int r = 0; r < R; r++) {
			for(int c = 0; c < C; c++) {
				sb.append(arr[r][c]);
			}
		}
		
		System.out.println(sb);
	}
}
