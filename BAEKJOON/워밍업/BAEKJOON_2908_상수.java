package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BAEKJOON_2908_상수 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line =br.readLine().split(" ");
		
		int A = Integer.parseInt(line[0]);
		int B = Integer.parseInt(line[1]);
		
		int AR = (A%10)*100 + (A%100)/10 * 10 + (A/100);
		int BR = (B%10)*100 + (B%100)/10 * 10 + (B/100);
		
		if(AR > BR)
			System.out.println(AR);
		else
			System.out.println(BR);
		/*
		//입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> nums = new ArrayList<Integer>();
		
		String AString = String.valueOf(A);
		String BString = String.valueOf(B);
		
		char[] AStringChar = new char[3];
		char[] BStringChar = new char[3];
		
		for(int i = 0; i < 3; i++) {
			AStringChar[2-i] = AString.charAt(i);
			BStringChar[2-i] = BString.charAt(i);
		}
		
		System.out.println(AStringChar[0]>BStringChar[0]?AStringChar:
			AStringChar[0] < BStringChar[0]?BStringChar:AStringChar[1] > BStringChar[1]?
					AStringChar:BStringChar[1] > AStringChar[1]?BStringChar:AStringChar[2]>BStringChar[2]?
							AStringChar:BStringChar);
		
//		if(AStringChar[0] > BStringChar[0])
//			System.out.println(AStringChar);
//		else if(AStringChar[0] < BStringChar[0])
//			System.out.println(BStringChar);
//		else {
//			if(AStringChar[1] > BStringChar[1])
//				System.out.println(AStringChar);
//			else if(BStringChar[1] > AStringChar[1])
//				System.out.println(BStringChar);
//			else {
//				if(AStringChar[2] > BStringChar[2])
//					System.out.println(AStringChar);
//				else
//					System.out.println(BStringChar);
 
 */
			}
}
