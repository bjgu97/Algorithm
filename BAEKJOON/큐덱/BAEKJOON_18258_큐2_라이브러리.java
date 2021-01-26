package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BAEKJOON_18258_큐2_라이브러리 {
public static void main(String[] args) throws IOException {
	Queue<Integer> queue = new LinkedList<>();

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	StringBuilder sb = new StringBuilder();

	int N = Integer.parseInt(st.nextToken());
	int val = 0;

	for(int i=0; i<N; i++) {
	    
	    st = new StringTokenizer(br.readLine());
	    String s = st.nextToken();
	    switch(s) {
	    case "push":
	        val = Integer.parseInt(st.nextToken());
	        queue.add(val);
	        break;
	    case "front":
	        sb.append(queue.isEmpty() ? -1 : queue.peek()).append('\n');
	        break;
	    case "back":
	        sb.append(queue.isEmpty() ? -1 : val).append('\n');
	        break;
	    case "size":
	        sb.append(queue.size()).append('\n');
	        break;
	    case "pop":
	        sb.append(queue.isEmpty() ? -1 : queue.poll()).append('\n');
	        break;
	    case "empty":
	        sb.append(queue.isEmpty() ? 1 : 0).append('\n');
	        break;
	    }
	}
	System.out.println(sb);
}
}
