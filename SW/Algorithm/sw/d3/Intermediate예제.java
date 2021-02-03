//package Algorithm.sw.d3;
///*
// 입력:
// 1
//9
//XXXXXXXXX
//XXXHXXXXX
//XXHAHXXHX
//XXHHXXXXX
//XXXXXXXXX
//XXAHHXXXX
//XXHXXHAHX
//XXAHXXHXX
//XXHXHXXXX
//XXXXXXXXX
// */
//import java.util.Scanner;
//
//public class Intermediate예제 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T;
//		T = sc.nextInt();
//
//		int AnswerN = 0;
//		int N;
//
//		for (int test_case = 1; test_case <= T; test_case++) {
//			N = sc.nextInt();
//			char[][] map = new char[N][N];
//
//			for (int i = 0; i < N; i++) {
//				String currentLine = sc.next();
//				for (int j = 0; j < N; j++) {
//					map[i][j] = currentLine.charAt(j);
//				}
//			}
//			
//			for(int i = 0; i < N; i++) {
//				for(int j= 0; i < N; j++) {
////					if(map[i][j] == 'A' || map[i][j] == 'B' || map[i][j] == 'C') {\
//					if(map[i][j] != 'X' && map[i][j] != 'H') { //기지국 찾음
//						int cover = map[i][j] - 'A' + 1; // A, B, C가 커버하는 영역의 거리
//						for(int c = 1; c <= cover; c++) {
//							if(i-c >= 0 && map[i-c][j] == 'H')  //up
//								map[i-c][j] = 'X';
//							if(i+c < N && map[i+c][j] == 'H') //down 
//								map[i+c][j] = 'X';
//							if(j-c >=  0 && map[i][j-c] == 'H') //left {}
//								map[i][j-c] = 'X';
//							if(j+c < N && map[i][j+c] == 'H') 
//								map[i][j+c] = 'X';
//					}
//					}
//				} //end for j
//			} //end for i
//			
//			for(int i = 0; i < map.length; i++) {
//				for(int j = 0; j < map[i].length; j++) {
//					if(map[i][j] == 'H')
//						AnswerN++;
//				}
//			}
//			AnswerN = 0;  
//			
//			
//			
//
//			System.out.println("#" + test_case + " " + AnswerN);
//		}
//	}
//	
//	static void print(int[][] map) {
//		for(int i = 0; i < map.length; i++) {
//			for(int j = 0; j < map.length; j++) {
//				System.out.println(map[i][j]);
//			}
//		}
//	}
//
//}