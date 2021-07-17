import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import sun.java2d.pipe.BufferedBufImgOps;

public class BJ_15656_N과M7 {
	static int N;
	static int M;
	static int[] arr;
	
	static int[] numbers;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		numbers = new int[M];
		st = new StringTokenizer(br.readLine());
		arr = new int[N];
		
		for(int n = 0; n < N; n++) {
			arr[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		// 중복순열
		Perm(0);
		
		System.out.println(sb);
	}
	
	static void Perm(int cnt) {
		if(cnt == M) {
			for(int i = 0;i < numbers.length; i++) {
//				System.out.print(numbers[i] + " ");
				sb.append(numbers[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			numbers[cnt] = arr[i];
			Perm(cnt+1);
		}
	}
}
