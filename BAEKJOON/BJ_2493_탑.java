

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2493_탑 {
	static int N;
	static int[] arr;

	static Stack<Integer> tower = new Stack<Integer>(); //타워높이 저장 스택
	static Stack<Integer> index = new Stack<Integer>(); //타워높이 인덱스 저장 스택
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//타워 개수
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		
		// 배열에다 타워 높이 저장
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		// 우선 첫번재 타워는 0이니까,, 처리
		tower.push(arr[0]);
		index.push(1);
		
		sb.append(0).append(" ");

		//두번쨰 타워부터,,
		for (int i = 1; i < N; i++) {
			while (true) {
				
				if (tower.isEmpty() == false) {
					if (tower.peek() > arr[i]) { //왼쪽의 타워가 더 크면
						sb.append(index.peek()).append(" "); //답 저장
						tower.push(arr[i]); //현재 타워 스택에 쌓기. 
						index.push(i+1);
						break;
					} 
					else { //왼쪽의 타워가 더 작으면
						tower.pop(); //없애주기
						index.pop();
						
						if(tower.isEmpty()) {
							tower.push(arr[i]);
							index.push(i+1);
							sb.append(0).append(" ");
							break;
						}
					}
				}
			}
		}
		System.out.println(sb);
	}
}
