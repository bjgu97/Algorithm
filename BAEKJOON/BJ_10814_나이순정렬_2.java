

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_10814_나이순정렬_2 {
	static class Point implements Comparable<Point> {
		int age;
		String name;
		
		Point(int age, String name) {
			this.age = age;
			this.name = name;
		}

		@Override
		public int compareTo(Point o) {
			return Integer.compare(o.age, age)*(-1);
		}

		@Override
		public String toString() {
			return "Point [age=" + age + ", name=" + name + "]";
		}
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<Point> list = new LinkedList<>();
	
		for(int n = 0; n < N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			
			list.add(new Point(age, name));
		}
		
		Collections.sort(list);
		
		for(Point p : list) {
			System.out.println(p.age + " " + p.name);
		}
	}
}
