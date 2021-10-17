

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SW_1225_암호생성기 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String line = null;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		
		while ((line = br.readLine()) != null ) {
			//테케 번호 입력받고
			int t = Integer.parseInt(line);
			
			// 값 8개 입력받기
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}
	    	
	    	// 알고리즘
	    	int i = 1;
	    	while(true) {
	    		int val = queue.poll();
	    		if(val-i <= 0) {
	    			queue.offer(0);
	    			break;	    
	    		}
	    		else {
	    			queue.offer(val-i);
	    		}
	    		i++;
	    		if(i > 5)
	    			i = 1;
	    	}

	    	sb.append("#").append(t).append(" ");
	    	for(int k= 0; k < 8; k++) 
	    		sb.append(queue.poll()).append(" ");
	    	sb.append("\n");
	    	queue.clear();
	   	    }
		
		System.out.println(sb);
	}
}
