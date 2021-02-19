import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_3052_나머지 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[1000];
		
		for(int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[num%42] = true;
		}
		
		int answ = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i])
				answ++;
		}
		
		System.out.println(answ);
	}
}
