package Study_day01;

import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON_1920_수찾기_이진탐색_반복문 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		// N 배열: 숫자 배열
		int[] NArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			NArr[i] = scan.nextInt();
		}
		
		//M 배열: 찾고자하는 숫자
		int M = scan.nextInt();
		int[] MArr = new int[M];
		
		for(int i = 0; i < M; i++) {
			MArr[i] = scan.nextInt();
		}
						
		//정렬
		Arrays.sort(NArr);
						
		boolean exist = false;

		//이진탐색
		for(int m = 0; m < M; m++) {
			int start = 0;
			int end = N-1;
			int mid;
			
			while(start <= end) { 
				mid = (start + end) / 2;
				
				if(NArr[mid] == MArr[m]) {
					//찾았다
					exist = true;
					break;
				}
				
				//중간점 값보다 찾고자하는 값이 작을 경우
				else if(NArr[mid] > MArr[m]) {
					//왼쪽 확인
					end = mid-1;
				}
				
				//중간점 값보다 찾고자하는 값이 클 경우
				else if(NArr[mid] < MArr[m]) {
					//오른쪽 확인
					start = mid + 1;
				}
				
				
				exist = false;
			}
			if(exist)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}
}
