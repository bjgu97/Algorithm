package Study4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class BJ_2304_창고다각형 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int start = 0;
		int end  = 0;
		int maxHeight = 0;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[1001];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int pos = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[pos] = h;
			
			start = Math.min(start, pos); // 시작 위치
			end = Math.max(end, pos); // 끝 위치
			
			maxHeight = Math.max(maxHeight,  h); // 기둥 최대 높이 maxHeight
		}
		
		int pnt = 0;
		for(int n = 0; n < arr.length; n++) { // maxHeight 기둥 위치: pnt (8)
			if(arr[n] == maxHeight)
				pnt = n;
		}
		
		int answer = maxHeight;
		
		Stack<Integer> stackL = new Stack<>();
		Stack<Integer> stackR = new Stack<>();
		
		// 왼쪽
		int area1 = 0;
		for(int i = start; i < pnt; i++) { // 2부터 7까지
			area1 = Math.max(area1, arr[i]);
			stackL.push(area1);
//			System.out.println(stackL);	
		}
		
		// 오른쪽
		int area2 = 0;
		for(int i = end; i > pnt; i--) {
			area2 = Math.max(area2, arr[i]);
			stackR.push(area2);
//			System.out.println(stackR);
		}
		
		// 더하기
		int sizeL = stackL.size();
		for(int i = 0; i < sizeL; i++) {
			answer += stackL.pop();
		}
		
		int sizeR = stackR.size();
		for(int i = 0; i < sizeR; i++) {
			answer += stackR.pop();
		}
		
		System.out.println(answer);
	}
}
