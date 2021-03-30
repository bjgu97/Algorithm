package study11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BJ_1644_소수의연속합 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		
		/***** 에라토스테네스의 체 ***/
		
		boolean[] arr = new boolean[4000001];
		Arrays.fill(arr, true);
		
		arr[1] = false; // 1은 소수 아니니까 false로.
		
		// 소수 아닌 것들 다 false로.
		for(int i = 2; i <= 4000000; i++) {
			for(int j = i*2; j <= 4000000; j += i) {
				arr[j] = false; 
			}
		}
		
		// 소수인 것들만 따로 리스트에 또 저장
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == true) {
				list.add(i);
			}
		}
		
		/***** 투포인터 ***/
		// 연속된 소수의 합으로 나타낼 수 있는 경우의 수 구하기
		int result = 0; // 경우의 수
		int sum = 0; // 구간 합
		
		int start = 1; // 포인터1
		int end = 0; // 포인터2
		
		while(true) {
			if(sum >= N) { // 구간 합이 찾고자 하는 수보다 크면
				sum -= list.get(start++); //start 포인터 이동
			}
			else if(end == list.size()) break; // end가 배열 끝 도달하면 종료
			
			else sum += list.get(end++); // 구간 합이 N보다 작으면 end 한칸 이동
			
			if(sum == N) { 

				result++; // 경우의 수 세주기
			}
		}
		
		System.out.println(result);
	}
}
