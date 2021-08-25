

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_1991_트리순회 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N;
	static List<Character> list1;
	static List<Character> list2;
	static List<Character> list3;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		list1 = new ArrayList<Character>();
		list2 = new ArrayList<Character>();
		list3 = new ArrayList<Character>();
		
		char[][] Arr = new char[N][3];
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			Arr[n][0] = st.nextToken().charAt(0);
			Arr[n][1] = st.nextToken().charAt(0);
			Arr[n][2] = st.nextToken().charAt(0);
		}
		
		preorder(Arr);
		inorder(Arr);
		postorder(Arr);
		
		System.out.println(sb);
	}
	
	public static void preorder(char[][] arr) {
		for(int n = 0; n < N; n++) {
			if(list1.isEmpty()) {
				list1.add(arr[n][0]);
				list1.add(arr[n][1]);
				list1.add(arr[n][2]);
			}
			else {
				if(list1.contains(arr[n][0])) {
					list1.add(list1.indexOf(arr[n][0])+1, arr[n][1]);
					list1.add(list1.indexOf(arr[n][0])+2, arr[n][2]);
				}
			}
		}
		
//		System.out.println(list1);
		for(char c:list1) {
			if(c != '.') {
				sb.append(c);
			}
		}
		sb.append("\n");
	}
	
	public static void inorder(char[][] arr) {
		for(int n = 0; n < N; n++) {
			if(list2.isEmpty()) {
				list2.add(arr[n][1]);
				list2.add(arr[n][0]);
				list2.add(arr[n][2]);
			}
			else {
				if(list2.contains(arr[n][0])) {
					list2.add(list2.indexOf(arr[n][0]), arr[n][1]);
					list2.add(list2.indexOf(arr[n][0])+1, arr[n][2]);
				}
			}
		}
		
//		System.out.println(list2);
		for(char c:list2) {
			if(c != '.') {
				sb.append(c);
			}
		}
		sb.append("\n");
	}
	
	public static void postorder(char[][] arr) {
		for(int n = 0; n < N; n++) {
			if(list3.isEmpty()) {
				list3.add(arr[n][1]);
				list3.add(arr[n][2]);
				list3.add(arr[n][0]);
			}
			else {
				if(list3.contains(arr[n][0])) {
					list3.add(list3.indexOf(arr[n][0]), arr[n][1]);
					list3.add(list3.indexOf(arr[n][0]), arr[n][2]);
				}
			}
		}
		
//		System.out.println(list3);
		for(char c:list3) {
			if(c != '.') {
				sb.append(c);
			}
		}
		sb.append("\n");
	}
}
