import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class JO_1205_조커 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
//		List<Integer> zeros = new ArrayList<Integer>();
//		List<Integer> nums = new ArrayList<Integer>();
////		boolean[] bArr = new boolean[1000001];
//
//		// 일단 숫자와 조커 따로 저장. 
//		for(int n = 0; n < N; n++) {
//			int a = Integer.parseInt(st.nextToken());
//			if(a == 0) {
//				zeros.add(a);
//			}
//			else {
//				nums.add(a);
//			}
//		}
//		
//		// Boolean 배열에다가.
//		boolean[] arr = new boolean[1000001];
//		for(int i = 0; i < nums.size(); i++) {
//			arr[nums.get(i)] = true;
//		}
//		// 0 6 5 10 3 0 11
//		// [F, F, F, T, F, T, T, F, F, F, T, T]
//		
//		
//		// Boolean 배열 처음부터 탐색
////		int start = 0; // 시작점
//		int answ = 0;
//		int zeroSize = zeros.size();
//		int maxAnsw = 0; // 최대 길이
//		int maxmaxAnsw = 0;
////		int i = start;
//		
////		48
////		0 1 1000 2000 3000 4000 5000 6000 7000 8000 9000 10000 11000 12000 13000 14000 15000 16000 17000 18000 19000 20000 21000 22000 23000 24000 25000 26000 27000 28000 29000 30000 21000 22000 23000 24000 25000 26000 27000 28000 29000 30000 20000 300000 999997 999998 999999 1000000
//
////		7 
////		0 6 5 10 3 0 11
//		
//		// 0 6 5 10 3 0 11
//		// [F, F, F, T, F, T, T, F, F, F, T, T]
//		
//		for(int start = 0; start < arr.length; start++) {
//
//			for(int i= start; i < arr.length; i++) {
////				System.out.println("start: " + start);
////				System.out.println("i: " + i);
//	//			System.out.println(start);
//				if(arr[i] == true) { // true이면 하나씩 세주기
//					answ++;
//				}
//				
//				else if(arr[i] == false) { // false가 나왔을 때
//					if(zeroSize > 0) { // 0이 남아있으면
//						answ++;
//						zeroSize--; // 0 하나 사용하기
//					}
//					
//					else if(zeroSize == 0){ // 0이 더이상 없으면
//						maxAnsw = Math.max(maxAnsw, answ); // answ 값 저장 
//						zeroSize = zeros.size(); // zero 개수 초기화
//						answ = 0;
//						break;
//					}
//				}
//			}
//			
//			maxmaxAnsw = Math.max(maxmaxAnsw, maxAnsw);
//		}
//		System.out.println(maxmaxAnsw);

	}
}
