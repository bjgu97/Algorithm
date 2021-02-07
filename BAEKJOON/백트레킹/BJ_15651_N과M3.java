package 백트레킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;
 
public class BJ_15651_N과M3 {
	
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static int N;
	static int M;
	
	public static void main(String[] args) throws IOException {
		LinkedList<Integer> list = new LinkedList<>();
		
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken()); // 1부터 N 중 {1, 2, 3, 4}
		M = Integer.parseInt(st.nextToken()); // M개 뽑아야 한다.  2
		
		// 4 2
		// 1, 2, 3, 4 에서 중복순열 2개 뽑기
		// 순서 상관 있다 = 1 2 != 2 1 
		
		// 배열에 숫자 넣기 {1, 2, 3, 4}
		int[] numbers = new int[N];
		for(int n = 1; n <= N; n++) {
			numbers[n-1] = n;
		}
		
		// 뽑은 것들을 저장하는 배열
		int[] choosed = new int[M];
		
		permutation(numbers, choosed, M);

	}
	
	// N = 4, M = 2  4개 중 2개 고르기. 중복 가능. 
	/**
	 * 
	 * @param numbers [1, 2, 3, 4]
	 * @param choosed [ ]
	 * @param num 2 뽑야아하는 개수 2
	 */
	public static void permutation(int[] numbers, int[] choosed, int num) {
		if(num == 0) {
			sb.append(Arrays.toString(choosed)).append("\n");
		}
		
		for(int i = 0; i < numbers.length; i++) {
			choosed[M-num] = numbers[i]; // choosed[2-2] = 1
			permutation(numbers, choosed, num-1);
		}
	}
}