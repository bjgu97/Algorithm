

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_11866_요세푸스문제0 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " "); //공백으로 구분
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> list = new ArrayList<>();
		
		//queue 초기화
		for(int i = 0; i < N; i++) {
			queue.add(i+1);
		}
		
		int i = 0;
		//계속 반복
		while(true) {
			i++;
			if(i % K != 0) {
				int a = queue.poll();
				queue.add(a);
			}
			else {
				int a = queue.poll();
				list.add(a);
			}
			
			if(queue.isEmpty())
				break;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		sb.append(list.get(0));
		
		for(int j = 1; j < N; j++) {
			int num = list.get(j);
			sb.append(", ").append(num);
		}
		
		sb.append(">");
		
		System.out.println(sb);
	}

}
