/**
* @since 2021. 2. 12.
* @caution 덱 사용보다 문자열 파싱?이 더 어려웠던 문제
*/
package 큐덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BJ_5430_AC {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int T = Integer.parseInt(br.readLine()); // 테케
		
		for(int t = 0; t < T; t++) { // 100
			Deque<Integer> deque = new ArrayDeque<>();
			Deque<Integer> temp = new ArrayDeque<>();
			
			// 입력받기
			String p = br.readLine(); // 수행할 함수
			int n = Integer.parseInt(br.readLine()); // 배열 크기
			String num = br.readLine();
			
			// 입력받은거 처리(?) - 수행 함수
			char[] nArr = new char[p.length()]; // 명령어
			for(int i = 0;i < p.length(); i++) {
				nArr[i] = p.charAt(i);
			}
			
			// 입력받은거 처리 - 배열
			num = num.substring(1, num.length()-1); // 앞뒤 [, ] 제거
			st = new StringTokenizer(num, ",");
			for(int i = 0; i < n; i++) {
				deque.offer(Integer.parseInt(st.nextToken()));
			}
			
			//확인
//			System.out.println(nArr);
//			System.out.println(deque);
			
			boolean check = true; // 에러 발생 확인용
			boolean reverse = true; // reverse 시 필요
			
			// 수행함수 p 돌면서 확인
			for(int i = 0; i < p.length(); i++) { // 10만
				// 삭제 명령이면 -> 첫번쨰 숫자 버리기
				if(nArr[i] == 'D' && reverse == true) {
					if(deque.isEmpty()) { // 비어있으면 error
						check = false;
						break;
					}
					deque.removeFirst();
				}
				else if(nArr[i] == 'D' && reverse == false) {
					if(deque.isEmpty()) {
						check = false;
						break;
					}
					deque.removeLast();
				}
				// 순서변경 명령
				else if(nArr[i] == 'R') {
					if(deque.isEmpty()) {
						continue;
					}
					reverse = !reverse;
				}
			}
			int finalSize = deque.size();
			
			if(check) { // 에러가 나지 않았다면
				if(deque.isEmpty())
					sb.append("[]").append("\n");
				else {
					sb.append("[");
					if(reverse) {
						sb.append(deque.pollFirst());
						for(int i = 1; i < finalSize; i++) {
							sb.append(",").append(deque.pollFirst());
						}
					}					
					else {
						sb.append(deque.pollLast());
						for(int i = 1; i < finalSize; i++) {
							sb.append(",").append(deque.pollLast());
						}
					}
					
			
					sb.append("]").append("\n");
				}
			}
			else
				sb.append("error").append("\n");
			
			}
		
		System.out.println(sb);
	}
}
