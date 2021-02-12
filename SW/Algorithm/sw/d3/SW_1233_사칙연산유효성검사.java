package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SW_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 0; tc <10; tc++) {
			int check = 0;

			int totalNum = Integer.parseInt(br.readLine()); //171
			for(int tn = 0; tn < totalNum; tn++) {
				st = new StringTokenizer(br.readLine()); // 1 - 2 3
				
				int num = Integer.parseInt(st.nextToken());
				
				char a = st.nextToken().charAt(0);
				if(a == '+' || a == '-' || a == '/' || a == '*') {
					//System.out.println("연산기호");
					check++;
				}
				else {  // 숫자이면
					if(st.hasMoreTokens()) {
						//System.out.println("숫자 다음 또 숫자");
						check--;
					}
					else {
						//System.out.println("숫자");
						check++;	
					}
						
				}
				//System.out.println("num: " + num);
				//System.out.println("tn: " + tc);
			}
			//System.out.println(tc + ": " + check);
			sb.append("#").append(tc+1).append(" ");
			if(check == totalNum)
				sb.append(1).append("\n");
			else
				sb.append(0).append("\n");
		}
		System.out.println(sb);
		
		
	}

}
