package 재귀;

import java.util.Scanner;

public class BJ_10870_피보나치수5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(fibo(n));
	}
	
	public static int fibo(int n) {
		if(n == 0)
			return 0;
		else if(n == 1)
			return 1;
		else
			return fibo(n-2) + fibo(n-1);
	}
}
