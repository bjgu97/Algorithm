/**
* @since 2021. 2. 16.
* @author bjgu9
* @see
* @mem
* @time
* @caution 조합 이용
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3040_백설공주와일곱난쟁이 {
	static int[] arr;
	static int sum;
	static int[] answer;
	
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9]; // 난쟁이들 저장용
		answer = new int[7];
		
		for(int i = 0; i < 9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		comb(0, 0);
		
		System.out.println(sb);
	}
	
	public static void comb(int cnt, int start) {
		if(cnt == 7) {
			int sum = 0;
			for(int i = 0; i < 7; i++) {
				sum += answer[i];
			}
			if(sum == 100){
				for(int i = 0; i < 7; i++) {
					sb.append(answer[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i = start; i < arr.length; i++) {
			answer[cnt] = arr[i];
			comb(cnt+1, i+1);
		}
		
	}
}
