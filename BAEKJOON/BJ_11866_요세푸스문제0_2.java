/**
* @since 2021. 2. 9.
* @author bjgu9
* @see https://www.acmicpc.net/problem/11866
* @mem 
* @time
* @caution
* 
* second trial
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_11866_요세푸스문제0_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		List<Integer> list = new LinkedList<>();
		
		for(int n = 0; n < N; n++) {
			queue.offer(n+1);
		} // queue : 1 2 3 4 5 6 7
		
		int cnt = 0;
		while(true) {
			cnt++;
			if(queue.isEmpty())
				break;
			
			if(cnt%K != 0) {
				queue.offer(queue.poll());
			}
			else if(cnt%K == 0) {
				list.add(queue.poll());
			}
		}
		
		sb.append("<");
		sb.append(list.get(0));
		
		for(int i = 1;i < list.size(); i++) {
			sb.append(", ").append(list.get(i));
		}
		sb.append(">");
		
		System.out.println(sb);
	}
}
