package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SW_1204_Flatten {

	//상자 100개 
	static int[] boxArr = new int[100];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		//10개의 테케
		
		for(int n = 1; n <= 10; n++){
		
			//덤프 횟수
			int N = Integer.parseInt(br.readLine());
			
			//상자 높이 입력받기(100)
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i =0; i < 100; i++) {
				boxArr[i] = Integer.parseInt(st.nextToken());
			}
			
			// 입력 받으면 출력해보기
			System.out.println(Arrays.toString(boxArr));
			
			
			for(int i = 0; i < N; i++) {
				Arrays.sort(boxArr);
				boxArr[0] += 1;
				boxArr[99] -= 1;
				
				if(boxArr[0] == boxArr[99]) // if(box[99] - box[0] <= 1)
					break;
			}
			
			Arrays.sort(boxArr);
			sb.append("#").append(n).append(" ").append(boxArr[99] - boxArr[0]).append("\n");
			
		}
		System.out.println(sb);
	}
}
