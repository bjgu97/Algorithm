import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BJ_9421_소수상근수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		so(N);//999999
		
		for(int n = 1; n <= N; n++) {
			if(arr[n] && sang(n)) { // 소수이고 상근수이면
				System.out.println(n);
			}
		}
		
	}
	
	// 상근수 판단
	static boolean sang(int n) {
		Set<Integer> set = new HashSet<>();
		boolean check = true;
		
		while(true) {
			int sum = 0;
			String s = Integer.toString(n);
			for(int i = 0; i < s.length(); i++) {
				sum += ((s.charAt(i)-'0') * (s.charAt(i) - '0'));
			}
			n = sum;
			
			if(n == 1) { // 1이 되는 수 나오면
				break;
			}
			else if(set.contains(n)) { // 나왔던 수 반복해서 나오면
				check = false;
				break;
			}
			else {
				set.add(n);
			}
			
		}
		
		return check;
	}
	
	
	static boolean[] arr;
	static void so(int n) {
		arr = new boolean[1000001];
		Arrays.fill(arr, true);
		
		arr[1] = false; //1은 소수 아님
		
		for(int i = 2; i < 1000001; i++) {
			for(int j = i * 2; j < 1000001; j += i) {
				arr[j] = false;
			}
		}
	}
	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int N = Integer.parseInt(br.readLine());
//		
//		for(int n = 1; n <= N; n++) {
//			if(so(n) && sang(n)) { // 상근수이고 수수이면
//				System.out.println(n);
//			}
//		}
//		
//	}
//	
//	// 상근수 판단
//	static boolean sang(int n) {
//		boolean check = true;
//
//		boolean[] temp = new boolean[500];
//		Arrays.fill(temp, false);
//		temp[n] = true;
//		
//		while(true) {
//			int sum = 0;
//			String s = Integer.toString(n);
//			for(int i = 0; i < s.length(); i++) {
//				sum += ((s.charAt(i)-'0') * (s.charAt(i) - '0'));
//			}
//			n = sum;
//			
//			if(n == 1) { // 1이 되는 수 나오면
//				break;
//			}
//			else if(temp[n] == true) { // 나왔던 수 반복해서 나오면
//				check = false;
//				break;
//			}
//			else {
//				temp[n] = true;
//			}
//			
//		}
//		
//		return check;
//	}
//	
//	
//	static boolean so(int n) {
//		boolean[] arr = new boolean[1000001];
//		Arrays.fill(arr, true);
//		
//		arr[1] = false; //1은 소수 아님
//		
//		for(int i = 2; i < 1000001; i++) {
//			for(int j = i * 2; j < 1000001; j += i) {
//				arr[j] = false;
//			}
//		}
//		
//		return arr[n];
//	}
}
