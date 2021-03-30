// A를 B로 바꾸는데 필요한 최소 연산

package 그래프;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_16953_AB {
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		search(A, B, 0);
		
		// B가 A가 될 수 없다면
		if(!check)
			System.out.println(-1);
	}
	
	static void search(int A, int B, int cnt) { // cnt : 탐색 횟수
		if(B == A) { // B가 A가 됐으면
			check = true;
			System.out.println(cnt + 1); // cnt 출력
			return;
		}
		
		if(B % 2 == 0) { // 2로 나누어 떨어지면
			B = B / 2;
//			System.out.println("B: " + B);
			search(A, B, cnt+1);
		}
		else if(B == 1) {
			return;
		}
		else if(Integer.toString(B).charAt(Integer.toString(B).length()-1) == '1') { // 끝자리가 1이면
			String tempB = Integer.toString(B).substring(0, Integer.toString(B).length()-1);
//			System.out.println("tempB: " + tempB);
			B = Integer.parseInt(tempB);
			search(A, B, cnt+1);
		}
		else {
			check = false;
			return;
		}
		}
}
