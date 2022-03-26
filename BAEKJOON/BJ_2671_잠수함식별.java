import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ_2671_잠수함식별 {
	// 잠수함 소리는 0, 1의 연속
	// 특정한 소리의 반복: ~      x~ : xxx / (xyz)~ : xyzxyz
	// 둘중 하나 선택: |
	// (0|1)~ : 0 과 1로 이루어진 모든 소리 집합
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String S = br.readLine();
		
		String pattern = "^(100+1+|01)+";
		if(S.matches(pattern)) {
			System.out.println("SUBMARINE");			
		}
		else {
			System.out.println("NOISE");
		}
//		char[] arr = S.toCharArray();
//		
//
//		boolean isSubmarine = check(arr);
//		if(isSubmarine) {
//			System.out.println("SUBMARINE");
//		}
//		else {
//			System.out.println("NOISE");
//		}
//	}
//	
//	// 100~1~ 과 01 를 섞어서 만들 수 있는 모든 스트링 집합
//	
//	// 1 나오면, 100~1~ 인지 확인
//	// 0 나오면, 01인지 확인
//	
//	static boolean check(char[] arr) {
//		int start = 0;
//		int end = arr.length-1;
//		
//		// 100000000001101
//		while(start < end) {
//			System.out.println("start: " + start);
//			
//			// CASE1: 0 으로 시작 (01)
//			if(arr[start] == '0') {
//				System.out.println("!!! 0으로 시작");
//				if(arr[start+1] == '0') // 0 다음에 1이 안나오먄
//					return false;
//				if(start == end) // 0이 마지막에 나오면
//					return false;
//				if(arr[start+1] == '1')
//					start += 2; // 0 다음에 1이 나오면 start 위치 이동.
//			}
//			
//			// CASE2: 1로 시작 (100~1~)
//			if(arr[start] == '1') {
//				System.out.println("??? 1로 시작");
//				// 1 다음에 00 안나오면
//				if(!(arr[start+1] == '0' && arr[start+2] == '0')) { 
//					System.out.println("??? 1 다음 00 안나옴");
//					return false;
//				}
//				
//				// 1 다음에 0 나오면,
//				boolean flag = false;
//				while(true) {
//					start++;
//					System.out.println("??? start: " + start);
//					if(start == end) { // 끝까지 0만 나오면
//						break;
//					}
//					if(arr[start] == '0') {
//						continue;
//					}
//					else {
//						System.out.println("??? 1 발견");
//						flag = true;
//						break;
//					}	
//				}
//				
//				System.out.println("??? flag: " + flag);
//				
//				if(!flag) {
//					return false;
//				}
//				
//				start++;
//				
//				boolean flag2 = false;
//				if(flag && arr[start] == '1') { // 00~1 다음에 1 나오면
//					System.out.println("??? 1 나옴");
//					while(true) {
//						System.out.println("@@@ start: " + start);
//						start++;
//						
//						if(start == end) { // 00~1 다음에 끝까지 쭉 1만 나옴.
//							System.out.println("end: " + end);
//							System.out.println("@@@ 끝까지 1만 나옴");
//							flag2 = true;
//							break;
//						}
//						
//						if(start + 2 < end && arr[start+1] == '0' && arr[start+2] == '0') { // 100~1~ 새로 시작 가능하면,
//							System.out.println("@@@ 새로 시작 가능");
//							break;
//						}
//						
//						if(arr[start+1] == '0' && start+1 == end) {
//							System.out.println("??? 0으로 끝남");
//							return false;
//						}
//						else if(arr[start+1] == '0') {
//							System.out.println("??? 0 등장");
//							break;
//						}
//						if(arr[start] == '1') { // 1이 계속 나와야함
//							System.out.println("@@@ 1 또 나옴");
//							continue;
//						}
//						
//					}
//				}
//			}
//		}
//		
//		return true;
	}
}

// 반례 1000010
// 반례 10000110

