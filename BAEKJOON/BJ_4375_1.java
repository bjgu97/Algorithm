import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class BJ_4375_1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// 2와 5로 나누어 떨어지지 않는 정수 n
		// 1로만 이루어진 n의 배수 중 가장 작은 수의 자리수?
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String s = br.readLine();
			if(s == null)
				break;
			else {
				int n = Integer.parseInt(s);
				int num = 0;
				
				for(int i = 0; ; i++) {
					num = (num * 10 + 1)%n;
					
					if(num == 0) {
						System.out.println(i+1);
						break;
					}
				}
			}
		}
	}
}
