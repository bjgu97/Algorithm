package 정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_2751_수정렬하기2 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	int N = Integer.parseInt(br.readLine());

	boolean[] NArr = new boolean[2000001];
	
	int a = 0;
	for(int i = 0; i < N; i++) {
		a = Integer.parseInt(br.readLine());
		NArr[a+ 1000000] = true;
	}
	
	StringBuilder sb = new StringBuilder();
	
	for(int i = 0; i < NArr.length; i++) {
		if(NArr[i] == true) {
			sb.append(i-1000000).append("\n");
		}}
	
	System.out.println(sb);
}
}
