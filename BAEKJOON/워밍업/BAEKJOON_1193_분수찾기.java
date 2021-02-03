package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_1193_분수찾기 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	//2차원배열 사용 안됨
	
	// 분자: 1 / 1 2 / 3 2 1 / 1 2 3 4/ 5 4 3 2 1
	int[] arr = new int[10000000];
	for(int i = 0 ; i < 10000000; i++) {
		arr[i] = i+1;
	}
}
}
