package 실버;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Algorithm.sw.d3.a;

public class BJ_2635_수이어가기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int first;
		int second;
		int third;
		int cnt = 0;
		List<Integer> list = new ArrayList<>();
		for(int n = 1; n < N; n++) { // 1부터 N-1까지 수 중 선택
			cnt = 0;
			first  = N; // 첫번째 수 100
			second = N - n; //두번째 수 60 
			third = first - second; // 세번째 수 40

			while(first > 0 && second > 0 && third > 0) {
				first = second;
				second = third;
				third = first - second;
				cnt++;
			}
			list.add(cnt);
		}
		System.out.println(list);
		int max = 0;
		for(int i = 0; i < list.size(); i++) {
			max = Math.max(max, list.get(i));
		}
		System.out.println(max);
		
		int maxNum = 0;
		for(int i= 0; i < list.size(); i++) {
			if(list.get(i) == max) {
				maxNum = i;
				break;
			}
		}
		
		System.out.println(maxNum);
		
		List<Integer> list2 = new ArrayList<>();
		
	}
}
