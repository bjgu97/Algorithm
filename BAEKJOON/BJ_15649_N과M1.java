import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_15649_N과M1 {
	
	public static void main(String[] args) throws IOException {
		// 1부터 N까지 중복 없이 M개 (Combination)
		// 사전순으로 증가하는 순서로
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		comb(0, 1, N, M);
	}
	static int[] numbers;
	static void comb(int cnt, int start, int N, int M) {
		if(cnt == M) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i = start; i <= N; i++) {
			numbers[cnt] = i;
			comb(cnt+1, i, N, M);
		}
	}

}
