package 워밍업;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_2292_벌집 {
public static void main(String[] args) throws NumberFormatException, IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(br.readLine());
	
	int answ = 1;
	int n = 2;
	int k = 1;
	if(N == 1)
		answ = 1;
	else {
		while(n <= N) {
			n += 6*answ;
			answ++;
		}
	}
	
	System.out.println(answ);
	
}
}
