package 큐덱;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BAEKJOON_10845_큐_라이브러리 {
   public static void main(String[] args) throws IOException {
	   /*
   }
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		int[] queue = new int[N];
		int front = 0;
		int end = 0;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String order =  st.nextToken();
	*/
	   //큐 선언
    Queue<Integer> queue = new LinkedList<>();
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
	//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

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
    		System.out.println(queue.isEmpty() ? -1 : queue.peek());
    		break;
    	case "back":
    		System.out.println(queue.isEmpty() ? -1 : val);
    		break;
    	case "size":
    		System.out.println(queue.size());
    		break;
    	case "pop":
    		System.out.println(queue.isEmpty() ? -1 : queue.poll());
    		break;
    	case "empty":
    		System.out.println(queue.isEmpty() ? 1 : 0);
    		break;
    	}
    }
   }
}