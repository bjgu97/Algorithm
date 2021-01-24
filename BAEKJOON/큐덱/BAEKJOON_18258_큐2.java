package 큐덱;

import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_18258_큐2 {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	int N = scan.nextInt();
	
	int[] queue = new int[N];
	int front = 0;
	int end = 0;
	
	for(int i = 0; i < N; i++) {
		String order = scan.next();
		switch(order) {
		case "push":
			//정수 하나 더 입력받는다.
			int num = scan.nextInt();
			queue[end] = num;
			end ++;
			break;
		case "front":
			
			if(end == front)
				System.out.println("-1");
			else
				System.out.println(queue[front]);
			break;
		case "back":
			if(end == front)
				System.out.println("-1");
			else
				System.out.println(queue[end-1]);
			break;
		case "size":
			System.out.println(end - front);
			break;
		case "empty":
			if(end == front)
				System.out.println("1");
			else
				System.out.println("0");
			break;
		case "pop":
			if(front == end)
				System.out.println("-1");
			else {
				System.out.println(queue[front]);
				front++;
			}
		}
	}
}
}

