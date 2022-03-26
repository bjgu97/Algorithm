import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_8979_올림픽 {
	static class Country implements Comparable<Country>{
		int code;
		int rank;
		int gold;
		int silver;
		int bronze;
		
		Country(int code, int rank, int gold, int silver, int bronze) {
			this.code = code;
			this.rank = rank;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public String toString() {
			return code + "/" + rank;
		}

		@Override
		public int compareTo(Country c) {
			if(this.gold > c.gold) {
				return -1;
			}
			else if(this.gold < c.gold) {
				return 1;
			}
			else {
				if(this.silver > c.silver) {
					return -1;
				}
				else if(this.silver < c.silver) {
					return 1;
				}
				else {
					if(this.bronze > c.bronze) {
						return -1;
					}
					else if(this.bronze < c.bronze) {
						return 1;
					}
					else {
						return 1;
					}
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		List<Country> list = new ArrayList<>();
		
		for(int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int code = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());
			
			Country country = new Country(code, 0, gold, silver, bronze);
			list.add(country);
		}
		
		Collections.sort(list);
		
//		System.out.println(list);
		
		int rank = 1;
		int tmp = 1;
		list.get(0).rank = rank;
		for(int i = 1; i < list.size(); i++) {
			Country country2 = list.get(i);
			Country country1 = list.get(i-1);
			
			if(country1.gold == country2.gold && country1.silver == country2.silver && country1.bronze == country2.bronze) {
//				System.out.println("동일");
				country2.rank = rank;
				tmp++;
//				System.out.println(country2.rank + "/" + tmp);
			}
			else {
//				System.out.println("다음등수");
				country2.rank = ++tmp;
//				System.out.println(country2.rank);
				rank = tmp;
			}
		}
		
		for(Country country : list) {
			if(country.code == K) {
				System.out.println(country.rank);
				break;
			}
		}
	}
}
