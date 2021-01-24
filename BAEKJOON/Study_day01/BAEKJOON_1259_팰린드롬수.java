package Study_day01;

import java.util.Scanner;

public class BAEKJOON_1259_팰린드롬수 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		
		for(int t = 0; t < T; t++) {
			int H = scan.nextInt(); //호텔 층 수
			int W = scan.nextInt(); //각 층의 방 수
			int N = scan.nextInt(); //몇번째 손님인지
			
			// 손님은 아래서부터 위로 채워짐
			int y = N % H; //층은 N / H의 나머지  
			
			int x = N/H + 1; // 호실은 몇번 나누어지는지 ( + 1)
			
			if(N%H==0) {
                x = N/H;
                y = H;
            }
			System.out.printf("%d%02d\n", y, x); //문자열 포매팅: 0으로 채우기
		}
		}
	}

