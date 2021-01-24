package CLASS1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BAEKJOON_2442_별찍기5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			for(int j = (2*N+1)/2; j > i; j--) {
				bw.write(' ');
			}
			for(int j = 1; j <= 2*i-1; j++) {
				bw.write('*');
			}
			bw.newLine();
		}
		bw.flush();
	}

}
