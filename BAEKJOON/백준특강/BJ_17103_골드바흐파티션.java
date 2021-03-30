package 백준특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_17103_골드바흐파티션 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[1000001];
		Arrays.fill(arr, true);
		arr[1] = false;
		for(int i = 2; i < arr.length; i++) {
			for(int j = i * 2; j < arr.length; j+= i) {
				arr[j] = false;
			}
		}
		
//		System.out.println(Arrays.toString(arr));
		
		for(int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			
		}
	}
}
