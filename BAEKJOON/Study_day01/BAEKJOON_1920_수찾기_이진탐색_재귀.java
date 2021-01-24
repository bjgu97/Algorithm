package Study_day01;

import java.util.Arrays;
import java.util.Scanner;

public class BAEKJOON_1920_수찾기_이진탐색_재귀 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		// N 배열: 숫자 배열
		int[] NArr = new int[N];
		
		for(int i = 0; i < N; i++) {
			NArr[i] = scan.nextInt();
		}
		
		
		//M 배열: 찾고자하는 숫자들
		int M = scan.nextInt();
		int[] MArr = new int[M];
		
		for(int i = 0; i < M; i++) {
			MArr[i] = scan.nextInt();
		}
		
		
		//정렬
		Arrays.sort(NArr);
		
		//함수로 
		for(int m = 0; m < M; m++)
			System.out.println(binarySearch(NArr, MArr[m], 0, N-1));
	}
	
	public static int binarySearch(int[] arr, int target, int start, int end) {
		
		if(start > end)
			return 0;
		
		int mid = (start + end) / 2;
		
		//찾았다
		if(arr[mid] == target)
			return 1;
		
		// target가 중간값보다 작은 경우
		else if(arr[mid] > target)
			//왼쪽 확인
			return binarySearch(arr, target, start, mid-1);
		
		//target가 중간값보다 큰 경우
		else 
			return binarySearch(arr, target, mid+1, end);
	
		//없는 경우
	}
	
	
}
