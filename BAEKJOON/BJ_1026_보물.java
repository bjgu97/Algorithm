import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1026_보물 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 길이 N인 배열 A, B
		// S = A[0]*B[0] + ... + A[N-1]*B[N-1]
		// S를 가장 작게 만들기 위해 A 재배열
		// S의 최솟값?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] A = new int[N];
		int[] B = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			A[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int n = 0; n < N; n++) {
			B[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int answer = 0;
		for(int n = 0; n < N; n++) {
			answer += (A[n] * B[N-n-1]);
		}
		
		System.out.println(answer);
		
	}
}
