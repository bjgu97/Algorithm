//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.Arrays;
//
//public class BJ_1032_명령프롬프트 {
//	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();
//		int N = Integer.parseInt(br.readLine());
//		
//		String[] fileNames = new String[N];
//		
//		for(int n= 0; n < N; n++) {
//			fileNames[n] = br.readLine(); // 배열에 파일 이름들 저장
//		}
//		
////		System.out.println(Arrays.toString(fileNames));
//		int fileLen = fileNames[0].length(); // 파일 길이 다 동일
//		boolean flag = true;
//		
//		for(int i = 0; i < fileLen; i++) {
//			flag = true;
//			for(int j = 0; j < N-1; j++) {
//				if(fileNames[j].charAt(i) == fileNames[j+1].charAt(i)) { // 문자 동일하면
//					flag = true; // 추가.
//				}
//				else { // 문자 다르면
//					flag = false; // '?' 추가
//					break;
//				}
//			}
//			
//			if(flag)
//				sb.append(fileNames[0].charAt(i));
//			else
//				sb.append('?');
//		}
//		
//		System.out.println(sb);
//	}
//}

import java.io.*;
import java.util.*;

public class BJ_1032_명령프롬프트 {

	static int N;
	static char[][] strs;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		strs = new char[50][N];
		int stringLen = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			stringLen = s.length();
			for (int j = 0, len = s.length(); j < len; j++) {
				strs[j][i] = s.charAt(j);
			}
		}
//
//		for(char[] a : strs)
//			System.out.println(Arrays.toString(a));
//		
		for (char[] rows : strs) {
			Arrays.sort(rows);
//			System.out.println(Arrays.toString(rows));
		}

//		for(char[] a : strs)
//			System.out.println(Arrays.toString(a));

		
		for (int i = 0; i < 50; i++) {
			System.out.println("strs[i][0]:" + strs[i][0]);
			if (strs[i][0] == '\0') {
				System.out.println("@@@");
				break;
			}
			if (strs[i][0] == strs[i][N-1]) {
				sb.append(strs[i][0]);
			} else {
				sb.append("?");
			}
		}
		System.out.println(sb);
	}

}