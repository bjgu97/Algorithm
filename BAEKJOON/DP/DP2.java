package DP;

import java.util.Arrays;
import java.util.Scanner;

public class DP2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i]  = sc.nextInt();
			
		}
		
		int size = 0;
		for(int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS,  0, size, arr[i]);
			temp = Math.abs(temp) - 1; // 중복값 없으므로 탐색에 실패하고 값 리턴
			LIS[temp] = arr[i]; // 맨 뒤에 추가되거나 기존위치에 덮어쓰거나
			
			if(temp == size)
				++size;
		}
	}
}
