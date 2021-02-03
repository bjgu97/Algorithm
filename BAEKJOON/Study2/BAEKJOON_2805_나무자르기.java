package Study2;
/**
* @since 2021. 2. 1.
* @author bjgu9
* @see
* @mem 193828	
* @time 732
* @caution 테케 그려보면서 이진탐색 알아냄. 이진탐색 시간복잡도 logN. 1 ≤ N ≤ 1,000,000, 1 ≤ M ≤ 2,000,000,000
*/

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
		
		List<Integer> list = new ArrayList<>(); // 리스트 사용!
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++)
			list.add(Integer.parseInt(st.nextToken())); //리스트에 각 나무 길이 저장 
		
		// 나무 중 제일 높은 나무 선택 
		int max = Collections.max(list);
	
		//이진탐색에 필요한 변수 
		long low = 0;
		long high = max; // max로 안하고 200만?등 큰 수로 설정해도 됨!!
		long mid = 0;
		
		
		while(high >= low) {
			long sum = 0;
	
			mid = (low + high) / 2;
	//		System.out.println("mid: " + mid);
			
			for(int i = 0; i < N; i++) {
				long len = list.get(i) - mid; //각 나무 길이에서 mid 지점으로 자른다. 
				sum += (len >=0 ? len : 0); //잘린 윗부분 sum 계산
			}
		
	//		System.out.println("sum: " + sum);
			
			if(sum >= M) { //목표값보다 크면, low를 mid+1로, 다시 반복
				low = mid+1;
			}
			else if(sum < M) //목표값보다 작으면, 자르는 부분을 낮춰야하는ㄱ니까 high를 mid-1로. 
				high = mid -1;
	//		System.out.println();
		}
		
		System.out.println(high);
		
	}
}
