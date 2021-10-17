import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class BJ_2002_추월 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		HashMap<String, Integer> hm1 = new HashMap<>();
//		HashMap<String, Integer> hm2 = new HashMap<>();
//		
//		for(int n = 0; n < N; n++) {
//			String s = br.readLine();
//			hm1.put(s, n);
//		}
//		
//		for(int n = 0; n < N; n++) {
//			String s = br.readLine();
//			hm2.put(s, n);
//		}
//		
//		
//		int answer = 0;
//		for(String key : hm1.keySet()) {
//			if(hm1.get(key) >= hm2.get(key))
//				answer++;
//		}
//		
//		System.out.println(answer);
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			hm.put(s, n);
		}
		
		int answer = 0;
		int[] arr = new int[N];
		
		for(int n = 0; n < N; n++) {
			String s = br.readLine();
			arr[n] = hm.get(s); 
		}
	
		for(int n = 0; n < N; n++) {
			for(int j = n; j < N; j++) {
				if(arr[n] > arr[j]) {
					answer++;
					break;
				}
			}
		}
		
		System.out.println(answer);
	}
}
