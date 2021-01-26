package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BAEKJOON_2751_수정렬하기2 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	int[] NArr = new int[N];
	
	for(int i= 0; i < N; i++) {
		NArr[i] = Integer.parseInt(br.readLine());
	}
	
	Boolean[] TArr = new Boolean[2000000];
	for(int i = 0; i < N; i++) {
		TArr[NArr[i]]= true;
	}
	
	for(int i= 0; i < TArr.length; i++) {
		System.out.println(TArr[i]);
	}
	}
}
