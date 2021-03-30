package 백준특강;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_13706_제곱근 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		BigInteger n = new BigInteger(s);
		
		
		search(n);
	}
	
	static void search(BigInteger n) {
		BigInteger start = new BigInteger("1");
		BigInteger end = n;
		
		while(start.compareTo(end) <=0 ) {
			BigInteger mid = (start.add(end)).divide(new BigInteger("2"));
			
			BigInteger answ = mid.multiply(mid);
			
			if(answ.compareTo(n) == 1) {
				end = mid.subtract(BigInteger.ONE);
			}
			else if(answ.compareTo(n) == -1) {
				start = mid.add(BigInteger.ONE);
			}
			else if(answ.compareTo(n) == 0) {
				System.out.println(mid);
				break;
			}
		}
	}
}
