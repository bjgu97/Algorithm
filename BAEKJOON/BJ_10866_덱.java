

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_10866_덱 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		int N = Integer.parseInt(br.readLine()); // 명령어 수
		int num = 0;
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
			case "push_front":
				num = Integer.parseInt(st.nextToken());
				deque.addFirst(num);
				break;
			case "push_back":
				num = Integer.parseInt(st.nextToken());
				deque.addLast(num);
				break;
			case "pop_front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollFirst()).append("\n");
				break;
			case "pop_back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.pollLast()).append("\n");
				break;
			case "size":
				sb.append(deque.size()).append("\n");
				break;
			case "empty":
				if(deque.isEmpty())
					sb.append(1).append("\n");
				else
					sb.append(0).append("\n");
				break;
			case "front":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekFirst()).append("\n");
				break;
			case "back":
				if(deque.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(deque.peekLast()).append("\n");
				break;
			}
		
		}
		System.out.println(sb);
	}

}
