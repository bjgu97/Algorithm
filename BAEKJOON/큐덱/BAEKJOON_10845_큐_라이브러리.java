package 큐덱;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_10845_큐_라이브러리 {

	static int n = 0;
	
   public static void main(String[] args) {
    Queue<Integer> que = new LinkedList<>();
    
    Scanner scan = new Scanner(System.in);
    
    int cnt = scan.nextInt();
    for(int i=0; i<cnt; i++) {
    	
    	String a = scan.next();
    	
    	if(a.equals("push")) {
    		n = scan.nextInt();
    		que.add(n);
    	}
    	else if(a.equals("front")){
    		System.out.println(que.isEmpty() ? -1 : que.peek());
    	}
    	else if(a.equals("back")) {
    		System.out.println(que.isEmpty() ? -1 : n);
    	}
    	else if(a.equals("size")) {
    		System.out.println(que.size());
    	}
    	else if(a.equals("pop")) {
    		System.out.println(que.isEmpty() ? -1 : que.poll());
    	}
    	else if(a.equals("empty")) {
    		System.out.println(que.isEmpty() ? 1 : 0);
    	}
    }
   }
}