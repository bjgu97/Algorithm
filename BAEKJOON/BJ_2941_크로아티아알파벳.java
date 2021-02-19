import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ_2941_크로아티아알파벳 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		Queue<Character> queue = new LinkedList<Character>();
		
		// 큐에 다 삽입
		for(int i = 0; i < s.length(); i++) {
			queue.offer(s.charAt(i));
		}
		
		int answ = 0;
		while(!queue.isEmpty()) {
			char c = queue.poll(); // 하나씩 뽑아서 비교 확인
			
			if(queue.size() == 0) { // 마지막 글자를 뽑았으면
				answ++;
				break;  //런타임에러방지
			}
			
			if(c == 'c') {
				if(queue.peek() == '=' || queue.peek() == '-') { // c 다음에 =나 - 나오면
					answ++; 
					queue.poll();
				}
				else {
					answ++;
				}
			}
			else if(c == 'd') {
				if(queue.peek() == '-') { // d 다음에 - 나오면
					answ++;
					queue.poll();
				}
				else if(queue.peek() == 'z') {  // d 다음에 z 나오면
					queue.poll();
					if(queue.isEmpty()) {
						answ += 2;
						continue;
					}
					if(queue.peek() == '=') {
						queue.poll();
						answ++;
					}
					else {
						answ += 2;
					}
				}
				else
					answ++;
			}
			else if(c == 'l' ) {
				if(queue.peek() == 'j') {
					answ++;
					queue.poll();
				}
				else
					answ++;
			}
			else if(c == 'n') {
				if(queue.peek() == 'j') {
					answ++;
					queue.poll();
				}
				else
					answ++;
			}
			else if(c == 's') {
				if(queue.peek() == '=') {
					answ++;
					queue.poll();
				}
				else
					answ++;
			}
			else if(c == 'z') {
				if(queue.peek() == '=') {
					answ++;
					queue.poll();
				}
				else
					answ++;
			}
			else {
				answ++;
			}

		}
		
		System.out.println(answ);


	}
}
