package 백트레킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_14888_연산자끼워넣기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] NArr = new int[N];
		for(int n = 0; n < N; n++) {
			NArr[n] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		List<Character> list = new ArrayList<Character>();
		for(int i= 0; i < 4; i++) {
			int C = Integer.parseInt(st.nextToken());
			for(int c = 0; c < C; c++) {
				if(i == 0)
					list.add('+');
				else if(i == 1) 
					list.add('-');
				else if(i == 2)
					list.add('*');
				else if(i == 3)
					list.add('/');
			}
		}
		
		answer = new char[list.size()];
		visited = new boolean[list.size()];
		permu(0, list, NArr);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	static char[] answer;
	static boolean[] visited;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	
	static void permu(int cnt, List<Character> list, int[] arr) {
		if(cnt == list.size()) {
			System.out.println(Arrays.toString(answer));
			System.out.println(Arrays.toString(arr));
			
			int num = arr[0];
			for(int i= 0; i < answer.length; i++) {
				if(answer[i] == '+') {
					num = num + arr[i+1];
				}
				else if(answer[i] == '-') {
					num = num - arr[i+1];
				}
				else if(answer[i] == '*') {
					num = num * arr[i+1];
				}
				else if(answer[i] == '/') {
					num = num / arr[i+1];
				}
//				System.out.println(num);
			}
			
			max = Math.max(max, num);
			min = Math.min(min, num);
			

			return;
		}
		
		for(int i = 0; i < list.size(); i++) {
			if(visited[i]) continue;
			
			answer[cnt] = list.get(i);
			visited[i] = true;
			permu(cnt+1, list, arr);
			visited[i] = false;
		}
		
	}
}
