

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BAEKJOON_17478_재귀함수가뭔가요 {
	static String str1 = "\"재귀함수가 뭔가요?\"";
	static String str2 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
	static String str3 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
	static String str4 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
	static String str5 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"";
	static String str6 = "라고 답변하였지.";
	
	static StringBuilder sb;
	
	static String under  = "";
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb = new StringBuilder();
		sb.append("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.").append("\n");
		func(N);
		System.out.println(sb);
	}
	
	public static void func(int N) {
		if(N == 0) {
			sb.append(under).append(str1).append("\n");
			sb.append(under).append(str5).append("\n");
			sb.append(under).append(str6).append("\n");
			return;
		}
		
		sb.append(under).append(str1).append("\n");
		sb.append(under).append(str2).append("\n");
		sb.append(under).append(str3).append("\n");
		sb.append(under).append(str4).append("\n");
		
		under += "____";
		func(N-1);
		
		sb.append(under).append(str6).append("\n");
	}
}
