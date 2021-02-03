// N은 10만! 
package 정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class BAEKJOON_10814_나이순정렬 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		String[][] arr = new String[N][2];
		
		for(int i = 0; i < N;i++) {
			st = new StringTokenizer(br.readLine(), " ");
			String age = st.nextToken();
			String name = st.nextToken();

			arr[i][0] = age;
			arr[i][1] = name;
		}
		
		//방법1: compare 메소드 사용
		//https://st-lab.tistory.com/112#%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98
		Arrays.sort(arr, new Comparator<String[]>() {
			@Override
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1]).append("\n");
		}
		
		System.out.println(sb);
//		Arrays.sort(arr);
		

//		String[] arrNum = new String[N];
//		for(int i= 0; i < N; i++) {
//			arrNum[i] = arr[i][0];
//		}
//		
//		
		
//		int[] ageArr = new int[N];
//		String[] nameArr = new String[N];
//		
//		//각 나이 + 이름 배열에 순서대로 저장
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int age = Integer.parseInt(st.nextToken());
//			String name = st.nextToken();
//			
//			ageArr[i] = age;
//			nameArr[i] = name;
//			
//		}
//		
//		//숫자 정렬
//		Arrays.sort(ageArr);
		
		//hashmap -> key 중복 안됨
//		HashMap<Integer,String> map = new HashMap<>();
//		
//		for(int i = 0; i < N; i++) {
//			st = new StringTokenizer(br.readLine(), " ");
//			int age = Integer.parseInt(st.nextToken());
//			String name = st.nextToken();
//			map.put(age,  name);
//		}
//		
//		System.out.println(map.keySet());
		
		
}
}
