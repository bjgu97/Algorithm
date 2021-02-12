/**
* @since 2021. 2. 10.
* @author bjgu9
* @see
* @mem
* @time
* @caution 첫 시도: 덱 -> list ->  deque로 iterator 사용 가능 -> 덱 
*			꼭 다시 풀어보기!!!
*/
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ_1021_회전하는큐 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 큐 크기
		int M = Integer.parseInt(st.nextToken()); // 뽑아내려는 수
		
		Deque<Integer> deque = new LinkedList<Integer>();
		
		for(int n = 0; n < N; n++) {
			deque.offer(n+1);
		} // list : 1 2 3
		
		
		st = new StringTokenizer(br.readLine());
		
		int cnt = 0;
		for(int m = 0; m < M; m++) {
			int num = Integer.parseInt(st.nextToken());
			
			while(true) {
				Iterator<Integer> it = deque.iterator();
				int idx = 0;
				
				while(it.hasNext()) {
					if(it.next() == num)
						break;
					idx++; //위치 찾음
				}
				
				
				if(deque.getFirst() == num) { // 첫번째 인덱스에 숫자 발견 하면
					deque.removeFirst(); // 제거
					break;
				}
				
				else {
					// 만약 1이 앞쪽에 있으면 
					// 앞에서 빼내기
					if(idx <= deque.size()/2) {
						deque.addLast(deque.removeFirst());
						cnt++;
					}
					else {
						deque.addFirst(deque.removeLast());
						cnt++;
					}

				}
			}
		}
		System.out.println(cnt);
	}
}

