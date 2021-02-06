package Study3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_1654_랜선자르기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); //랜선 개수: 10000
		int N = Integer.parseInt(st.nextToken()); // 필요한 랜선 개수: 100만
		
		int[] arr = new int[K];
		for(int i= 0; i < K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		//정렬
		Arrays.sort(arr);
		
		long top = Integer.MAX_VALUE; // 최대길이
		long down = 0; //랜선 길이 자연수이므로 1
		long mid = 0;
	
		
		while(top >= down) { 
//			System.out.println("top: " + top + " down: " + down);
			long sum = 0;
			mid = (top + down) / 2;
//			System.out.println("중간: " + mid);
			
			for(int i = 0; i < K; i++) {
//				System.out.println("개수: " + arr[i] / mid);
				sum += (arr[i] / mid);
			}
//			System.out.println("sum: " + sum);
			
			if(sum>=N)
				down = mid+1 ;
			else if(sum < N)
				top = mid-1 ;
//			else if(sum == N) //랜선 최대길이 구해야 하므로, 안됨. 
//				break;
			
//			System.out.println("top: " + top + " down: " + down);
//			System.out.println();
		}
	
		
		System.out.println(top);
	}
}
