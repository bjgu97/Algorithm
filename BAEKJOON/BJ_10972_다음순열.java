import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;


public class BJ_10972_다음순열 {
	static int N;
	static int numbers[];
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i=0;i<N;i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}

		if(nextPerm()) {
			for(int i=0;i<N;i++)
				sb.append(numbers[i]).append(" ");
		}
		else
			sb.append(-1);
		
		System.out.println(sb);
	}
	
	public static boolean nextPerm() {
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
	
		if(i ==0) return false;
		
		int j = N-1;
		while(numbers[i-1]>=numbers[j]) --j;  
		
		swap(i-1,j);
		int k = N-1;
		while(i<k)
			swap(i++,k--);
		
		return true;
	}
	
	private static void swap(int i,int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}