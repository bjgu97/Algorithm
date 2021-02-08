package Algorithm.sw.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//0.12320
public class SW_1228_암호문1 {
	static BufferedReader br;
	static StringTokenizer st;
	static StringBuilder sb;
	
	static List<Integer> list;
	
	static int cnt;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		for(int t = 0; t < 10; t++) {
			// 암호문 길이 N 입력받기
			int N = Integer.parseInt(br.readLine());
			
			// 암호문 N개 입력받기
			list = new ArrayList<Integer>();
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			//명령어 개수 M
			int M = Integer.parseInt(br.readLine());
			
			//삽입 명령
			st = new StringTokenizer(br.readLine());
			cnt = 0;
			while(true) {
				if(st.nextToken().charAt(0) == 'I') {
					cnt++;
					int pos = Integer.parseInt(st.nextToken());
					int num = Integer.parseInt(st.nextToken());
					for(int p = 0; p < num; p++) 
						list.add(pos++, Integer.parseInt(st.nextToken()));
					}
				if(cnt ==  M)
					break;
				}
			
			sb.append("#").append(t+1).append(" ");
			for(int i = 0; i < 10; ++i) {
				sb.append(list.get(i)).append(" ");	
			}
			sb.append("\n");
		}
		System.out.println(sb);
		}
	}

