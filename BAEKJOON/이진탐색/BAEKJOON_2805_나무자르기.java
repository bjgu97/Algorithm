package 이진탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


public class BAEKJOON_2805_나무자르기 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int N = Integer.parseInt(st.nextToken()); //나무 개수 N
	int M = Integer.parseInt(st.nextToken()); //가져가려는 나무 길이 M
	
	List<Integer> list = new ArrayList<>();
	
	st = new StringTokenizer(br.readLine(), " ");
	for(int i = 0; i < N; i++)
		list.add(Integer.parseInt(st.nextToken()));
	
	int max = Collections.max(list);

	//이진탐색
	long low = 0;
	long high = max;
	long mid = 0;
	
	
	while(high >= low) {
		long sum = 0;

		mid = (low + high) / 2;
//		System.out.println("mid: " + mid);
		
		for(int i = 0; i < N; i++) {
			long len = list.get(i) - mid; 
			sum += (len >=0 ? len : 0);
		}
	
//		System.out.println("sum: " + sum);
		
		if(sum >= M) {
			low = mid+1;
		}
		else if(sum < M)
			high = mid -1;
//		System.out.println();
	}
	
	System.out.println(high);
	
}
}
