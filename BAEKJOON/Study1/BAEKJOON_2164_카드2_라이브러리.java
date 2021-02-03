package Study1;

import java.util.LinkedList; //자바에서 QUEUE는 linked list 이용
import java.util.Queue;
import java.util.Scanner;

public class BAEKJOON_2164_카드2_라이브러리 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		
		// Int형 QUEUE 선언
		Queue<Integer> queue = new LinkedList<>();  //제내릭? 자료형에 의존하지 않는 클래스 구현 방식 
				
		//1부터 N까지 삽입: cf) offer, add
		for(int i = 1; i <= N; i++) {
			queue.add(i); 
		}
		
		while(queue.size() > 1) {
			queue.remove(); 
			// cf) poll : remove head of queue + return head of queue
			//            반환값 안받아도 됨. 
			//     remove : 첫번째값 remove. 
			
			queue.offer(queue.poll()); //return head of queue
		}
		
		System.out.println(queue.poll()); //return 첫번쨰 값. 
	}

}


/*
 * clear: QUEUE 초기화
 * peek : 첫번째 값 참조
 */
