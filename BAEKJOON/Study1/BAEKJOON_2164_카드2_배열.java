package Study1;

import java.util.Scanner;

public class BAEKJOON_2164_카드2_배열 {

	public static void main(String[] args) {
		//N 입력받기
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int[] queue = new int[2*N+1];
		
		for(int i = 0; i < N; i++)
			queue[i] = i+1; //queue 배열 생성 완료
		
		// a는 첫 번째 인덱스, b는 마지막 인덱스 가리킨다. 
		
		//a를 오른쪽으로 하나 옮긴다.
		//이때 a == b 이면 break! 그 값 출력!
		//b 인덱스 뒤에 a 값을 복사해 넣어준다.
		
		int start = 0; // start는 첫번째 인덱스
		int end = N-1; //end는 마지막 인덱스 
		
		
		for(int i = 0; i < queue.length; i++) {
			start = start + 1; // start -> 2
			if(start >= end) {
				System.out.println(queue[end]);
				break;
			}

			queue[end + 1] = queue[start];
			
			start = start + 1;
			end = end + 1;
		}
		
		
	}	
}
