import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BJ_1339_단어수학 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[26];
		for(int n = 0; n < N; n++) {
			String S = br.readLine();
			
			for(int s = 0; s < S.length(); s++) {
				char c = S.charAt(s);
				int digit = (int)Math.pow(10, S.length() - s-1);
				arr[c-65] += digit;
			}
		}
				
		Arrays.sort(arr);
		
		int answer = 0;
		int idx = 9;
		for(int i = 25; i >= 0; i--) {
			answer += (arr[i] * idx);
			idx--;
		}
		
		System.out.println(answer);
//		Map<Character, Integer> hm = new HashMap<>();
//		
////		for(int n = 0; n < N; n++) {
////			String S = br.readLine();
////		
////			for(int s = 0; s < S.length(); s++) {
////				char c = S.charAt(s);
////				int digit = (int)Math.pow(10, S.length() - s-1);
////				if(!hm.containsKey(c)) {
////					hm.put(c, digit);
////				}
////				// 맵에 알파벳 존재 하면
////				else {
////					int val = hm.get(c);
////					hm.put(c, val + digit);
////				}
////			}
////		}
////				
////		List<Map.Entry<Character, Integer>> entryList = new LinkedList<>(hm.entrySet());
////		
////		entryList.sort((o1, o2) -> hm.get(o2.getKey()) - hm.get(o1.getKey()));
////				
////		int idx = 9;
////		int answer = 0;
////		for(Map.Entry<Character, Integer> entry : entryList) {
////			answer += (entry.getValue() * idx);
////			idx--;
////		}
////		
////		System.out.println(answer);
		
	}
//	static char[][] numbers;
//	static boolean[] selected;
//	static int N;
//	static int finalAnswer;
//	
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		// N개의 단어
//		// 대문자를 0부터 9까지 숫자 중 하나로 바꿔서 N개 수 합
//		// 같은 알파벳은 같은 숫자로 바꾸기
//		// 수의 합 최대
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		
//		N = Integer.parseInt(br.readLine());
//		
//		char[][] arr = new char[N][8];
//		numbers = new char[N][8];
//		selected = new boolean[N];
//		
//		
//		for(int n = 0; n < N; n++) {
//			String s = br.readLine();
//			
//			int idx = 0;
//			for(int i = 0; i < 8-s.length(); i++) {
//				arr[n][i] = ' ';
//			}
//			for(int i = 8-s.length(); i < 8; i++) {
//				arr[n][i] = s.charAt(idx);
//				idx++;
//			}
//		}
//		
////		for(char[] a : arr)
////			System.out.println(Arrays.toString(a));
//	
//		perm(0, arr);
//		// 알파벳 저장
//		
//		
//		System.out.println(finalAnswer);
//	}
//	static void calc(char[][] arr) {
//		int[] alpha = new int[25];
//		int[][] tmp = new int[N][8];
//
//		Arrays.fill(alpha, -1);
//		
//		int num = 9;
//		for(int i = 0; i < 8; i++) {
//			for(int n = 0; n < N; n++) {
//				// 알파벳 존재하고, 전환 안된 상태면
//				char c = arr[n][i];
//				if(c != ' ' && alpha[c - 65] == -1) {
//					alpha[c-65] = num;
//					tmp[n][i] = num;
//					num--;
//				}
//				else if(c != ' ' && alpha[c-65] != -1) {
//					tmp[n][i] = alpha[c-65];
//				}
//			}
//		}
//		
////		for(int[] a : tmp)
////			System.out.println(Arrays.toString(a));
//		
//		int answer = 0;
//		for(int n = 0; n < N; n++) {
//			int[] numArr = tmp[n];
//			String s = "";
//			for(int i = 0; i < numArr.length; i++) {
//				s += numArr[i];
//			}
//
//			answer += Integer.valueOf(s);
//		}
//		
//		
//		finalAnswer = Math.max(finalAnswer, answer);
//	}
//	static void perm(int cnt, char[][] arr) {
//		if(cnt == arr.length) {
////			for(char[] a : numbers)
////				System.out.println(Arrays.toString(a));
////			System.out.println();
//			calc(numbers);
//			return;
//		}
//		
//		for(int i= 0; i < arr.length; i++) {
//			if(selected[i])
//				continue;
//			
//			numbers[cnt] = arr[i];
//			
//			selected[i] = true;
//			perm(cnt+1, arr);
//			selected[i] = false;
//		}
//	}
}
