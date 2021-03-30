package study11;

import java.io.*;
import java.util.*;

public class Main {



	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] isPrime = new boolean[4000001];
		Arrays.fill(isPrime, true);
		isPrime[1] = false;
		
		for (int i=2;i<=4000000;i++) {
			for (int j=i*2;j<=4000000;j+=i) {
				isPrime[i] = false;
			}
		}
		

		List<Integer> primeNumber = new ArrayList<Integer>();
		for (int i = 0; i <= N; i++) {
			if (isPrime[i]) {
				primeNumber.add(i);
			}
		}
		
		int sum = 0;
		int start = 0, end = 0;

		int result = 0;
		while(true) {
			if(sum >= N) { // 구간 합이 찾고자 하는 수보다 크면
				sum -= primeNumber.get(start++); //start 포인터 이동
			}
			else if(end == primeNumber.size()) break; // end가 배열 끝 도달하면 종료
			
			else sum += primeNumber.get(end++); // 구간 합이 N보다 작으면 end 한칸 이동
			
			if(sum == N) { 

				result++; // 경우의 수 세주기
			}
		}
		System.out.println(result);
	}

}