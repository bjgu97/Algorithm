import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			String s = br.readLine();
			if(s.equals("0")) {
				break;
			}
			else {
				char[] arr = s.toCharArray();
				boolean flag = true;
				for(int i = 0; i < arr.length/2; i++) {
					if(arr[i] != arr[arr.length-1-i])
						flag = false;
				}
				
				if(flag)
					sb.append("yes").append("\n");
				else
					sb.append("no").append("\n");
			}
		}
		
		System.out.println(sb);
	}
}
